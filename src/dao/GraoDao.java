package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import factory.ConnectionFactory;
import model.Galpao;
import model.Grao;

public class GraoDao {

	public void create(Grao grao) {

		try {
			Connection con = ConnectionFactory.createConnectionToMySQL();
			// execulta primeira inserção
			PreparedStatement pts = con.prepareStatement("INSERT INTO grao(nome) VALUES(?);");
			pts.setString(1, grao.getNome());
			pts.executeUpdate();

			// execulta consulta
			pts = con.prepareStatement("SELECT id FROM grao ORDER BY id ASC; ");
			ResultSet rs = pts.executeQuery();

			int id = 0;

			while (rs.next()) {
				id = rs.getInt("id");
			}

			// segundo insert
			pts = con.prepareStatement("INSERT INTO tipograo VALUES(?,?,?,?,?,?);");
			pts.setInt(1, id);
			pts.setString(2, grao.getTipo());
			pts.setBoolean(3, grao.isImpureza());
			pts.setDouble(4, grao.getNivel_impureza());
			pts.setString(5, grao.getData_coleta());
			pts.setDouble(6, grao.getMassa());

			pts.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Grao readById(int id) {
		
		try {
			Connection con = ConnectionFactory.createConnectionToMySQL();
			// execulta primeira inserção
			PreparedStatement pts = con.prepareStatement("SELECT grao.nome, tipograo.tipo, tipograo.impureza, tipograo.nivel_impur, "
					+ "tipograo.data_coleta, tipograo.densidade FROM grao INNER JOIN tipograo ON grao.id = tipograo.id WHERE grao.id = ?;");

			pts.setInt(1, id);
			ResultSet rs = pts.executeQuery();
			Grao g = null;
			while (rs.next()) {
				String nome = rs.getString("nome");
				String tipo = rs.getString("tipo");
				boolean impureza = rs.getBoolean("impureza");
				double nivel_impur = rs.getDouble("nivel_impur");
				String data_coleta = rs.getString("data_coleta");
				double massa = rs.getDouble("densidade");
				
				g = new Grao(nome, tipo, impureza, massa, nivel_impur, data_coleta);
			}
			return g;
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
			return null;
		}
	}

	public ArrayList<Grao> readAll() {
		try {
			Connection con = ConnectionFactory.createConnectionToMySQL();
			// execulta primeira inserção
			PreparedStatement pts = con.prepareStatement("SELECT grao.nome, tipograo.tipo, tipograo.impureza, tipograo.nivel_impur, "
					+ "tipograo.data_coleta, tipograo.densidade FROM grao INNER JOIN tipograo ON grao.id = tipograo.id;");

			ResultSet rs = pts.executeQuery();
			ArrayList<Grao> arg = new ArrayList<>();
			while (rs.next()) {
				String nome = rs.getString("nome");
				String tipo = rs.getString("tipo");
				boolean impureza = rs.getBoolean("impureza");
				double nivel_impur = rs.getDouble("nivel_impur");
				String data_coleta = rs.getString("data_coleta");
				double massa = rs.getDouble("densidade");
				Grao g = null;
				g = new Grao(nome, tipo, impureza, massa, nivel_impur, data_coleta);
				
				arg.add(g);
			}
			return arg;
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
			return null;
		}
	}

	public void update(Grao grao, int id) {
		try {
			Connection con = ConnectionFactory.createConnectionToMySQL();
			// execulta primeira inserção
			PreparedStatement pts = con.prepareStatement("UPDATE grao SET nome = ? WHERE id = ?;");
			pts.setString(1, grao.getNome());
			pts.setInt(2, id);
			pts.executeUpdate();


			// segundo insert
			pts = con.prepareStatement("UPDATE tipograo SET tipo = ?, impureza = ?, nivel_impur = ?"
					+ ", data_coleta = ?, densidade = ? WHERE id = ?;");
			pts.setInt(6, id);
			pts.setString(1, grao.getTipo());
			pts.setBoolean(2, grao.isImpureza());
			pts.setDouble(3, grao.getNivel_impureza());
			pts.setString(4, grao.getData_coleta());
			pts.setDouble(5, grao.getMassa());

			pts.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try {
			Connection con = ConnectionFactory.createConnectionToMySQL();
		
			PreparedStatement pts = con.prepareStatement("DELETE FROM tipograo WHERE id = ?");
			pts.setInt(1, id);

			pts.executeUpdate();

			pts = con.prepareStatement("DELETE FROM grao WHERE id=?");
			pts.setInt(1, id);

			pts.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro " + e.getMessage());
		}
	}
}
