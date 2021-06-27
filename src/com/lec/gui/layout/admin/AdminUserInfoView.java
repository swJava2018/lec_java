package com.lec.gui.layout.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.lec.gui.layout.common.LecView;
import com.lec.lib.auth.Permission;
import com.lec.lib.repo.model.User;

@SuppressWarnings("serial")
public class AdminUserInfoView extends LecView {
	private JTextField idTxtField = new JTextField();
	private JTextField nameTxtField = new JTextField();
	private JTextField addressTxtField = new JTextField();
	private JTextField phoneTxtField = new JTextField();
	private JTextField countryTxtField = new JTextField();
	private JTextField regdentTxtField = new JTextField();
	private JTextField emailTxtField = new JTextField();
	private JTextField birthTxtField = new JTextField();
	private JTextField pwdTxtField = new JTextField();
	private JTextField roleTxtField = new JTextField();
	
	public AdminUserInfoView() {
		super();

		initLayout();
		setBackground(new Color(200, 200, 200));
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		addTxtField("학번", idTxtField, row++, false);
		addTxtField("이름", nameTxtField, row++, true);
		addTxtField("주소", addressTxtField, row++, true);
		addTxtField("전화번호", phoneTxtField, row++, true);
		addTxtField("국적", countryTxtField, row++, true);
		addTxtField("주민등록번호", regdentTxtField, row++, true);
		addTxtField("이메일", emailTxtField, row++, true);
		addTxtField("생년월일", birthTxtField, row++, true);
		addTxtField("비밀번호", pwdTxtField, row++, true);
		addTxtField("권한", roleTxtField, row++, true);
	}

	private void addTxtField(String name, JTextField txtField, int row, boolean isEditable) {
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100, 30));
		c.gridx = 0;
		c.gridy = row;
		add(label, c);

		txtField.setPreferredSize(new Dimension(200, 30));
		txtField.setEditable(isEditable);
		txtField.setBackground(isEditable ? Color.WHITE : Color.LIGHT_GRAY);
		c.gridx = 1;
		c.gridy = row;
		add(txtField, c);
	}

	public JTextField getIdTxtField() {
		return idTxtField;
	}

	public JTextField getNameTxtField() {
		return nameTxtField;
	}

	public JTextField getAddressTxtField() {
		return addressTxtField;
	}

	public JTextField getPhoneTxtField() {
		return phoneTxtField;
	}

	public JTextField getCountryTxtField() {
		return countryTxtField;
	}

	public JTextField getRegdentTxtField() {
		return regdentTxtField;
	}

	public JTextField getEmailTxtField() {
		return emailTxtField;
	}

	public JTextField getBirthTxtField() {
		return birthTxtField;
	}

	public JTextField getPwdTxtField() {
		return pwdTxtField;
	}

	public JTextField getRoleTxtField() {
		return roleTxtField;
	}

	@Override
	public void setData(Object model) {
		User user = (User) model;
		idTxtField.setText(user.getId());
		nameTxtField.setText(user.getName());
		addressTxtField.setText(user.getAddress());
		phoneTxtField.setText(user.getPhoneNumber());
		countryTxtField.setText(user.getCountry());
		regdentTxtField.setText(user.getRegdentNumber());
		emailTxtField.setText(user.getEmail());
		birthTxtField.setText(user.getBirthDate());
		pwdTxtField.setText(user.getPassword());
		roleTxtField.setText(user.getRole().getValue());
	}

	@Override
	public Object getData() {
		User user = new User();
		user.setId(idTxtField.getText());
		user.setName(nameTxtField.getText());
		user.setAddress(addressTxtField.getText());
		user.setPhoneNumber(phoneTxtField.getText());
		user.setCountry(countryTxtField.getText());
		user.setRegdentNumber(regdentTxtField.getText());
		user.setEmail(emailTxtField.getText());
		user.setBirthDate(birthTxtField.getText());
		user.setPassword(pwdTxtField.getText());
		user.setRole(Permission.valueOfType(roleTxtField.getText()));
		return user;
	}
}