package com.xjy.spring.memcached.xm;

import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import com.xjy.spring.memcached.core.MemcachedConnection;


public class XMemcachedConnection implements MemcachedConnection {
	private MemcachedClient connection;
	public XMemcachedConnection() {
	}
	
	public XMemcachedConnection(MemcachedClient connection) {
		super();
		this.connection = connection;
	}

	@Override
	public <T> boolean set(String key, int exp, T value) {
		try {
			return connection.set(key, exp, value);
		} catch (InterruptedException | TimeoutException | MemcachedException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public MemcachedClient getNativeConnection() {
		return connection;
	}

}
