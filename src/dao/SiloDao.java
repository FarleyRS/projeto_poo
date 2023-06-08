package dao;

import java.sql.Connection;
import java.sql.Statement;

import factory.ConnectionFactory;
import model.Silo;

public class SiloDao {

	public void creat(Silo silo) {
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

	public Silo read() {

		return null;
	}

	public void update(Silo silo) {

	}

	public void delete(int id) {

	}

}
