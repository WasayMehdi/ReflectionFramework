package com.rswebclients;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


public class JarLoader extends URLClassLoader{
	
	public static JarLoader getJar(String url) throws MalformedURLException {
		return new JarLoader(url);
	}
	
	public JarLoader(String url) throws MalformedURLException {
		super(new URL[]{new URL(url)});
	}
}
