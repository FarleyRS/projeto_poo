package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import factory.ConnectionFactory;
import model.Galpao;
import model.Grao;
import model.Silo;

/**
 * Esta classe é responsável por realizar operações de acesso a dados
 * relacionadas ao objeto Galpao.
 */
public class GalpaoDao {

	/**
	 * Cria um novo galpão no banco de dados.
	 *
	 * @param galpao O objeto Galpao a ser criado.
	 */
	public boolean create(Galpao galpao) {
		try (Connection con = ConnectionFactory.createConnectionToMySQL()) {
			// executa primeira inserção
			PreparedStatement pts = con
					.prepareStatement("INSERT INTO armazenamento(capMax, quantArmaz, altura) VALUES(?, ?, ?);");
			pts.setDouble(1, galpao.getCapMax());
			pts.setDouble(2, galpao.getCapArmazenada());
			pts.setDouble(3, galpao.getAltura());
			pts.executeUpdate();

			// executa consulta
			pts = con.prepareStatement("SELECT id FROM armazenamento ORDER BY id DESC LIMIT 1;");
			ResultSet rs = pts.executeQuery();

			int id = 0;
			if (rs.next()) {
				id = rs.getInt("id");
			}

			// segundo insert
			pts = con.prepareStatement("INSERT INTO galpao VALUES(?, ?, ?);");
			pts.setInt(1, id);
			pts.setDouble(2, galpao.getLargura());
			pts.setDouble(3, galpao.getComprimento());
			pts.executeUpdate();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Retorna um galpão do banco de dados com base no ID fornecido.
	 *
	 * @param id O ID do galpão a ser buscado.
	 * @return O objeto Galpao correspondente ao ID fornecido, ou null se não
	 *         encontrado.
	 */
	public Galpao readById(int id) {
		try (Connection con = ConnectionFactory.createConnectionToMySQL()) {
			// executa consulta
			 PreparedStatement pts = con.prepareStatement("SELECT armazenamento.id, armazenamento.capMax, "
		        		+ "armazenamento.quantArmaz,armazenamento.altura, armazenamento.grao , galpao.largura, galpao.comprimento "
		        		+ "FROM armazenamento INNER JOIN galpao ON armazenamento.id = galpao.id WHERE armazenamento.id = ?;");

			pts.setInt(1, id);
			ResultSet rs = pts.executeQuery();
			GraoDao gd = new GraoDao();
			Galpao g = null;
			if (rs.next()) {
				double capMax = rs.getDouble("capMax");
				double quantArmaz = rs.getDouble("quantArmaz");
				double altura = rs.getDouble("altura");
				Grao grao = gd.readById(rs.getInt("grao"));
				double largura = rs.getDouble("largura");
				double compriment = rs.getDouble("comprimento");
				g = new Galpao(capMax, quantArmaz, null, grao, altura, largura, compriment);
			}
			return g;
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
			return null;
		}
	}

	/**
	 * Retorna uma lista de todos os galpões existentes no banco de dados.
	 *
	 * @return Uma lista de objetos Galpao.
	 */
	public ArrayList<Galpao> readAll() {
	    try (Connection con = ConnectionFactory.createConnectionToMySQL()) {
	        // executa consulta
	        PreparedStatement pts = con.prepareStatement("SELECT armazenamento.id, armazenamento.capMax, "
	        		+ "armazenamento.quantArmaz,armazenamento.altura, armazenamento.grao , galpao.largura, galpao.comprimento "
	        		+ "FROM armazenamento INNER JOIN galpao ON armazenamento.id = galpao.id;");

	        ResultSet rs = pts.executeQuery();
	        ArrayList<Galpao> ars = new ArrayList<>();
	        GraoDao gd = new GraoDao();
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            double capMax = rs.getDouble("capMax");
	            double quantArmaz = rs.getDouble("quantArmaz");
	            double altura = rs.getDouble("altura");
	            Grao grao = gd.readById(rs.getInt("grao"));
	            double largura = rs.getDouble("largura");
	            double compriment = rs.getDouble("comprimento");
	            Galpao g = new Galpao(id, capMax, quantArmaz, null, grao, altura, largura, compriment);
	            g.setTipo(g);
	            ars.add(g);
	        }
	        return ars;
	    } catch (Exception e) {
	        System.out.println("Erro " + e.getMessage());
	        return null;
	    }
	}

	/**
	 * Atualiza os dados de um galpão no banco de dados.
	 *
	 * @param galpao O objeto Galpao com os dados atualizados.
	 * @param id     O ID do galpão a ser atualizado.
	 * @param idGrao O ID do grão associado ao galpão, ou 0 se nenhum grão estiver
	 *               associado.
	 */
	public void update(Galpao galpao, int id, int idGrao) {
		try (Connection con = ConnectionFactory.createConnectionToMySQL()) {
			// Update armazenamento
			String armazenamentoSql = "UPDATE armazenamento SET capMax = ?, quantArmaz = ?, altura = ?";
			if (idGrao != 0) {
				armazenamentoSql += ", grao = ?";
			}
			armazenamentoSql += " WHERE id = ?;";
			PreparedStatement pts = con.prepareStatement(armazenamentoSql);
			pts.setDouble(1, galpao.getCapMax());
			pts.setDouble(2, galpao.getCapArmazenada());
			pts.setDouble(3, galpao.getAltura());
			if (idGrao != 0) {
				pts.setInt(4, idGrao);
				pts.setInt(5, id);
			} else {
				pts.setInt(4, id);
			}
			pts.executeUpdate();

			// Update galpao
			String galpaoSql = "UPDATE galpao SET largura = ?, comprimento = ? WHERE id = ?;";
			pts = con.prepareStatement(galpaoSql);
			pts.setDouble(1, galpao.getLargura());
			pts.setDouble(2, galpao.getComprimento());
			pts.setInt(3, id);
			pts.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}


	/**
	 * Exclui um galpão do banco de dados.
	 *
	 * @param id O ID do galpão a ser excluído.
	 */
	public void delete(int id) {
		try {
			Connection con = ConnectionFactory.createConnectionToMySQL();
			// delata galpao
			PreparedStatement pts = con.prepareStatement("DELETE FROM galpao WHERE id=?");
			pts.setInt(1, id);
			pts.executeUpdate();

			// deleta armazenamento
			pts = con.prepareStatement("DELETE FROM armazenamento WHERE id = ?");
			pts.setInt(1, id);
			pts.executeUpdate();

		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
	}
}
