package controller;

import dao.CompraDAO;
import model.Compra;

public class CompraController {
	
public boolean cadastrar(Compra compra) {
		Compra c = compra;
		CompraDAO compraDAO = new CompraDAO();
		if (compraDAO.cadastrar(c)) {
			return true;
		} else {
			return false;
		}
	}
}
