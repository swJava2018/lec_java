package com.lec.gui.layout.common;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class LecView extends JPanel {
	abstract public void setData(Object model);
	abstract public Object getData();
}
