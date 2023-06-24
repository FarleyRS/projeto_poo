package controller;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.GalpaoDao;
import dao.GraoDao;
import factory.ConnectionFactory;
import model.Galpao;
import model.Grao;
import view.galpao.AddGalpaoPanel;
import view.galpao.AddGraoGalpaoPanel;
import view.galpao.GerenciaGalpaoView;

/**
 * Controlador para gerenciar operações de galpão.
 */
public class GalpaoController {

    private GalpaoDao gd = new GalpaoDao();
    private GerenciaGalpaoView g;
    private AddGalpaoPanel ag;
    private AddGraoGalpaoPanel agg;
    private int idGalpao = 0;
    private Galpao galpao;

    /**
     * Construtor para inicializar o controlador com a visão de gerenciamento de galpão.
     *
     * @param g A visão de gerenciamento de galpão.
     */
    public GalpaoController(GerenciaGalpaoView g) {
        this.g = g;
        this.ag = new AddGalpaoPanel();
        this.agg = new AddGraoGalpaoPanel();

        g.getContainerPanel().add("add", ag);
        g.getContainerPanel().add("addGrao", agg);

        initControleGalpao();
    }

    /**
     * Adiciona um novo galpão com as dimensões especificadas.
     *
     * @param altura A altura do galpão.
     * @param largura A largura do galpão.
     * @param comprimento O comprimento do galpão.
     */
    public void addGalpao(double altura, double largura, double comprimento) {
        Galpao g = new Galpao(altura, largura, comprimento);
        if (gd.create(g)) {
            JOptionPane.showMessageDialog(null, "Adicionado com Sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Falha!");
        }
    }

    /**
     * Inicializa o controle do galpão adicionando ouvintes de eventos aos botões da interface do usuário.
     */
    public void initControleGalpao() {
        g.getBtnNewGalpao().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                CardLayout cl = (CardLayout) (g.getContainerPanel().getLayout());
                cl.show(g.getContainerPanel(), "add");
            }
        });

        ag.getBtnNewGalpao().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                double altura = Double.parseDouble(ag.getTfAltura().getText());
                double largura = Double.parseDouble(ag.getTfLargura().getText());
                double comprimento = Double.parseDouble(ag.getTfComprimento().getText());

                addGalpao(altura, largura, comprimento);

                ag.getTfAltura().setText("");
                ag.getTfComprimento().setText("");
                ag.getTfLargura().setText("");
            }
        });

        g.getBtnAddGraos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                CardLayout cl = (CardLayout) (g.getContainerPanel().getLayout());
                g.getContainerPanel().add("addGrao", agg);
                cl.show(g.getContainerPanel(), "addGrao");
                preencheListaGalpaos();
            }
        });
        
        agg.getListGalpao().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Galpao selectedGalpao = (Galpao) agg.getListGalpao().getSelectedValue();
                    if (selectedGalpao != null) {
                        agg.getTfGalpao().setText(String.valueOf(selectedGalpao.getId()));
                        galpao = selectedGalpao;
                    }
                }
            }
        });
        
        agg.getBtnAddGrao().addActionListener(e -> criarGrao(galpao));
    }

    /**
     * Preenche a lista de galpoes na interface do usuário com os galpoes existentes no banco de dados.
     */
    public void preencheListaGalpaos() {
        GalpaoDao galpaoDao = new GalpaoDao();
        List<Galpao> galpoes = galpaoDao.readAll();

        DefaultListModel<Galpao> model = new DefaultListModel<>();
        for (Galpao galpao : galpoes) {
            model.addElement(galpao);
        }

        agg.getListGalpao().setModel(model);
    }

    /**
     * Cria um novo grão e o adiciona ao galpão especificado.
     *
     * @param galpao O galpão ao qual o grão será adicionado.
     */
    public void criarGrao(Galpao galpao) {
    	
        String nome = agg.getTfNomeGrao().getText();
        String tipo = agg.getTfTipoGrao().getText();
        boolean impureza = agg.getCkbxImpureza().isSelected();
        double nivelImpureza = Double.parseDouble(agg.getTfImpureza().getText());
        String dataColeta = agg.getTfDatacoleta().getText();
        double massa = Double.parseDouble(agg.getTfMassa().getText());

        Grao grao = new Grao(nome, tipo, impureza, massa, nivelImpureza, dataColeta);
        GraoDao graoDao = new GraoDao();
        graoDao.create(grao);

        try (Connection con = ConnectionFactory.createConnectionToMySQL()) {
            PreparedStatement pts = con.prepareStatement("SELECT id FROM grao ORDER BY id DESC LIMIT 1;");
            ResultSet rs = pts.executeQuery();

            int id = 0;
            if (rs.next()) {
                id = rs.getInt("id");
            }
            galpao.setGraoArmazenado(grao);
            galpao.setCapArmazenada(Double.parseDouble(agg.getTfQuantidade().getText()));
            GalpaoDao galpaoDao = new GalpaoDao();
            galpaoDao.update(galpao, idGalpao, id);
            
            
            agg.getTfNomeGrao().setText("");
            agg.getTfTipoGrao().setText("");
            agg.getCkbxImpureza().setSelected(false);
            agg.getTfImpureza().setText("");
            agg.getTfDatacoleta().setText("");
            agg.getTfMassa().setText("");
            agg.getTfGalpao().setText("");
            
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
}
