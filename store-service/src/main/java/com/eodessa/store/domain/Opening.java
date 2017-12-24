package com.eodessa.store.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class Opening {

	@NotNull
	private Date from_date;

	@NotNull
	private Date to_date;

	@NotNull
	private Integer priority;

	@NotNull
	private Integer weekday_id;

	@NotNull
	private Integer start;

	@NotNull
	private Integer end;

	@NotNull
	private Integer pause_start;

	@NotNull
	private Integer pause_end;

	public Date getFrom_date() {
		return from_date;
	}

	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}

	public Date getTo_date() {
		return to_date;
	}

	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}

	public Integer getWeekday_id() {
		return weekday_id;
	}

	public void setWeekday_id(Integer weekday_id) {
		this.weekday_id = weekday_id;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getPause_start() {
		return pause_start;
	}

	public void setPause_start(Integer pause_start) {
		this.pause_start = pause_start;
	}

	public Integer getPause_end() {
		return pause_end;
	}

	public void setPause_end(Integer pause_end) {
		this.pause_end = pause_end;
	}
}
