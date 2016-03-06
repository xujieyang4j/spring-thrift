package com.xjy.spring.memcached;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xjy.spring.memcached.core.MemcachedTemplate;


public class TestSpringDataMemcached {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:com/xjy/study/spring/memcached/spring.xml");
		MemcachedTemplate memcachedTemplate = ac.getBean("xmemcachedTemplate", MemcachedTemplate.class);
		memcachedTemplate.opsForValue().set("TestSpringDataMemcached_111", 0, "TestSpringDataMemcached_111");
		ac.destroy();
	}
}
