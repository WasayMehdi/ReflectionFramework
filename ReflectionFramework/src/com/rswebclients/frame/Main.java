package com.rswebclients.frame;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.rswebclients.Loader;
import com.rswebclients.frame.listeners.CommandListener;
import com.rswebclients.wrapper.impl.Client;

public class Main {
	
	private JFrame frame;
	private static Main main;
	
	public Main() {
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(756, 565));
		frame.setVisible(true);
		frame.addKeyListener(new CommandListener());
	}
	
	public static void main(String args[]) {
		main = new Main();
		Loader.init("http://insanityx.net/InsanityX%20V3.1.1.jar");
	}
	
	public static Main getMain() {
		return main;
	}
	
	public void addApplet(Client applet) {
		frame.setContentPane(applet.getApplet());
		frame.pack();
		applet.start();
	}
	
	
}
