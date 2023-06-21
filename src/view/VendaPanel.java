package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ClienteController;
import controller.CompraController;
import dao.GraoDao;
import model.Cliente;
import model.Compra;
import model.Grao;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class VendaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public VendaPanel() {
		setBackground(new Color(192, 192, 192));
		
		JButton btnNewCliente = new JButton("Adicionar cliente");
		btnNewCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCliente cc = new CadastroCliente();
				cc.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("CPF DO CLIENTE:");
		
		JFormattedTextField cpf = new JFormattedTextField();
		
		JLabel lblIdDoGro = new JLabel("ID DO GRÃO:");
		
		JFormattedTextField idgrao = new JFormattedTextField();
		
		JLabel lblValorDaCompra = new JLabel("VALOR DA COMPRA:");
		
		JFormattedTextField valor = new JFormattedTextField();
		
		JLabel lblDataDaCompra = new JLabel("DATA DA COMPRA:");
		
		JFormattedTextField datacompra = new JFormattedTextField();
		
		JButton btnComprar = new JButton("EFETUAR COMPRA");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpfcliente = cpf.getText();
				int id = Integer.parseInt(idgrao.getText());
				String data = datacompra.getText();
				double total = Double.parseDouble(valor.getText());
				Cliente cliente = new ClienteController().searchByCpf(cpfcliente);
				//muda o searchbyid para o readbyid
				Grao grao = new GraoDao().searchById(id);
				Compra compra = new Compra();
				compra.setCliente(cliente);
				compra.setGrao(grao);
				compra.setTotal(total);
				compra.setData(data);
				CompraController compraController = new CompraController();
				compraController.cadastrar(compra);
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblDataDaCompra, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(idgrao, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblIdDoGro, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel)
											.addComponent(cpf, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 370, Short.MAX_VALUE)
										.addComponent(btnNewCliente)
										.addGap(33)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblValorDaCompra, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(valor, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnComprar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(datacompra, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewCliente))
					.addGap(18)
					.addComponent(lblIdDoGro)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(idgrao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblValorDaCompra)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(valor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblDataDaCompra)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(datacompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnComprar)
					.addContainerGap(235, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	public JPanel getVendaPanel() {
		return this;
	}
}
