package com.mie.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;  

public class MyRedisKeyGnerator implements KeyGenerator {
	
	@Override
	public Object generate(Object target, Method method, Object... params) {
		List<String> fullparams=new ArrayList<>();
		fullparams.add(method.getDeclaringClass().getName());
		fullparams.add(method.getName());
		for (int i = 0; i < params.length; i++) {
			fullparams.add(params[i]==null?"null":params[i].toString());
		}
		return new SimpleKey(fullparams.toArray());
	}  
      
} 