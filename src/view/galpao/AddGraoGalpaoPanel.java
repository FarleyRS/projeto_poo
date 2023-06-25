package view.galpao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import model.Galpao;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddGraoGalpaoPanel extends JPanel {
	private JTextField tfNomeGrao;
	private JTextField tfTipoGrao;
	private JTextField tfImpureza;
	private JTextField tfDatacoleta;
	private JTextField tfMassa;
	private JTextField tfGalpao;
	private JCheckBox ckbxImpureza;
	private JList<Galpao> listGalpao;
	private JButton btnAddGrao;
	private JTextField tfQuantidade;

	/**
	 * Create the panel.
	 */
	public AddGraoGalpaoPanel() {
		setBackground(new Color(192, 192, 192));
		
		JLabel lbNomeGrao = new JLabel("Nome:");
		lbNomeGrao.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfNomeGrao = new JTextField();
		tfNomeGrao.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfTipoGrao = new JTextField();
		tfTipoGrao.setColumns(10);
		
		ckbxImpureza = new JCheckBox("Impureza");
		ckbxImpureza.setFont(new Font("Tahoma", Font.BOLD, 12));
		ckbxImpureza.setBackground(new Color(192, 192, 192));
		
		JLabel lblNewLabel = new JLabel("Grão");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_1 = new JLabel("Nível de impureza:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfImpureza = new JTextField();
		tfImpureza.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data de Coleta:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfDatacoleta = new JTextField();
		tfDatacoleta.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Massa:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfMassa = new JTextField();
		tfMassa.setColumns(10);
		
		tfGalpao = new JTextField();
		tfGalpao.setEditable(false);
		tfGalpao.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Galpao");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_5 = new JLabel("Quantidade:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfQuantidade = new JTextField();
		tfQuantidade.setColumns(10);
		
		btnAddGrao = new JButton("Adicionar");
		
		listGalpao = new JList<>();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfGalpao, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(41)
									.addComponent(btnAddGrao)))
							.addGap(10)
							.addComponent(listGalpao, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lbNomeGrao)
										.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(tfTipoGrao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfNomeGrao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3)
										.addComponent(lblNewLabel_2))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(ckbxImpureza)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_1)
									.addGap(15)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tfImpureza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfDatacoleta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfMassa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(34))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lbNomeGrao)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(tfNomeGrao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(tfTipoGrao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(tfDatacoleta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfMassa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ckbxImpureza)
						.addComponent(tfImpureza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(tfGalpao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(listGalpao, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_5)
								.addComponent(tfQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(92)
							.addComponent(btnAddGrao)))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		setLayout(groupLayout);
	}

	public JTextField getTfNomeGrao() {
		return tfNomeGrao;
	}

	public void setTfNomeGrao(JTextField tfNomeGrao) {
		this.tfNomeGrao = tfNomeGrao;
	}

	public JTextField getTfTipoGrao() {
		return tfTipoGrao;
	}

	public void setTfTipoGrao(JTextField tfTipoGrao) {
		this.tfTipoGrao = tfTipoGrao;
	}

	public JTextField getTfImpureza() {
		return tfImpureza;
	}

	public void setTfImpureza(JTextField tfImpureza) {
		this.tfImpureza = tfImpureza;
	}

	public JTextField getTfDatacoleta() {
		return tfDatacoleta;
	}

	public void setTfDatacoleta(JTextField tfDatacoleta) {
		this.tfDatacoleta = tfDatacoleta;
	}

	public JTextField getTfMassa() {
		return tfMassa;
	}

	public void setTfMassa(JTextField tfMassa) {
		this.tfMassa = tfMassa;
	}

	public JTextField getTfGalpao() {
		return tfGalpao;
	}

	public void setTfGalpao(JTextField tfGalpao) {
		this.tfGalpao = tfGalpao;
	}

	public JCheckBox getCkbxImpureza() {
		return ckbxImpureza;
	}

	public void setCkbxImpureza(JCheckBox ckbxImpureza) {
		this.ckbxImpureza = ckbxImpureza;
	}

	public JList<Galpao> getListGalpao() {
		return listGalpao;
	}

	public void setListGalpao(JList<Galpao> listGalpao) {
		this.listGalpao = listGalpao;
	}

	public JButton getBtnAddGrao() {
		return btnAddGrao;
	}

	public void setBtnAddGrao(JButton btnAddGrao) {
		this.btnAddGrao = btnAddGrao;
	}

	public JTextField getTfQuantidade() {
		return tfQuantidade;
	}

	public void setTfQuantidade(JTextField tfQuantidade) {
		this.tfQuantidade = tfQuantidade;
	}


}
