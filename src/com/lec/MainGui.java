package com.lec;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;

import com.lec.gui.component.admin.AdminCard;
import com.lec.gui.component.login.LoginCard;
import com.lec.gui.component.professor.ProfessorTab;
import com.lec.gui.component.student.StudentCard;

@SuppressWarnings("serial")
public class MainGui extends JFrame {
	private static MainGui instance = new MainGui();
	private CardLayout layout = new CardLayout();

	// tab
	private final static String Login = "MAIN";
	private final static String Professor = "PROFESSOR";
	private final static String Student = "STUDENT";
	private final static String Admin = "ADMIN";

	public static void main(String[] args) {
		instance.start();
	}

	public MainGui() {
		// set configuration
		setSize(1000, 700);
		setLocation(200, 400);

		// set layout
		Container pan = getContentPane();
		pan.setLayout(layout);
		pan.add(Login, new LoginCard(this));
		pan.add(Professor, new ProfessorTab(this));
		pan.add(Student, new StudentCard(this));
		pan.add(Admin, new AdminCard(this));
	}

	private void start() {
		this.setVisible(true);
	}

	public void changeLoginTab() {
		layout.show(this.getContentPane(), Login);
	}

	public void changeProfessorTab() {
		layout.show(this.getContentPane(), Professor);
	}

	public void changeStudentTab() {
		layout.show(this.getContentPane(), Student);
	}

	public void changeAdminTab() {
		layout.show(this.getContentPane(), Admin);
	}
}
