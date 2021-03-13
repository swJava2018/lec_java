package com.lec.gui.component.student.user;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lec.lib.auth.UserAuth;
import com.lec.lib.repo.model.User;

@SuppressWarnings("serial")
public class UserPanel extends JPanel {
	private HashMap<String, JTextField> infoMap = new HashMap<String, JTextField>();
	private JButton loadBtn;
	
	public UserPanel() {	
		genInfoPair("id", "ID(학번)");
		genInfoPair("name", "이름");
		genInfoPair("phone", "전화번호");
		genInfoPair("country", "국적");
		genInfoPair("email", "이메일");
		genInfoPair("birth", "생년월일");
		genInfoPair("pwd", "비밀번호");
		genInfoPair("address", "주소");
		
		loadBtn = (new JButton("내 정보 불러오기"));
		loadBtn.setPreferredSize(new Dimension(200, 30));
		loadBtn.addActionListener(loadListener);
		add(loadBtn);
	}
	
	private void genInfoPair(String id, String name) {
		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(200, 30));
		JTextField field = new JTextField();
		field.setPreferredSize(new Dimension(200, 30));
		add(label);
		add(field);
		
		infoMap.put(id, field);
	}
	
	private ActionListener loadListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UserAuth auth = UserAuth.getInstance();
			if (auth.isLogin()) {
				User user = auth.getUser();
				infoMap.get("id").setText(user.getId());
				infoMap.get("name").setText(user.getName());
				infoMap.get("phone").setText(user.getPhoneNumber());
				infoMap.get("country").setText(user.getCountry());
				infoMap.get("email").setText(user.getEmail());
				infoMap.get("birth").setText(user.getBirthDate());
				infoMap.get("pwd").setText(user.getPassword());
				infoMap.get("address").setText(user.getAddress());
			}
		}
	};
}
