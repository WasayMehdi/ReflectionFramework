package com.arteropk.frame;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.*;

import com.arteropk.Loader;
import com.arteropk.frame.listeners.CommandListener;
import com.arteropk.util.Config;
import com.arteropk.wrapper.impl.Client;

public class Main {
	
	private JFrame frame;
	private static Main main;


    public Main() {
		frame = new JFrame();
        frame.setLayout(new BorderLayout());

		frame.setPreferredSize(new Dimension(756, 565));



        frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(new CommandListener());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]) {
		main = new Main();
        Loader.init();
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
