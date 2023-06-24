package controller;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.ClienteDAO;
import dao.CompraDAO;
import dao.GraoDao;
import model.Cliente;
import model.Compra;
import model.Grao;
import view.CadastroClienteView;
import view.VendaPanel;

public class CompraController {

	private VendaPanel vp;
	private CadastroClienteView cc;
	private int idGrao;
	private int idCliente;
	private String data;
	private double valor;
	private ClienteDAO c;
	private CompraDAO compraDAO;
	private GraoDao g;

	public CompraController(VendaPanel vp) {
		// TODO Auto-generated constructor stub
		this.vp = vp;
		initCompraController();
	}

	public void initCompraController() {
		c = new ClienteDAO();
		compraDAO = new CompraDAO();
		g = new GraoDao();

		vp.getBtnEfetuarComprar().addActionListener(e -> efetuarCompra());
		vp.getBtnNovoCliente().addActionListener(e -> AddCliente());

		preencheListaCliente();
		preenchetListaGrao();

		// Adiciona um ActionListener ao JTable para exibir a linha selecionada
		vp.getListCliente().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (!e.getValueIsAdjusting()) {
					Cliente cliente = (Cliente) vp.getListCliente().getSelectedValue();
					idCliente = cliente.getId();
				}
			}
		});

		vp.getTableGrao().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int selectedRow = vp.getTableGrao().getSelectedRow();
				if (selectedRow != -1) {
					Object value = vp.getTableGrao().getValueAt(selectedRow, 0);
					idGrao = (int) value;
				}
			}
		});

	}

	public void efetuarCompra() {
		double total = Double.parseDouble(vp.getTfQuantidadeGrao().getText());
		total = total * 1.34;
		data = vp.getFtfData().getText();
		Cliente cliente = c.readById(idCliente);
		Grao grao = g.readById(idGrao);

		if (compraDAO.create(new Compra(cliente, grao, total, data))) {
			JOptionPane.showMessageDialog(null, "Efetuada com Sucesso!");
			vp.getTfQuantidadeGrao().setText("");
		} else {
			JOptionPane.showMessageDialog(null, "Falha!");
		}
	}

	public void AddCliente() {
		cc = new CadastroClienteView();
		cc.getBtnNewButton().addActionListener(e -> {
			Cliente cliente = new Cliente();

			cliente.setNome(cc.getTfNomeCliente().getText());
			cliente.setCpf(cc.getFormattedTextField().getText());

			if (c.create(cliente)) {
				JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
				preencheListaCliente();
				cc.getTfNomeCliente().setText("");
				cc.getFormattedTextField().setText("");
				cc.getFrame().setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Falha!");
			}

		});

	}

	public void preencheListaCliente() {
		ClienteDAO cd = new ClienteDAO();

		List<Cliente> clientes = cd.readAll();

		DefaultListModel<Cliente> model = new DefaultListModel<>();
		for (Cliente cliente : clientes) {
			model.addElement(cliente);
		}
		vp.getListCliente().setModel(model);
	}

	public void preenchetListaGrao() {
		GraoDao gd = new GraoDao();

		List<Grao> graos = gd.readAll();

		DefaultListModel<Grao> model = new DefaultListModel<>();
		for (Grao grao : graos) {
			model.addElement(grao);
		}

	}

}
