package com.lec.ui;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.lec.ui.controller.main.MainTab;
import com.lec.ui.controller.professor.ProfessorTab;
import com.lec.ui.controller.student.StudentTab;

@SuppressWarnings("serial")
public class SwingApp extends JFrame {
	private static SwingApp instance = new SwingApp();
	private CardLayout layout = new CardLayout();

	// tab
	private final static String MainTab = "MAIN";
	private final static String ProfessorTab = "PROFESSOR";
	private final static String StudentTab = "STUDENT";

	// component
	private JTabbedPane mainTab;
	private JTabbedPane professorTab;
	private JTabbedPane studentTab;

	public static void main(String[] args) {
		instance.start();
	}

	public SwingApp() {
		// set configuration
		setSize(500, 500);
		setLocation(200, 400);

		mainTab = new MainTab(this);
		professorTab = new ProfessorTab(this);
		studentTab = new StudentTab(this);

		// set layout
		Container pan = getContentPane();
		pan.setLayout(layout);
		pan.add(MainTab, mainTab);
		pan.add(ProfessorTab, professorTab);
		pan.add(StudentTab, studentTab);
	}

	private void start() {
		this.setVisible(true);
	}

	public void changeProfessorTab() {
		layout.show(this.getContentPane(), ProfessorTab);
	}

	public void changeStudentTab() {
		layout.show(this.getContentPane(), StudentTab);
	}
}
