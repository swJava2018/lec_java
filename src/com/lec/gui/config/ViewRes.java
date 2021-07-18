package com.lec.gui.config;

public class ViewRes extends Res {
	private static Admin admin = new Admin();

	public static Admin getAdmin() {
		return admin;
	}

	public static class Admin {
		public String id = (String) getObject("admin_id");
		public String name = (String) getObject("admin_name");
		public String address = (String) getObject("admin_address");
		public String phone = (String) getObject("admin_phone");
		public String country = (String) getObject("admin_country");
		public String regdent = (String) getObject("admin_regdent");
		public String email = (String) getObject("admin_email");
		public String birth = (String) getObject("admin_birth");
		public String pwd = (String) getObject("admin_pwd");
		public String role = (String) getObject("admin_role");
	}
}
