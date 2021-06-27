package com.lec;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;

import com.lec.gui.component.admin.AdminCard;
import com.lec.gui.component.login.LoginCad;
import com.lec.gui.component.professor.ProfessorCard;
import com.lec.gui.component.student.StudentCard;

@SuppressWarnings("serial")
public class MainGui extends JFrame {
	private static MainGui instance = new MainGui();
	private CardLayout layout = new CardLayout();

	// card
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
		pan.add(Login, new LoginCad(this));
		pan.add(Professor, new ProfessorCard(this));
		pan.add(Student, new StudentCard(this));
		pan.add(Admin, new AdminCard(this));
	}

	private void start() {
		this.setVisible(true);
	}

	public void changeLoginCard() {
		layout.show(this.getContentPane(), Login);
	}

	public void changeProfessorCard() {
		layout.show(this.getContentPane(), Professor);
	}

	public void changeStudentCard() {
		layout.show(this.getContentPane(), Student);
	}

	public void changeAdminCard() {
		layout.show(this.getContentPane(), Admin);
	}
}
