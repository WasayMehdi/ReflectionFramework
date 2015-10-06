package com.arteropk.wrapper.impl;

import java.applet.Applet;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.arteropk.Loader;
import com.arteropk.util.Config;
import com.arteropk.util.ReflectionUtils;
import com.arteropk.wrapper.Wrapper;

public class Client extends Wrapper {

	private Stream stream;
	private Player myPlayer;
	
	public Client(Class<?> clazz, final Object instance) {
		super(clazz, instance);


	}
	
	public Applet getApplet() {
		return (Applet)instance;
	}
	
	public Stream getStream() {
		return stream;
	}
	
	public RSInterface getInv() {
		return RSInterface.get(RSInterface.INVENT);
	}
	
	public Player getMyPlayer() {
		if(myPlayer == null) {
			myPlayer = new Player(ReflectionUtils.getClass(Loader.getLoader(), "Player"),
					ReflectionUtils.getFieldValue(wrappedClass, "myPlayer", instance));
		}
		return myPlayer;
	}
	
	public void start() {

        getApplet().start();
        getApplet().init();

		this.stream = new Stream(ReflectionUtils.getClass(Loader.getLoader(), "Stream"),
				ReflectionUtils.getFieldValue(wrappedClass, "stream", instance));

	}
	
	public void close() {
		getApplet().stop();
		getApplet().destroy();
	}
	
	public int getBaseX() {
		return super.getFieldVal("baseX");
	}
	
	public int getBaseY() {
		return super.getFieldVal("baseX");
	}

}
