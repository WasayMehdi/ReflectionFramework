package com.arteropk.wrapper.impl;

import java.lang.reflect.Method;

import com.arteropk.util.Config;
import com.arteropk.util.ReflectionUtils;
import com.arteropk.wrapper.Wrapper;

public class Stream extends Wrapper {
	private Method createFrame;
	private Method writeWord;
    private Method writeByte;

	public Stream(final Class<?> clazz, final Object stream) {
		super(clazz, stream);
	    this.createFrame = ReflectionUtils.getMethod(clazz, "createFrame", int.class);
		this.writeWord = ReflectionUtils.getMethod(clazz, "writeWord", int.class);
        this.writeByte = ReflectionUtils.getMethod(clazz, "writeByte", int.class);
	}
		
	public Class<?> getRefClass() {
		return wrappedClass;
	}
	
	/**
	 * Commonly used methods, change them as neccessary depending on obfuscation
	 */
	
	public void createFrame(int i) {
		ReflectionUtils.invoke(instance, createFrame, i);
	}
	
	public void writeWord(int i) {
		ReflectionUtils.invoke(instance, writeWord, i);
	}

    public void writeByte(int i) {
        ReflectionUtils.invoke(instance, writeByte, i);
    }
	
	public void method432(int i) {
		invoke("method432", i);
	}
	
	public void method433(int i) {
		invoke("method433", i);
	}
	
	public void writeDWord(int i) {
		invoke("writeDWord", i);
	}
}
