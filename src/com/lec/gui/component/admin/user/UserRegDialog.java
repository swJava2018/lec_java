package com.lec.gui.component.admin.user;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;
import com.lec.gui.layout.admin.AdminUserInfoRegDlgView;
import com.lec.lib.auth.Permission;
import com.lec.lib.repo.model.Department;
import com.lec.lib.repo.model.Division;
import com.lec.lib.repo.model.User;

@SuppressWarnings("serial")
public class UserRegDialog extends LecPanel {
	private AdminUserInfoRegDlgView view;
	private ImageIcon icon;
	private String title = "사용자 추가 등록하기";
	private Object[] options = new Object[] { "취소", "추가" };

	private JComboBox<Permission> roleComboBox;

	public UserRegDialog(MainGui frame) {
		super(frame);

		// set dialog image
		Image img = (new ImageIcon("src/resource/new_user.png")).getImage().getScaledInstance(50, 50,
				Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);

		// set view
		view = new AdminUserInfoRegDlgView();
		add(view);

		// set combo box
		roleComboBox = view.getRoleComboBox();
		for (Permission p : Permission.values()) {
			roleComboBox.addItem(p);
		}
		roleComboBox.setSelectedIndex(0);
		roleComboBox.addActionListener(roleListener);
		initComboBox(view.getStudent().getDivComboBox(), view.getStudent().getDepComboBox());
		initComboBox(view.getProfessor().getDivComboBox(), view.getProfessor().getDepComboBox());
	}

	private void initComboBox(JComboBox<Division> divComboBox, JComboBox<Department> depComboBox) {
		for (Division div : schoolService.readAllDiv()) {
			divComboBox.addItem(div);
		}
		for (Department dep : schoolService.readAllDep()) {
			depComboBox.addItem(dep);
		}
	}

	public void show() {
		int selected = JOptionPane.showOptionDialog(null, view, title, JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, icon, options, options[0]);
		if (selected == 0) {
			cancel();
		} else {
			register();
		}
	}

	public void register() {
		User user = (User) view.getData();
		userService.register(user.getId(), user.getName(), user.getPassword(), user.getRole().getValue(), null);
	}

	public void cancel() {
		System.out.println("취소 완료");
	}

	private ActionListener roleListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Permission selected = (Permission) roleComboBox.getSelectedItem();
			switch (selected) {
			case STUDENT:
				view.changeToStudent();
				break;
			case PROFESSOR:
				view.changeToProfessor();
				break;
			default:
				break;
			}
		}
	};
}
