package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DashboardView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private GerenciaPanel gp = new GerenciaPanel();
	private VendaPanel vp = new VendaPanel();
	

	private JPanel toolbar = new JPanel();
	private JButton btnGerenciar = new JButton();
	private JButton btnVender = new JButton();
	private JPanel panel = new JPanel();
	
	public DashboardView() {
		panel.add("gerencia", gp);
		panel.add("venda", vp);
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
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(119, 136, 153));
		frame.setBounds(100, 100, 820, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		toolbar.setBackground(new Color(0, 128, 128));
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(toolbar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(toolbar, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(54, Short.MAX_VALUE))
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
		frame.getContentPane().setLayout(groupLayout);
	}
	

	public JButton getBtnGerenciar() {
		return btnGerenciar;
	}

	public void setBtnGerenciamento(JButton btnGerenciar) {
		this.btnGerenciar = btnGerenciar;
	}

	public JButton getBtnVender() {
		return btnVender;
	}

	public void setBtnVender(JButton btnVender) {
		this.btnVender = btnVender;
	}

	public void setBtnGerenciar(JButton btnGerenciar) {
		this.btnGerenciar = btnGerenciar;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	public GerenciaPanel getGp() {
		return gp;
	}

	public void setGp(GerenciaPanel gp) {
		this.gp = gp;
	}

	public VendaPanel getVp() {
		return vp;
	}

	public void setVp(VendaPanel vp) {
		this.vp = vp;
	}
	
}
