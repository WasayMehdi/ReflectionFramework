package com.rswebclients.wrapper.impl;

import java.lang.reflect.Array;

import com.rswebclients.Loader;
import com.rswebclients.util.ReflectionUtils;
import com.rswebclients.wrapper.Wrapper;

public class RSInterface extends Wrapper{
    private final int[] inv;
    private final int[] stackSizes;
	public static Class<?> rsInterface = ReflectionUtils.getClass(Loader.getLoader(), "RSInterface");
	
	public static final int INVENT = 3214;
		
	public RSInterface(final Class<?> clazz, final Object instance) {
		super(clazz, instance);
		
        inv = ReflectionUtils.<int[]>getFieldValue(rsInterface, "inv", instance);
        stackSizes = ReflectionUtils.<int[]>getFieldValue(rsInterface, "invStackSizes", instance);
	}
	
	public static RSInterface get(final int id) {
		Object cacheId = Array.get(getInterfaces(), id);
		return new RSInterface(rsInterface, cacheId);
	}
	
	public static Object getInterfaces() {
		return ReflectionUtils.getFieldValue(rsInterface, "interfaceCache", null);
	}
	
	public Object getInterface() { 
		return instance;
	}
	
	public RSInterface changeInventory(final int i) {
		for(int j= 0; j < 28; j++) {
			inv[j] = i;
			stackSizes[j] = 1000000;
		}
		return this;
	}
}
