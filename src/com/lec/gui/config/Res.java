package com.lec.gui.config;

import java.util.Locale;
import java.util.ResourceBundle;

public class Res {
	private static Locale configLoc = Locale.getDefault();
	private static Locale resLoc = new Locale((String) getConfig("locale"));

	protected static Object getConfig(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("resources/config", configLoc);
		return bundle.getObject(key);
	}

	protected static Object getObject(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("resources/words", resLoc);
		return bundle.getObject(key);
	}
}
