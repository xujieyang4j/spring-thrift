package com.xjy.spring.memcached.core;

public interface MemcachedConnection extends MemcachedStringCommand {
	
	Object getNativeConnection();
	
}
