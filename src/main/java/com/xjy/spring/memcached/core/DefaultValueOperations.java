package com.xjy.spring.memcached.core;


public class DefaultValueOperations implements ValueOperations {
	private MemcachedTemplate memcachedTemplate;
	public DefaultValueOperations() {
	}
	
	public DefaultValueOperations(MemcachedTemplate memcachedTemplate) {
		super();
		this.memcachedTemplate = memcachedTemplate;
	}

	public <T> boolean set(String key, int exp, T value) {
		return memcachedTemplate.execute(new MemcachedCallback<Boolean>() {

			@Override
			public Boolean doInMemcached(MemcachedConnection connection) {
				return connection.set(key, exp, value);
			}
		});
	}
	
}
