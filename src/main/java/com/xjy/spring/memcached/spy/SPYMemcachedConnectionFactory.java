package com.xjy.spring.memcached.spy;

import java.util.Collection;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.ConnectionFactoryBuilder.Locator;
import net.spy.memcached.ConnectionFactoryBuilder.Protocol;
import net.spy.memcached.ConnectionObserver;
import net.spy.memcached.FailureMode;
import net.spy.memcached.HashAlgorithm;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.OperationFactory;
import net.spy.memcached.auth.AuthDescriptor;
import net.spy.memcached.ops.OperationQueueFactory;
import net.spy.memcached.transcoders.Transcoder;

import org.springframework.beans.factory.InitializingBean;

import com.xjy.spring.memcached.core.MemcachedConnection;
import com.xjy.spring.memcached.core.MemcachedConnectionFactory;

public class SPYMemcachedConnectionFactory implements MemcachedConnectionFactory, InitializingBean {
	
	private MemcachedClient connection;
	private final ConnectionFactoryBuilder connectionFactoryBuilder = new ConnectionFactoryBuilder();
	private String servers;

	public void setServers(final String newServers) {
		this.servers = newServers;
	}

	public void setAuthDescriptor(final AuthDescriptor to) {
		connectionFactoryBuilder.setAuthDescriptor(to);
	}

	public void setDaemon(final boolean d) {
		connectionFactoryBuilder.setDaemon(d);
	}

	public void setFailureMode(final FailureMode fm) {
		connectionFactoryBuilder.setFailureMode(fm);
	}

	public void setHashAlg(final HashAlgorithm to) {
		connectionFactoryBuilder.setHashAlg(to);
	}

	public void setInitialObservers(final Collection<ConnectionObserver> obs) {
		connectionFactoryBuilder.setInitialObservers(obs);
	}

	public void setLocatorType(final Locator l) {
		connectionFactoryBuilder.setLocatorType(l);
	}

	public void setMaxReconnectDelay(final long to) {
		connectionFactoryBuilder.setMaxReconnectDelay(to);
	}

	public void setOpFact(final OperationFactory f) {
		connectionFactoryBuilder.setOpFact(f);
	}

	public void setOpQueueFactory(final OperationQueueFactory q) {
		connectionFactoryBuilder.setOpQueueFactory(q);
	}

	public void setOpQueueMaxBlockTime(final long t) {
		connectionFactoryBuilder.setOpQueueMaxBlockTime(t);
	}

	public void setOpTimeout(final long t) {
		connectionFactoryBuilder.setOpTimeout(t);
	}

	public void setProtocol(final Protocol prot) {
		connectionFactoryBuilder.setProtocol(prot);
	}

	public void setReadBufferSize(final int to) {
		connectionFactoryBuilder.setReadBufferSize(to);
	}

	public void setReadOpQueueFactory(final OperationQueueFactory q) {
		connectionFactoryBuilder.setReadOpQueueFactory(q);
	}

	public void setShouldOptimize(final boolean o) {
		connectionFactoryBuilder.setShouldOptimize(o);
	}

	public void setTimeoutExceptionThreshold(final int to) {
		connectionFactoryBuilder.setTimeoutExceptionThreshold(to);
	}

	public void setTranscoder(final Transcoder<Object> t) {
		connectionFactoryBuilder.setTranscoder(t);
	}

	public void setUseNagleAlgorithm(final boolean to) {
		connectionFactoryBuilder.setUseNagleAlgorithm(to);
	}

	public void setWriteOpQueueFactory(final OperationQueueFactory q) {
		connectionFactoryBuilder.setWriteOpQueueFactory(q);
	}

	@Override
	public MemcachedConnection getConnection() {
		return new SPYMemcachedConnection(connection);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		connection =  new MemcachedClient(connectionFactoryBuilder.build(), AddrUtil.getAddresses(servers));
	}
	
}
