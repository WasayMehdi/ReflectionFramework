package com.arteropk.frame.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

import com.arteropk.Loader;
import com.arteropk.util.ReflectionUtils;
import com.arteropk.wrapper.impl.Client;
import com.arteropk.wrapper.impl.Player;
import com.arteropk.wrapper.impl.Stream;

public class CommandListener extends KeyAdapter {
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			Client client = Loader.getClient();
			String inputString = ReflectionUtils.getFieldValue(Loader.getClient().getRefClass(), "inputString", Loader.getClient().getApplet());
			  if(inputString == null)
			  		inputString = ReflectionUtils.getFieldValue(Loader.getClient().getRefClass(), "input", Loader.getClient().getApplet());
			  if(inputString == null)
				  return;
			if(inputString.startsWith("//")) {
				inputString = inputString.substring(2);
				processCommand(inputString, client, client.getStream());
			}
			
		}
	}
	static Timer timer;
	public static void processCommand(String inputString, final Client client, final Stream stream) {
		String s[] = inputString.split(" ");
		final Player myPlayer = client.getMyPlayer();
		int realX = (myPlayer.getX() - 6 >> 7) + client.getBaseX();
		int realY = (myPlayer.getY() - 6 >> 7) + client.getBaseY();
		System.out.println("X: "+realX+" Y: "+realY);
		if(inputString.equalsIgnoreCase("test")) {
			client.invoke("pushMessage", "test", 0, "");
		}
	}

}
