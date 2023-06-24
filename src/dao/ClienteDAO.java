package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	public Cliente readById(int id) {
		try(Connection con = ConnectionFactory.createConnectionToMySQL()) {
            // execulta primeira inserção
            PreparedStatement pts = con.prepareStatement("SELECT * FROM clientes WHERE id = ?");
            pts.setInt(1, id);
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
	
	public ArrayList<Cliente> readAll() {
		try(Connection con = ConnectionFactory.createConnectionToMySQL()){
			PreparedStatement pts = con.prepareStatement("SELECT * FROM clientes;");
			ResultSet rs = pts.executeQuery();
			
			ArrayList<Cliente> arc = new ArrayList<>();
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setCompras(rs.getInt("compras"));
				
				arc.add(cliente);
			}
			return arc;
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

}
