package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import factory.ConnectionFactory;
import model.Galpao;

public class GalpaoDao {
	public void creat(Galpao galpao) {
		
		String sql = "";
		try {
			Connection con = ConnectionFactory.createConnectionToMySQL();
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	}

	public Galpao read() {

		return null;
	}

	public void update(Galpao galpao) {

	}

	public void delete(int id) {

	}

}
