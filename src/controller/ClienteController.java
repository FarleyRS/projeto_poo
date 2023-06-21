package controller;

import dao.ClienteDAO;
import model.Cliente;

public class ClienteController {
	
	public boolean create(Cliente cliente) {
		Cliente c = cliente;
		ClienteDAO clienteDAO = new ClienteDAO();
		if (clienteDAO.create(c)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Cliente searchByCpf(String cpfCliente) {
		String cpf = cpfCliente;
		Cliente cliente = new ClienteDAO().searchByCpf(cpfCliente);
		return cliente;
	}

}
