package view.galpao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class AddGalpaoPanel extends JPanel {
	private JTextField tfAltura;
	private JTextField tfLargura;
	private JTextField tfComprimento;
	private JButton btnNewGalpao;

	/**
	 * Create the panel.
	 */
	public AddGalpaoPanel() {

		initComponents();
	}

	private void initComponents() {
		setBackground(new Color(192, 192, 192));

		JLabel lbAltura = new JLabel("Altura:");
		lbAltura.setForeground(new Color(0, 0, 0));
		lbAltura.setFont(new Font("Tahoma", Font.BOLD, 12));

		tfAltura = new JTextField();
		tfAltura.setColumns(10);

		tfLargura = new JTextField();
		tfLargura.setColumns(10);

		JLabel lbLargura = new JLabel("Largura:");
		lbLargura.setForeground(Color.BLACK);
		lbLargura.setFont(new Font("Tahoma", Font.BOLD, 12));

		tfComprimento = new JTextField();
		tfComprimento.setColumns(10);

		JLabel lblComprimento = new JLabel("Comprimento:");
		lblComprimento.setForeground(Color.BLACK);
		lblComprimento.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnNewGalpao = new JButton("Adicionar");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(94).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING, false)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addComponent(lbLargura, GroupLayout.PREFERRED_SIZE, 59,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(tfLargura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addComponent(lbAltura)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(tfAltura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblComprimento)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(tfComprimento,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup().addGap(138).addComponent(btnNewGalpao)))
				.addContainerGap(94, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(64)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfAltura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lbAltura))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfLargura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lbLargura, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGap(20)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblComprimento, GroupLayout.PREFERRED_SIZE, 15,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(tfComprimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(61).addComponent(btnNewGalpao).addContainerGap(83, Short.MAX_VALUE)));
		setLayout(groupLayout);

	}

	public JTextField getTfAltura() {
		return tfAltura;
	}

	public void setTfAltura(JTextField tfAltura) {
		this.tfAltura = tfAltura;
	}

	public JTextField getTfLargura() {
		return tfLargura;
	}

	public void setTfLargura(JTextField tfLargura) {
		this.tfLargura = tfLargura;
	}

	public JTextField getTfComprimento() {
		return tfComprimento;
	}

	public void setTfComprimento(JTextField tfComprimento) {
		this.tfComprimento = tfComprimento;
	}

	public JButton getBtnNewGalpao() {
		return btnNewGalpao;
	}

	public void setBtnNewGalpao(JButton btnNewGalpao) {
		this.btnNewGalpao = btnNewGalpao;
	}
	
	
}
