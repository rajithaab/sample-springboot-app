package com.sample.rest.data.dao;

import org.springframework.data.repository.CrudRepository;

public interface MetadataRepository extends CrudRepository<MetaData, String>{
	//String saveMetaData(MetaData metaData);
}
