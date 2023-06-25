package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import factory.ConnectionFactory;
import model.Compra;

public class VendaDao {
	
	public boolean create(Compra compra) {
		try {
			Connection con = ConnectionFactory.createConnectionToMySQL();
			// execulta primeira inserção
            PreparedStatement pts = con.prepareStatement("INSERT INTO venda(id_cliente, id_grao, total, data) VALUES(?, ?, ?, ?);");
            pts.setInt(1, compra.getCliente().getId());
            pts.setInt(2, compra.getGrao().getId());
            pts.setDouble(3, compra.getTotal());
            pts.setString(4, compra.getData());
            pts.executeUpdate();
            return true;
		} catch (Exception e) {
			System.out.println("erro::::: " + e);
			return false;
		}
	}
	
	
}
