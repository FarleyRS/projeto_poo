package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class GerenciaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnGerenciarGalpao = new JButton();

	private JButton btnGerenciarSilos = new JButton();
	private JPanel ContainerPanel = new JPanel();	

	/**
	 * Create the panel.
	 */
	public GerenciaPanel() {
		initComponents();
		
		ContainerPanel.setLayout(new GridLayout(1, 0));
		for (int i = 0; i < 3; i++) {
			JProgressBar d = new JProgressBar();
			d.setStringPainted(true);
			d.setOrientation(SwingConstants.VERTICAL);
			ContainerPanel.add(d);
		
		}
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setBackground(new Color(128, 128, 128));

		btnGerenciarGalpao.setText("Gerenciar Galpões");
		btnGerenciarSilos.setText("Gerenciar Silos");

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnGerenciarSilos, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
								.addComponent(btnGerenciarGalpao, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
						.addGap(18)
						.addComponent(ContainerPanel, GroupLayout.PREFERRED_SIZE, 625, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(ContainerPanel, GroupLayout.DEFAULT_SIZE, 354,
														Short.MAX_VALUE)
												.addContainerGap())
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(btnGerenciarGalpao, GroupLayout.PREFERRED_SIZE, 51,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(btnGerenciarSilos, GroupLayout.PREFERRED_SIZE,
														50, GroupLayout.PREFERRED_SIZE)
												.addGap(246)))));
		setLayout(groupLayout);
	}

	public JPanel getGerenciaPanel() {
		return this;
	}

	public Component getBtnGerenciarGalpao() {
		return btnGerenciarGalpao;
	}

	public void setBtnGerenciarGalpao(JButton btnGerenciarGalpao) {
		this.btnGerenciarGalpao = btnGerenciarGalpao;
	}

	public JButton getBtnGerenciarSilos() {
		return btnGerenciarSilos;
	}

	public void setBtnGerenciarSilos(JButton btnGerenciarSilos) {
		this.btnGerenciarSilos = btnGerenciarSilos;
	}

	public JPanel getContainerPanel() {
		return ContainerPanel;
	}

	public void setContainerPanel(JPanel containerPanel) {
		ContainerPanel = containerPanel;
	}
}
