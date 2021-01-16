package com.lec.my.ui.main;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lec.my.api.UserAPI;
import com.lec.my.app.SwingApp;
import com.lec.my.model.User;

@SuppressWarnings("serial")
public class SignInPanel extends JPanel {
	private SwingApp frame;
	
	// component
	private JTextField idField;
	private JTextField pwdField;
	private JButton loginBtn;
	
	public SignInPanel(SwingApp frame) {
		this.frame = frame;
		
//		setLayout(new GridLayout(5, 1));
		idField = new JTextField("아이디");
		idField.setPreferredSize(new Dimension(200, 30));
		pwdField = new JTextField("비밀번호");
		pwdField.setPreferredSize(new Dimension(200, 30));
		loginBtn = (new JButton("로그인"));
		loginBtn.setPreferredSize(new Dimension(200, 30));
		
		add(idField);
		add(pwdField);
		add(loginBtn);
		loginBtn.addActionListener(loginListener);
	}
	
	private ActionListener loginListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
        	String id = idField.getText();
        	String password = pwdField.getText();
			if (id == "" || password == "")
				return;
			
			User user = UserAPI.getInstance().login(id, password);
			JOptionPane op1 = new JOptionPane();
			if (user != null) {
				frame.changeStudentTab();
            	op1.showMessageDialog(null, user.getName() + " 로그인 성공");   
			} else {
				op1.showMessageDialog(null, user.getName() + " 로그인 실패");   
			}
        }
	};
}
