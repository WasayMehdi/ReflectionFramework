package com.arteropk.wrapper.impl;

import com.arteropk.wrapper.Wrapper;

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
