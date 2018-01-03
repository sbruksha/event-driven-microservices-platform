package com.eodessa.notification.service;

import com.eodessa.notification.domain.NotificationType;
import com.eodessa.notification.domain.Recipient;
import com.eodessa.notification.repository.RecipientRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.Date;
import java.util.List;

@Service
@EnableBinding(Sink.class)
public class RecipientServiceImpl implements RecipientService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private RecipientRepository repository;

	@Autowired
	private EmailService emailService;

	@Override
	public Recipient findByAccountName(String accountName) {
		Assert.hasLength(accountName);
		return repository.findByAccountName(accountName);
	}

	private boolean defaultWelcomeEmail(String username) {
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	@HystrixCommand(fallbackMethod = "defaultWelcomeEmail")
	public boolean sendWelcomeEmail(String accountName){

		Recipient recipient = findByAccountName(accountName);
		try {
			emailService.send(NotificationType.WELCOME, recipient, "");
		} catch (Throwable t) {
			log.error("an error during remind sendWelcomeEmail for {}", recipient, t);
		}
		return true;
	}

	private void defaultReminderEmail(String appointmentId) {

	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	@HystrixCommand(fallbackMethod = "defaultReminderEmail")
	@StreamListener(Sink.INPUT)
	public void sendReminderEmail(String appointmentId){
		// Reminder Implementation
		log.info("Receive notification request reminder for appintment " + appointmentId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Recipient save(String accountName, Recipient recipient) {

		recipient.setAccountName(accountName);
		recipient.getScheduledNotifications().values()
				.forEach(settings -> {
					if (settings.getLastNotified() == null) {
						settings.setLastNotified(new Date());
					}
				});

		repository.save(recipient);

		log.info("recipient {} settings has been updated", recipient);

		return recipient;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Recipient> findReadyToNotify(NotificationType type) {
		switch (type) {
			case REMIND:
				return repository.findReadyForRemind();
			default:
				throw new IllegalArgumentException();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void markNotified(NotificationType type, Recipient recipient) {
		recipient.getScheduledNotifications().get(type).setLastNotified(new Date());
		repository.save(recipient);
	}
}
