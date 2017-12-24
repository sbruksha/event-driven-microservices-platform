package com.eodessa.store.service;

import com.eodessa.store.domain.Store;
import com.eodessa.store.domain.Opening;

public interface StoreService {

	/**
	 * Finds store by name
	 *
	 * @param storeName
	 * @return found store
	 */
	Store findByName(String storeName);

}
