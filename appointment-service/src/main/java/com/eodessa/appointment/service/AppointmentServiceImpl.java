package com.eodessa.appointment.service;

import com.eodessa.appointment.domain.Appointment;
import com.eodessa.appointment.repository.AppointmentRepository;
import com.eodessa.appointment.repository.ServiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.lang.Iterable;

@Service
@EnableBinding(Source.class)
public class AppointmentServiceImpl implements AppointmentService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private AppointmentRepository repository;

//	@Autowired
//	private Source source;

	@Autowired
	@Output(Source.OUTPUT)
	MessageChannel output;

	@Autowired
	private ServiceRepository servicerepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Appointment findById(String id) {
		Assert.hasLength(id);
		return repository.findById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<Appointment> findAll() {
		return repository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<com.eodessa.appointment.domain.Service> findAllServices() {
		return servicerepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Appointment create(Appointment appointment) {

		Appointment existing = repository.findById(appointment.getId());
		Assert.isNull(existing, "appointment already exists: " + appointment.getId());

		repository.save(appointment);

		log.info("new appointment has been created: " + appointment.getId());

		this.output.send(MessageBuilder.withPayload(appointment.getId()).build());

		return appointment;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveChanges(String name, Appointment update) {

		Appointment appointment = repository.findById(name);
		Assert.notNull(appointment, "can't find account with name " + name);

		appointment.setDescription(update.getDescription());

		repository.save(appointment);

		log.debug("appointment {} changes has been saved", name);

	}
}
