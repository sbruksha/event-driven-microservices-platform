package com.eodessa.appointment.repository;

import com.eodessa.appointment.domain.Account;
import com.eodessa.appointment.domain.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, String> {

	Appointment findById(String id);

}
