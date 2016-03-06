package com.xjy.spring.memcached.spy;

import java.util.concurrent.ExecutionException;

import net.spy.memcached.MemcachedClient;

import com.xjy.spring.memcached.core.MemcachedConnection;

public class SPYMemcachedConnection implements MemcachedConnection {
	private MemcachedClient connection;
	public SPYMemcachedConnection() {
	}
	
	public SPYMemcachedConnection(MemcachedClient connection) {
		super();
		this.connection = connection;
	}

	@Override
	public <T> boolean set(String key, int exp, T value) {
		try {
			return connection.set(key, exp, value).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public MemcachedClient getNativeConnection() {
		return connection;
	}

}
