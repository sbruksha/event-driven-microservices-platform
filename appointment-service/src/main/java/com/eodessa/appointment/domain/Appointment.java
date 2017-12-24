package com.eodessa.appointment.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Document(collection = "appointments")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Appointment {

	@Id
	private String id;

	private Date start;

	private Date end;

	@Length(min = 0, max = 500)
	private String description;

	@Valid
	@NotNull
	private Store store;

	@Valid
	@NotNull
	private Account createdby;

	private Date created;

	@Valid
	private List<Service> services;

	@Valid
	@NotNull
	private Account client;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public Account getClient() {
		return client;
	}

	public void setClient(Account client) {
		this.client = client;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Account getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Account createdby) {
		this.createdby = createdby;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
