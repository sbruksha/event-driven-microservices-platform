package com.eodessa.store.repository;

import com.eodessa.store.domain.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends CrudRepository<Store, String> {

	Store findByName(String name);

}
