package com.lec.gui.sample;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

public class WBFrame extends JFrame {

	private JPanel contentPane;
	private WBPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WBFrame frame = new WBFrame();
					frame.setVisible(true);
					
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setSize(screenSize.width, screenSize.height);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WBFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		panel = new WBPanel();
		contentPane.add(panel);
		initUI();
	}
	
	private void initUI() {
	}

}
