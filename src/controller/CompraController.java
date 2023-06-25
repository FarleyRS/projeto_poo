package controller;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.ClienteDao;
import dao.VendaDao;
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
	private ClienteDao clienteDao;
	private VendaDao vendaDao;
	private GraoDao graoDao;

	public CompraController(VendaPanel vp) {
		this.vp = vp;
		clienteDao = new ClienteDao();
		vendaDao = new VendaDao();
		graoDao = new GraoDao();
		initCompraController();
	}

	public void initCompraController() {
		vp.getBtnEfetuarCompra().addActionListener(e -> efetuarCompra());
		vp.getBtnNovoCliente().addActionListener(e -> adicionarCliente());

		preencherListaClientes();
		preencherListaGraos();

		vp.getListCliente().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					Cliente cliente = (Cliente) vp.getListCliente().getSelectedValue();
					idCliente = cliente.getId();
				}
			}
		});

		vp.getTableGrao().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = vp.getTableGrao().getSelectedRow();
				if (selectedRow != -1) {
					idGrao = (int) vp.getTableGrao().getValueAt(selectedRow, 0);
				}
			}
		});
	}

	public void efetuarCompra() {
		double quantidade = Double.parseDouble(vp.getTfQuantidadeGrao().getText());
		double total = quantidade * 1.34;
		data = vp.getFtfData().getText();
		Cliente cliente = clienteDao.readById(idCliente);
		Grao grao = graoDao.readById(idGrao);

		if (vendaDao.create(new Compra(cliente, grao, total, data))) {
			JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!");
			vp.getTfQuantidadeGrao().setText("");
		} else {
			JOptionPane.showMessageDialog(null, "Falha ao efetuar a compra!");
		}
	}

	public void adicionarCliente() {
		cc = new CadastroClienteView();
		cc.getBtnNewButton().addActionListener(e -> {
			Cliente cliente = new Cliente();

			cliente.setNome(cc.getTfNomeCliente().getText());
			cliente.setCpf(cc.getFormattedTextField().getText());

			if (clienteDao.create(cliente)) {
				JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");
				preencherListaClientes();
				cc.getTfNomeCliente().setText("");
				cc.getFormattedTextField().setText("");
				cc.getFrame().setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Falha ao adicionar cliente!");
			}
		});
	}

	public void preencherListaClientes() {
		List<Cliente> clientes = clienteDao.readAll();

		DefaultListModel<Cliente> model = new DefaultListModel<>();
		for (Cliente cliente : clientes) {
			model.addElement(cliente);
		}
		vp.getListCliente().setModel(model);
	}

	public void preencherListaGraos() {
		List<Grao> graos = graoDao.readAll();

		String[] columnNames = {"Item", "Value"};

        // Cria o modelo de dados para o JTable
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Adiciona os dados ao modelo de dados
        GraoDao gd = new GraoDao();
        
        for (Grao grao : graos) {
            Object[] row = {grao.getId(),grao.getNome()};
            model.addRow(row);
        }
		vp.getTableGrao().setModel(model);
	}
}