package com.eodessa.store.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Document(collection = "stores")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Store {

	@Id
	private String name;

	private Date lastSeen;

	@Valid
	private List<Opening> openings;

	@Length(min = 0, max = 20_000)
	private String storename;

	@Length(min = 0, max = 1000)
	private String addressstreet;

	@Length(min = 0, max = 100)
	private String addresscity;

	@Length(min = 0, max = 50)
	private String addressstate;

	@Length(min = 0, max = 10)
	private String addresspostalcode;

	@Length(min = 0, max = 50)
	private String addresscountry;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(Date lastSeen) {
		this.lastSeen = lastSeen;
	}

	public List<Opening> getOpenings() {
		return openings;
	}

	public void setOpenings(List<Opening> openings) {
		this.openings = openings;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public String getAddressstreet() {
		return addressstreet;
	}

	public void setAddressstreet(String addressstreet) {
		this.addressstreet = addressstreet;
	}

	public String getAddresscity() {
		return addresscity;
	}

	public void setAddresscity(String addresscity) {
		this.addresscity = addresscity;
	}

	public String getAddressstate() {
		return addressstate;
	}

	public void setAddressstate(String addressstate) {
		this.addressstate = addressstate;
	}

	public String getAddresspostalcode() {
		return addresspostalcode;
	}

	public void setAddresspostalcode(String addresspostalcode) {
		this.addresspostalcode = addresspostalcode;
	}

	public String getAddresscountry() {
		return addresscountry;
	}

	public void setAddresscountry(String addresscountry) {
		this.addresscountry = addresscountry;
	}
}
