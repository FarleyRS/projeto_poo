package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import factory.ConnectionFactory;
import model.Grao;

public class GraoDao {
	
	public void creat(Grao grao) {
		String sql = "INSERT INTO grao(nome) VALUES(?);";
		String sqlPesquisa = "SELECT id FROM grao ORDER BY id ASC; ";
		String sql2 = "INSERT INTO tipograo VALUES(?,?,?,?,?,?);";
		try {
			Connection con = ConnectionFactory.createConnectionToMySQL();
			//execulta primeira inserção
			PreparedStatement pts = con.prepareStatement(sql);
			pts.setString(1, grao.getNome());			
			pts.executeUpdate();
			
			//execulta consulta
			pts = con.prepareStatement(sqlPesquisa);
			ResultSet rs = pts.executeQuery();
			
			int id=0;
			
			while (rs.next()) {
				id = rs.getInt("id");			
			}
			
			//segundo insert
			pts = con.prepareStatement(sql2);
			pts.setInt(1, id);
			pts.setString(2,grao.getTipo());
			pts.setBoolean(3, grao.isImpureza());
			pts.setDouble(4, grao.getNivel_impureza());
			pts.setString(5, grao.getData_coleta());
			pts.setDouble(6, grao.getDensidade());
			
			pts.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Grao read() {

		return null;
	}

	public void update(Grao grao) {

	}

	public void delete(int id) {

	}
}
