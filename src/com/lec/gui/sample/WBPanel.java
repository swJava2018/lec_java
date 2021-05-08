package com.lec.gui.sample;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class WBPanel extends JPanel {
	private JLabel systemLbl;
	private JPanel menuView;
	private JPanel panelMenu;
	private JTabbedPane infoTab;
	private JLabel logoLbl;
	private JPanel loginInfoView;
	private JTree menuTree;

	/**
	 * Create the panel.
	 */
	public WBPanel() {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {100, 400};
		gridBagLayout.rowHeights = new int[] {50, 50, 300, 30};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0};
		setLayout(gridBagLayout);
		
		systemLbl = new JLabel("학사종합시스템");
		GridBagConstraints gbc_systemLbl = new GridBagConstraints();
		gbc_systemLbl.gridx = 0;
		gbc_systemLbl.gridy = 1;
		add(systemLbl, gbc_systemLbl);
		
		menuView = new JPanel();
		menuView.setBackground(Color.WHITE);
		GridBagConstraints gbc_menuView = new GridBagConstraints();
		gbc_menuView.insets = new Insets(0, 0, 5, 5);
		gbc_menuView.fill = GridBagConstraints.BOTH;
		gbc_menuView.gridx = 0;
		gbc_menuView.gridy = 2;
		add(menuView, gbc_menuView);
		menuView.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		menuTree = new JTree();
		menuTree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("조회") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("수업시스템");
						node_1.add(new DefaultMutableTreeNode("개설과목조회"));
						node_1.add(new DefaultMutableTreeNode("시험시간표조회"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("수강시스템");
						node_1.add(new DefaultMutableTreeNode("개설과목조회"));
						node_1.add(new DefaultMutableTreeNode("시험시간표조회"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("성적시스템");
						node_1.add(new DefaultMutableTreeNode("개설과목조회"));
						node_1.add(new DefaultMutableTreeNode("시험시간표조회"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("장학시스템");
						node_1.add(new DefaultMutableTreeNode("개설과목조회"));
						node_1.add(new DefaultMutableTreeNode("시험시간표조회"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("등록시스템");
						node_1.add(new DefaultMutableTreeNode("개설과목조회"));
						node_1.add(new DefaultMutableTreeNode("시험시간표조회"));
					add(node_1);
				}
			}
		));
		menuView.add(menuTree);
		
		panelMenu = new JPanel();
		GridBagConstraints gbc_panelMenu = new GridBagConstraints();
		gbc_panelMenu.insets = new Insets(0, 0, 5, 5);
		gbc_panelMenu.fill = GridBagConstraints.BOTH;
		gbc_panelMenu.gridx = 0;
		gbc_panelMenu.gridy = 3;
		add(panelMenu, gbc_panelMenu);
		panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));
		
		infoTab = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_infoTab = new GridBagConstraints();
		gbc_infoTab.insets = new Insets(0, 0, 5, 0);
		gbc_infoTab.fill = GridBagConstraints.BOTH;
		gbc_infoTab.gridx = 1;
		gbc_infoTab.gridy = 3;
		add(infoTab, gbc_infoTab);
		
		logoLbl = new JLabel("한국대학교");
		logoLbl.setBackground(Color.WHITE);
		GridBagConstraints gbc_logoLbl = new GridBagConstraints();
		gbc_logoLbl.gridx = 0;
		gbc_logoLbl.gridy = 0;
		add(logoLbl, gbc_logoLbl);
		
		loginInfoView = new JPanel();
		loginInfoView.setBackground(Color.WHITE);
		GridBagConstraints gbc_loginInfoView = new GridBagConstraints();
		gbc_loginInfoView.fill = GridBagConstraints.BOTH;
		gbc_loginInfoView.gridx = 1;
		gbc_loginInfoView.gridy = 0;
		add(loginInfoView, gbc_loginInfoView);
		
		JLabel loginInfoLbl = new JLabel("2008160124 홍길동");
		loginInfoView.add(loginInfoLbl);
		
		JButton logoutBtn = new JButton("로그아웃");
		loginInfoView.add(logoutBtn);
	}

	public JLabel getSystemLbl() {
		return systemLbl;
	}

	public JPanel getMenuView() {
		return menuView;
	}

	public JPanel getPanelMenu() {
		return panelMenu;
	}

	public JTabbedPane getInfoTab() {
		return infoTab;
	}

	public JLabel getLogoLbl() {
		return logoLbl;
	}

	public JPanel getLoginInfoView() {
		return loginInfoView;
	}
}
