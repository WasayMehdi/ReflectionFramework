package com.rswebclients.wrapper.impl;

import java.util.ArrayList;
import java.util.List;

import com.rswebclients.Loader;
import com.rswebclients.util.ReflectionUtils;
import com.rswebclients.wrapper.Wrapper;

public class Player extends Wrapper{
		
	public Player(Class<?> clazz, final Object instance) {
		super(clazz, instance);
	}
	
	public String getName() {
		return getFieldVal("name");
	}
	
	public int getX() {
        return getFieldVal("x");
	}
	
	public int getY() {
		return getFieldVal("y");
	}
	
}
