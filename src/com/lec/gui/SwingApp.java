package com.lec.gui;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.lec.gui.controller.admin.AdminTab;
import com.lec.gui.controller.main.MainTab;
import com.lec.gui.controller.professor.ProfessorTab;
import com.lec.gui.controller.student.StudentTab;
import com.lec.lib.api.IAdmin;
import com.lec.lib.api.config.Permission;
import com.lec.lib.api.impl.AdminImpl;
import com.lec.lib.repo.UserInfoRepo;

@SuppressWarnings("serial")
public class SwingApp extends JFrame {
	private static SwingApp instance = new SwingApp();
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

	public SwingApp() {
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

		// 초기화 (Default 어드민 계정 추가)
		InitDB();
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

	private static void InitDB() {
		UserInfoRepo db = UserInfoRepo.getInstance();
		if(db.read("admin") != null)
			return;
		
		IAdmin api = new AdminImpl();
		boolean result = api.register("admin", "admin", "1234", Permission.Admin);
		if (result) {
			System.out.println("init success");
		} else {
			System.out.println("init fail");
		}
	}
}
