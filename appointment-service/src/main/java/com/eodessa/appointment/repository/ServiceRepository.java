package com.eodessa.appointment.repository;

import com.eodessa.appointment.domain.Appointment;
import com.eodessa.appointment.domain.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends CrudRepository<Service, String> {



}
