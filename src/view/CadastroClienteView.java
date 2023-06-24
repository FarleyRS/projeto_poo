package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class CadastroClienteView{
	
	private JFrame frame;
	private JTextField tfNomeCliente;
	private JFormattedTextField formattedTextField;
	private JButton btnNewButton;
	
	
	public CadastroClienteView() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 435, 216);
		
		JLabel lblNewLabel = new JLabel("Nome Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		tfNomeCliente = new JTextField();
		tfNomeCliente.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnNewButton = new JButton("Cadastrar");
		
		MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("###.###.###-##");
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
		
		formattedTextField = new JFormattedTextField(formatter);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tfNomeCliente, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addGap(72)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfNomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(142, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}


	public JTextField getTfNomeCliente() {
		return tfNomeCliente;
	}


	public void setTfNomeCliente(JTextField tfNomeCliente) {
		this.tfNomeCliente = tfNomeCliente;
	}


	public JFormattedTextField getFormattedTextField() {
		return formattedTextField;
	}


	public void setFormattedTextField(JFormattedTextField formattedTextField) {
		this.formattedTextField = formattedTextField;
	}


	public JButton getBtnNewButton() {
		return btnNewButton;
	}


	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}


	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
}
