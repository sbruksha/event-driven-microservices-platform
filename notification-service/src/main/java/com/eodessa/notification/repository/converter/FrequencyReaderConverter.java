package com.eodessa.notification.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eodessa.notification.domain.Frequency;

@Component
public class FrequencyReaderConverter implements Converter<Integer, Frequency> {

	@Override
	public Frequency convert(Integer days) {
		return Frequency.withDays(days);
	}
}
