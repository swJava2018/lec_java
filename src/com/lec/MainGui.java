package com.lec;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.lec.gui.component.admin.AdminTab;
import com.lec.gui.component.main.MainTab;
import com.lec.gui.component.professor.ProfessorTab;
import com.lec.gui.component.student.StudentTab;
import com.lec.lib.auth.Permission;
import com.lec.lib.service.UserService;

@SuppressWarnings("serial")
public class MainGui extends JFrame {
	private static MainGui instance = new MainGui();
	private CardLayout layout = new CardLayout();

	// tab
	private final static String MainTab = "MAIN";
	private final static String ProfessorTab = "PROFESSOR";
	private final static String StudentTab = "STUDENT";
	private final static String EmployeeTab = "EMPLOYEE";
	private final static String AdminTab = "ADMIN";

	// component
	private JTabbedPane mainTab;
	private JTabbedPane professorTab;
	private JTabbedPane studentTab;
	private JTabbedPane adminTab;

	public static void main(String[] args) {
		instance.start();
	}

	public MainGui() {
		// set configuration
		setSize(1000, 700);
		setLocation(200, 400);

		mainTab = new MainTab(this);
		professorTab = new ProfessorTab(this);
		studentTab = new StudentTab(this);
		adminTab = new AdminTab(this);

		// set layout
		Container pan = getContentPane();
		pan.setLayout(layout);
		pan.add(MainTab, mainTab);
		pan.add(ProfessorTab, professorTab);
		pan.add(StudentTab, studentTab);
		pan.add(AdminTab, adminTab);
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

	public void changeEmployeeTab() {
		layout.show(this.getContentPane(), EmployeeTab);
	}

	public void changeAdminTab() {
		layout.show(this.getContentPane(), AdminTab);
	}
}
