package com.xjy.spring.memcached.core;

import org.springframework.dao.DataAccessException;

public interface MemcachedCallback<T> {
	
	T doInMemcached(MemcachedConnection connection) throws DataAccessException;
	
}
