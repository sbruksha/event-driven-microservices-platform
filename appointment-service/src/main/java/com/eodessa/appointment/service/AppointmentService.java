package com.eodessa.appointment.service;

import com.eodessa.appointment.domain.Appointment;
import com.eodessa.appointment.domain.Service;

import java.lang.Iterable;

public interface AppointmentService {

	/**
	 * Finds appointment by given name
	 *
	 * @param id
	 * @return found appointment
	 */
	Appointment findById(String id);

	/**
	 * Find all appointments
	 *
	 * @return found appointments
	 */
	Iterable<Appointment> findAll();

	/**
	 * Find all services
	 *
	 * @return found services
	 */
	Iterable<Service> findAllServices();

	/**
	 * Checks if appointment with the same name already exists
	 * Creates new appointment with default parameters
	 *
	 * @param appointment
	 * @return created account
	 */
	Appointment create(Appointment appointment);

	/**
	 * Validates and applies incoming appointment updates
	 *
	 * @param name
	 * @param update
	 */
	void saveChanges(String name, Appointment update);
}
