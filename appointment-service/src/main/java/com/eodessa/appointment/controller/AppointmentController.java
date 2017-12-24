package com.eodessa.appointment.controller;

import com.eodessa.appointment.domain.Appointment;
import com.eodessa.appointment.domain.Service;
import com.eodessa.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.Iterable;

@RestController
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@PreAuthorize("#oauth2.hasScope('server') or #id.equals('demo')")
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Appointment getAppointmentByName(@PathVariable String id) {
		return appointmentService.findById(id);
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public Iterable<Appointment> getAppointments() {
		return appointmentService.findAll();
	}

	@RequestMapping(path = "/services", method = RequestMethod.GET)
	public Iterable<Service> getServices() {
		return appointmentService.findAllServices();
	}

	@RequestMapping(path = "/{name}", method = RequestMethod.PUT)
	public void saveAppointment(String name, @Valid @RequestBody Appointment appointment) {
		appointmentService.saveChanges(name, appointment);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public Appointment createAppointment(@Valid @RequestBody Appointment appointment) {
		return appointmentService.create(appointment);
	}
}
