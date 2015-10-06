package com.arteropk;

import com.arteropk.frame.Main;
import com.arteropk.frame.listeners.CommandListener;
import com.arteropk.util.Config;
import com.arteropk.util.ReflectionUtils;
import com.arteropk.wrapper.impl.Client;

import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Loader {
	private static JarLoader loader;
	private static Class<?> clientClass;
	private static Client client;

    static {
        try {
            loader = JarLoader.getJar(Config.JAR_URL);
        }catch(Exception e) {

        }
    }


    public static Client getClient() {
		return client;
	}
	
	public static ClassLoader getLoader() {
		return loader;
	}
	
	public static void init() {
		try {
            clientClass = ReflectionUtils.getClass(loader, Config.CLIENT);
            if(Config.DVPK) {
                final Class<?> dvpk = ReflectionUtils.getClass(loader, "dvpk.DeviousPK");
                Constructor constructor = clientClass.getConstructor(dvpk);
                client = new Client(clientClass, constructor.newInstance(dvpk.newInstance()));
            } else {
                client = new Client(clientClass, clientClass.newInstance());
            }
            client.getApplet().addKeyListener(new CommandListener());
            Main.getMain().addApplet(client);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
