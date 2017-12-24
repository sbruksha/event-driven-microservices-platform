package com.eodessa.store.service;

import com.eodessa.store.domain.Store;
import com.eodessa.store.repository.StoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class StoreServiceImpl implements StoreService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private StoreRepository repository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Store findByName(String storeName) {
		Assert.hasLength(storeName);
		return repository.findByName(storeName);
	}
}
