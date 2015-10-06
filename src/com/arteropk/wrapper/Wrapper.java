package com.arteropk.wrapper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.arteropk.util.ReflectionUtils;

public class Wrapper {
	
	protected Class<?> wrappedClass;
	protected Object instance;
	
	public Object getInstance() {
		return instance;
	}
	
	public Wrapper(Class<?> clazz, Object instance) {
		this.wrappedClass = clazz;
		this.instance = instance;
	}
	
	public Class<?> getRefClass() {
		return wrappedClass;
	}
	
	public final Object invoke(String name, Object...args) {
		return invoke(name, false, args);
	}
	
	public final Object invoke(String name, boolean wrapped, Object... args) {
		List<Class<?>> classes = new ArrayList<Class<?>>(args.length);
		for(Object o : args) {
			if(!wrapped)
				classes.add(unwrap(o.getClass()));
			else
				classes.add(o.getClass());
		}
		final Method method = ReflectionUtils.getMethod(wrappedClass, name, classes.toArray(new Class<?>[args.length]));
		return ReflectionUtils.invoke(instance, method, args);
	}
	
	public final <T> T getFieldVal(String name) {
		Field f = getField(name);
		Object o = null;
		try {
			o = f.get(instance);
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return (T)o;
	}
	
	public final <T> T setField(String name, Object setTo) {
		try {
			getField(name).set(instance, setTo);
			return getFieldVal(name);
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Field getField(String name) {
		Field f = null;
		try { f = wrappedClass.getField(name); } catch(Exception ex) { }
		if(f == null) f = ReflectionUtils.getField(wrappedClass, name);
		if(f == null)
			throw new IllegalArgumentException(String.format("No such field %s in %s ", name ,wrappedClass.getSimpleName()));
		f.setAccessible(true);
		return f;	
	}
	
	private static Class<?> unwrap(Class<?> wrapped) {
		if(wrapped == Boolean.class) return boolean.class;
		if(wrapped == Integer.class) return int.class;
		if(wrapped == Long.class) return long.class;
		if(wrapped == Short.class) return short.class;
		if(wrapped == Byte.class) return byte.class;
		return wrapped;
	}
}
