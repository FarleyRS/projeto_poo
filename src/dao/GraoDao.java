package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import factory.ConnectionFactory;
import model.Galpao;
import model.Grao;
/**
 * Esta classe é responsável por realizar operações de acesso a dados relacionadas ao objeto Grao.
 */
public class GraoDao {

    /**
     * Cria um novo grão no banco de dados.
     * 
     * @param grao O objeto Grao a ser criado.
     */
    public void create(Grao grao) {

        try {
            Connection con = ConnectionFactory.createConnectionToMySQL();
            
            // Executa primeira inserção
            PreparedStatement pts = con.prepareStatement("INSERT INTO grao(nome) VALUES(?);");
            pts.setString(1, grao.getNome());
            pts.executeUpdate();

            // Executa consulta
            pts = con.prepareStatement("SELECT id FROM grao ORDER BY id ASC; ");
            ResultSet rs = pts.executeQuery();

            int id = 0;

            while (rs.next()) {
                id = rs.getInt("id");
            }

            // Segunda inserção
            pts = con.prepareStatement("INSERT INTO tipograo VALUES(?,?,?,?,?,?);");
            pts.setInt(1, id);
            pts.setString(2, grao.getTipo());
            pts.setBoolean(3, grao.isImpureza());
            pts.setDouble(4, grao.getNivel_impureza());
            pts.setString(5, grao.getData_coleta());
            pts.setDouble(6, grao.getMassa());

            pts.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Retorna um grão com base no seu ID.
     * 
     * @param id O ID do grão a ser buscado.
     * @return O objeto Grao encontrado ou null se não for encontrado.
     */
    public Grao readById(int id) {
        try {
            Connection con = ConnectionFactory.createConnectionToMySQL();
            
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
    
    /**
     * Retorna uma lista de todos os grãos no banco de dados.
     * 
     * @return Uma lista de objetos Grao encontrados.
     */
    public ArrayList<Grao> readAll() {
        try {
            Connection con = ConnectionFactory.createConnectionToMySQL();
            
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

    /**
     * Atualiza um grão no banco de dados.
     * 
     * @param grao O objeto Grao com as informações atualizadas.
     * @param id O ID do grão a ser atualizado.
     */
    public void update(Grao grao, int id) {
        try {
            Connection con = ConnectionFactory.createConnectionToMySQL();
            
            PreparedStatement pts = con.prepareStatement("UPDATE grao SET nome = ? WHERE id = ?;");
            pts.setString(1, grao.getNome());
            pts.setInt(2, id);
            pts.executeUpdate();

            // Segunda inserção
            pts = con.prepareStatement("UPDATE tipograo SET tipo = ?, impureza = ?, nivel_impur = ?, data_coleta = ?, densidade = ? WHERE id = ?;");
            pts.setInt(6, id);
            pts.setString(1, grao.getTipo());
            pts.setBoolean(2, grao.isImpureza());
            pts.setDouble(3, grao.getNivel_impureza());
            pts.setString(4, grao.getData_coleta());
            pts.setDouble(5, grao.getMassa());

            pts.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Exclui um grão do banco de dados.
     * 
     * @param id O ID do grão a ser excluído.
     */
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
            System.out.println("Erro " + e.getMessage());
        }
    }
}
