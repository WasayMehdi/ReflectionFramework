package com.rswebclients;

import com.rswebclients.frame.Main;
import com.rswebclients.frame.listeners.CommandListener;
import com.rswebclients.util.ReflectionUtils;
import com.rswebclients.wrapper.impl.Client;

public class Loader {
	private static JarLoader loader;
	private static Class<?> clientClass;
	private static Client client;
	
	public static Client getClient() {
		return client;
	}
	
	public static ClassLoader getLoader() {
		return loader;
	}
	
	public static void init(String s) {
		try {
			loader = JarLoader.getJar(s);
			clientClass = ReflectionUtils.getClass(loader, "client.Client");
			client = new Client(clientClass, clientClass.newInstance());
			client.getApplet().addKeyListener(new CommandListener());
			Main.getMain().addApplet(client);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
