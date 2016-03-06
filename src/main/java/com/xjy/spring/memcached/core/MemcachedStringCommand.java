package com.xjy.spring.memcached.core;

public interface MemcachedStringCommand {
	
	<T> boolean set(String key, int exp, T value);
	
}
