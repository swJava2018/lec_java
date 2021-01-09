package com.lec.my.sample;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.lec.my.ui.main.LoginPanel;

public class SwingSample extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static SwingSample instance = new SwingSample();

	@SuppressWarnings("unused")
	public SwingSample() {
		setLocation(200, 400);
		setPreferredSize(new Dimension(400, 500));
		
		LoginPanel loginFrame = new LoginPanel();
		this.add(loginFrame, BorderLayout.CENTER);	
		this.pack();
		this.setVisible(true);
	}
	
	private void start() {
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		instance.start();
	}
}
