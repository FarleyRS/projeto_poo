package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import factory.ConnectionFactory;
import model.Cliente;

public class ClienteDAO {
	
	public boolean create(Cliente cliente) {
		try {
			Connection con = ConnectionFactory.createConnectionToMySQL();
            // execulta primeira inserção
            PreparedStatement pts = con.prepareStatement("INSERT INTO clientes(nome, cpf, compras) VALUES(?, ?, ?);");
            pts.setString(1, cliente.getNome());
            pts.setString(2, cliente.getCpf());
            pts.setInt(3, cliente.getCompras());
            pts.executeUpdate();
            return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Cliente searchByCpf(String cpfCliente) {
		try {
			String cpf = cpfCliente;
			Connection con = ConnectionFactory.createConnectionToMySQL();
            // execulta primeira inserção
            PreparedStatement pts = con.prepareStatement("SELECT * FROM clientes WHERE cpf = ?");
            pts.setString(1, cpf);
            ResultSet rs = pts.executeQuery();
            Cliente cliente = new Cliente();
            if (rs.next()) {
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setCompras(rs.getInt("compras"));
			}
            return cliente;
		} catch (Exception e) {
			return null;
		}
	}

}
