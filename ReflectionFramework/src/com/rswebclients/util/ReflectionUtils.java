package com.rswebclients.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class ReflectionUtils {

    private ReflectionUtils(){}

    public static Field getField(final Class<?> clazz, final String name){
        try{
            final Field f = clazz.getDeclaredField(name);
            f.setAccessible(true);
            return f;
        }catch(Exception ex){
        	ex.printStackTrace();
            return null;
        }
    }

    public static <T> T getFieldValue(final Class<?> clazz, final String name, final Object instance){
        try{
        	Field f = getField(clazz, name);
        	Object o = f.get(instance);
            return (T)o;
        }catch(Exception ex){
        	ex.printStackTrace();
            return null;
        }
    }

    public static Method getMethod(final Class<?> clazz, final String name, final Class<?>... paramList){
        try{
            final Method m = clazz.getDeclaredMethod(name, paramList);
            m.setAccessible(true);
            return m;
        }catch(Exception ex){
        	ex.printStackTrace();
            return null;
        }
    }

    public static Class<?> getClass(final ClassLoader cl, final String name){
        try{
            return cl.loadClass(name);
        }catch(Exception ex){
        	ex.printStackTrace();
            return null;
        }
    }

    public static <T> T invoke(final Object instance, final Method method, final Object... args){
        try{
            return (T)method.invoke(instance, args);
        }catch(Exception ex){
        	ex.printStackTrace();
            return null;
        }
    }
}