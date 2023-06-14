package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import factory.ConnectionFactory;
import model.Galpao;
import model.Silo;

/**
 * Esta classe é responsável por realizar operações de acesso a dados relacionadas ao objeto Galpao.
 */
public class GalpaoDao {

    /**
     * Cria um novo galpão no banco de dados.
     *
     * @param galpao O objeto Galpao a ser criado.
     */
    public void create(Galpao galpao) {
        try {
            Connection con = ConnectionFactory.createConnectionToMySQL();
            // execulta primeira inserção
            PreparedStatement pts = con.prepareStatement("INSERT INTO armazenamento(capMax, quantArmaz, altura) VALUES(?, ?, ?);");
            pts.setDouble(1, galpao.getCapMax());
            pts.setDouble(2, galpao.getCapArmazenada());
            pts.setDouble(3, galpao.getAltura());
            pts.executeUpdate();

            // execulta consulta
            pts = con.prepareStatement("SELECT id FROM armazenamento ORDER BY id ASC; ");
            ResultSet rs = pts.executeQuery();

            int id = 0;

            while (rs.next()) {
                id = rs.getInt("id");
            }

            // segundo insert
            pts = con.prepareStatement("INSERT INTO galpao VALUES(?, ?, ?);");
            pts.setInt(1, id);
            pts.setDouble(3, galpao.getComprimento());
            pts.setDouble(2, galpao.getLargura());
            pts.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna um galpão do banco de dados com base no ID fornecido.
     *
     * @param id O ID do galpão a ser buscado.
     * @return O objeto Galpao correspondente ao ID fornecido, ou null se não encontrado.
     */
    public Galpao readById(int id) {
        try {
            Connection con = ConnectionFactory.createConnectionToMySQL();
            // execulta primeira inserção
            PreparedStatement pts = con.prepareStatement("SELECT armazenamento.capMax,armazenamento.quantArmaz,"
                    + " armazenamento.altura, galpao.largura, galpao.comprimento FROM armazenamento "
                    + "INNER JOIN galpao ON armazenamento.id = galpao.id WHERE armazenamento.id = ?;");

            pts.setInt(1, id);
            ResultSet rs = pts.executeQuery();
            Galpao g = null;
            while (rs.next()) {
                double capMax = rs.getDouble("capMax");
                double quantArmaz = rs.getDouble("quantArmaz");
                double altura = rs.getDouble("altura");
                double largura = rs.getDouble("largura");
                double compriment = rs.getDouble("comprimento");
                g = new Galpao(capMax, quantArmaz, null, null, altura, largura, compriment);
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
        try {
            Connection con = ConnectionFactory.createConnectionToMySQL();
            // execulta primeira inserção
            PreparedStatement pts = con.prepareStatement("SELECT armazenamento.capMax, armazenamento.quantArmaz, armazenamento.altura, "
                    + "silo.diametro FROM armazenamento INNER JOIN silo ON armazenamento.id = silo.id;");

            ResultSet rs = pts.executeQuery();
            ArrayList<Galpao> ars = new ArrayList<>();
            while (rs.next()) {
                Galpao g = null;
                double capMax = rs.getDouble("capMax");
                double quantArmaz = rs.getDouble("quantArmaz");
                double altura = rs.getDouble("altura");
                double largura = rs.getDouble("largura");
                double compriment = rs.getDouble("comprimento");
                g = new Galpao(capMax, quantArmaz, g, null, altura, largura, compriment);
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
     * @param galpao  O objeto Galpao com os dados atualizados.
     * @param id      O ID do galpão a ser atualizado.
     * @param idGrao  O ID do grão associado ao galpão, ou 0 se nenhum grão estiver associado.
     */
    public void update(Galpao galpao, int id, int idGrao) {
        if (idGrao != 0) {
            try {
                Connection con = ConnectionFactory.createConnectionToMySQL();
                // update armazenamento
                PreparedStatement pts = con.prepareStatement("UPDATE armazenamento SET capMax = ?, quantArmaz = ?, altura = ?, grao = ? WHERE id = ?;");
                pts.setInt(5, id);
                pts.setDouble(1, galpao.getCapMax());
                pts.setDouble(2, galpao.getCapArmazenada());
                pts.setDouble(3, galpao.getAltura());
                pts.setInt(4, idGrao);
                pts.executeUpdate();

                // update galpao
                pts = con.prepareStatement("UPDATE galpao SET largura = ?, comprimento = ? WHERE id = ?;");
                pts.setInt(3, id);
                pts.setDouble(1, galpao.getLargura());
                pts.setDouble(2, galpao.getLargura());
                pts.executeUpdate();

            } catch (Exception e) {
                System.out.println("Erro " + e.getMessage());
            }
        } else {
            try {
                Connection con = ConnectionFactory.createConnectionToMySQL();
                // update armazenamento
                PreparedStatement pts = con.prepareStatement("UPDATE armazenamento SET capMax = ?, quantArmaz = ?, altura = ? WHERE id = ?;");
                pts.setInt(4, id);
                pts.setDouble(1, galpao.getCapMax());
                pts.setDouble(2, galpao.getCapArmazenada());
                pts.setDouble(3, galpao.getAltura());
                pts.executeUpdate();

                // update galpao
                pts = con.prepareStatement("UPDATE galpao SET largura = ?, comprimento = ? WHERE id = ?;");
                pts.setInt(3, id);
                pts.setDouble(1, galpao.getLargura());
                pts.setDouble(2, galpao.getLargura());
                pts.executeUpdate();

            } catch (Exception e) {
                System.out.println("Erro " + e.getMessage());
            }
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
