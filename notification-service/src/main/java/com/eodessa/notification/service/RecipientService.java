package com.eodessa.notification.service;

import java.util.List;

import com.eodessa.notification.domain.NotificationType;
import com.eodessa.notification.domain.Recipient;

public interface RecipientService {

	/**
	 * Finds recipient by account name
	 *
	 * @param accountName
	 * @return recipient
	 */
	Recipient findByAccountName(String accountName);

	/**
	 * sendWelcomeEmail by account name
	 *
	 * @param accountName
	 * @return success flag
	 */
	boolean sendWelcomeEmail(String accountName);

	/**
	 * sendReminderEmail by appointment
	 *
	 * @param appointmentId
	 * @return success flag
	 */
	void sendReminderEmail(String appointmentId);

	/**
	 * Finds recipients, which are ready to be notified
	 * at the moment
	 *
	 * @param type
	 * @return recipients to notify
	 */
	List<Recipient> findReadyToNotify(NotificationType type);

	/**
	 * Creates or updates recipient settings
	 *
	 * @param accountName
	 * @param recipient
	 * @return updated recipient
	 */
	Recipient save(String accountName, Recipient recipient);

	/**
	 * Updates {@link NotificationType} {@code lastNotified} property with current date
	 * for given recipient.
	 *
	 * @param type
	 * @param recipient
	 */
	void markNotified(NotificationType type, Recipient recipient);
}
