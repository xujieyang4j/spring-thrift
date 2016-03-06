package com.xjy.spring.memcached.core;

public interface ValueOperations {
	
	<T> boolean set(String key, int exp, T value);
	
}
