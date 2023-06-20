package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import factory.ConnectionFactory;
import model.Silo;
/**
 * Esta classe é responsável por realizar operações de acesso a dados relacionadas ao objeto Silo.
*/
public class SiloDao {

    /**
     * Cria um novo silo no banco de dados.
     * 
     * @param silo O objeto Silo a ser criado.
     */
    public void create(Silo silo) {
        try {
            Connection con = ConnectionFactory.createConnectionToMySQL();
            
            // Executa primeira inserção
            PreparedStatement pts = con.prepareStatement("INSERT INTO armazenamento(capMax, quantArmaz, altura) VALUES(?, ?, ?);");
            pts.setDouble(1, silo.getCapMax());
            pts.setDouble(2, silo.getCapArmazenada());
            pts.setDouble(3, silo.getAltura());
            pts.executeUpdate();

            // Executa consulta
            pts = con.prepareStatement("SELECT id FROM armazenamento ORDER BY id ASC; ");
            ResultSet rs = pts.executeQuery();

            int id = 0;

            while (rs.next()) {
                id = rs.getInt("id");
            }

            // Segunda inserção
            pts = con.prepareStatement("INSERT INTO silo VALUES(?,?);");
            pts.setInt(1, id);
            pts.setDouble(2, silo.getDiametro());
            pts.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna um silo com base no seu ID.
     * 
     * @param id O ID do silo a ser buscado.
     * @return O objeto Silo encontrado ou null se não for encontrado.
     */
    public Silo readById(int id) {
        try {
            Connection con = ConnectionFactory.createConnectionToMySQL();
            
            PreparedStatement pts = con.prepareStatement("SELECT armazenamento.capMax,armazenamento.quantArmaz, armazenamento.altura, silo.diametro "
                    + "FROM armazenamento INNER JOIN silo ON armazenamento.id = silo.id WHERE armazenamento.id = ?;");
            pts.setInt(1, id);
            ResultSet rs = pts.executeQuery();
            
            Silo s = null;
            
            while (rs.next()) {
                double capMax = rs.getDouble("capMax");
                double quantArmaz = rs.getDouble("quantArmaz");
                double altura = rs.getDouble("altura");
                double diametro = rs.getDouble("diametro");
                
                s = new Silo(capMax, quantArmaz, null, altura, diametro);
            }
            
            return s;
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
            return null;
        }
    }

    /**
     * Retorna uma lista de todos os silos no banco de dados.
     * 
     * @return Uma lista de objetos Silo encontrados.
     */
    public ArrayList<Silo> readAll() {
        try {
            Connection con = ConnectionFactory.createConnectionToMySQL();
            
            PreparedStatement pts = con.prepareStatement("SELECT armazenamento.capMax, armazenamento.quantArmaz, armazenamento.altura, "
                    + "silo.diametro FROM armazenamento INNER JOIN silo ON armazenamento.id = silo.id;");
            
            ResultSet rs = pts.executeQuery();
            ArrayList<Silo> ars = new ArrayList<>();
            
            while (rs.next()) {
                Silo s = null;
                double capMax = rs.getDouble("capMax");
                double quantArmaz = rs.getDouble("quantArmaz");
                double altura = rs.getDouble("altura");
                double diametro = rs.getDouble("diametro");
                s = new Silo(capMax, quantArmaz, s, altura, diametro);
                ars.add(s);
            }
            
            return ars;
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
            return null;
        }
    }

    /**
     * Atualiza um silo no banco de dados.
     * 
     * @param silo O objeto Silo com as informações atualizadas.
     * @param id O ID do silo a ser atualizado.
     * @param idGrao O ID do grão associado ao silo (opcional).
     */
    public void update(Silo silo, int id, int idGrao) {
        if (idGrao != 0) {
            try {
                Connection con = ConnectionFactory.createConnectionToMySQL();
                
                // Update armazenamento
                PreparedStatement pts = con.prepareStatement("UPDATE armazenamento SET capMax = ?, quantArmaz = ?, altura = ?, grao = ? WHERE id = ?;");
                pts.setInt(5, id);
                pts.setDouble(1, silo.getCapMax());
                pts.setDouble(2, silo.getCapArmazenada());
                pts.setDouble(3, silo.getAltura());
                pts.setInt(4, idGrao);
                pts.executeUpdate();

                // Update silo
                pts = con.prepareStatement("UPDATE silo SET diametro = ? WHERE id = ?;");
                pts.setInt(3, id);
                pts.setDouble(1, silo.getDiametro());
                pts.executeUpdate();

            } catch (Exception e) {
                System.out.println("Erro " + e.getMessage());
            }
        } else {
            try {
                Connection con = ConnectionFactory.createConnectionToMySQL();
                
                // Update armazenamento
                PreparedStatement pts = con.prepareStatement("UPDATE armazenamento SET capMax = ?, quantArmaz = ?, altura = ? WHERE id = ?;");
                pts.setInt(4, id);
                pts.setDouble(1, silo.getCapMax());
                pts.setDouble(2, silo.getCapArmazenada());
                pts.setDouble(3, silo.getAltura());
                pts.executeUpdate();

                // Update silo
                pts = con.prepareStatement("UPDATE silo SET diametro = ? WHERE id = ?;");
                pts.setInt(2, id);
                pts.setDouble(1, silo.getDiametro());
                pts.executeUpdate();

            } catch (Exception e) {
                System.out.println("Erro " + e.getMessage());
            }
        }
    }

    /**
     * Exclui um silo do banco de dados.
     * 
     * @param id O ID do silo a ser excluído.
     */
    public void delete(int id) {
        try {
            Connection con = ConnectionFactory.createConnectionToMySQL();
            
            // Deleta silo
            PreparedStatement pts = con.prepareStatement("DELETE FROM silo WHERE id=?");
            pts.setInt(1, id);
            pts.executeUpdate();

            // Deleta armazenamento
            pts = con.prepareStatement("DELETE FROM armazenamento WHERE id = ?");
            pts.setInt(1, id);
            pts.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }
}
