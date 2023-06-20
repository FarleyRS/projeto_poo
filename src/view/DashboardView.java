package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DashboardView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmAgrotech;


	private JPanel toolbar = new JPanel();
	private JButton btnGerenciar = new JButton();
	private JButton btnVender = new JButton();
	private JPanel panel = new JPanel();
	
	public DashboardView() {
		initComponents();		
		
	}
	
	private void initComponents() {
		btnVender.setText("Vender");
		btnVender.setRolloverEnabled(false);
		btnVender.setRequestFocusEnabled(false);
		btnVender.setForeground(Color.WHITE);
		btnVender.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVender.setFocusable(false);
		btnVender.setBorder(null);
		btnVender.setBackground(new Color(0, 128, 128));
		frmAgrotech = new JFrame();
		frmAgrotech.setTitle("AgroTech");
		frmAgrotech.setResizable(false);
		frmAgrotech.getContentPane().setBackground(new Color(119, 136, 153));
		frmAgrotech.setBounds(100, 100, 880, 500);
		frmAgrotech.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgrotech.setVisible(true);
		
		toolbar.setBackground(new Color(0, 128, 128));
		
		
		GroupLayout groupLayout = new GroupLayout(frmAgrotech.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
						.addComponent(toolbar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(toolbar, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(new CardLayout(0, 0));
		btnGerenciar.setFocusable(false);
		btnGerenciar.setRolloverEnabled(false);
		btnGerenciar.setRequestFocusEnabled(false);
		
		btnGerenciar.setText("Gerenciamento");
		btnGerenciar.setBackground(new Color(0, 128, 128));
		btnGerenciar.setBorder(null);
		btnGerenciar.setForeground(new Color(255, 255, 255));
		btnGerenciar.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_toolbar = new GroupLayout(toolbar);
		gl_toolbar.setHorizontalGroup(
			gl_toolbar.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_toolbar.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnGerenciar, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnVender, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(393, Short.MAX_VALUE))
		);
		gl_toolbar.setVerticalGroup(
			gl_toolbar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toolbar.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_toolbar.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGerenciar)
						.addComponent(btnVender, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		toolbar.setLayout(gl_toolbar);
		frmAgrotech.getContentPane().setLayout(groupLayout);
	}
	

	public JButton getBtnGerenciar() {
		return btnGerenciar;
	}

	public JButton getBtnVender() {
		return btnVender;
	}

	public JPanel getPanel() {
		return panel;
	}
	
	
	
}
