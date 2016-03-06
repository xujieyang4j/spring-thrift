package com.xjy.spring.memcached.core;

public class MemcachedTemplate {

	private MemcachedConnectionFactory connectionFactory;

	public MemcachedTemplate() {
	}

	public ValueOperations opsForValue() {
		return new DefaultValueOperations(this);
	}

	public <T> T execute(MemcachedCallback<T> action) {
		MemcachedConnectionFactory factory = getConnectionFactory();
		MemcachedConnection conn = getConnection(factory);
		T result = action.doInMemcached(conn);
		return result;
	}

	private MemcachedConnection getConnection(MemcachedConnectionFactory factory) {
		return factory.getConnection();
	}

	public void setConnectionFactory(MemcachedConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	public MemcachedConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}
}
