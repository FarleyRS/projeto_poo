package view;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import controller.GalpaoController;
import dao.GalpaoDao;
import model.Galpao;

public class GerenciaPanel extends JPanel {

    private JButton btnGerenciarGalpao = new JButton("Gerenciar Galpões");
    private JButton btnGerenciarSilos = new JButton("Gerenciar Silos");
    private JPanel containerPanel = new JPanel();

    /**
     * Cria o painel.
     */
    public GerenciaPanel() {
        initComponents();
        containerPanel.setLayout(new GridLayout(1, 0));
        // Obtém a lista de galpões do banco de dados
        GalpaoDao galpaoDao = new GalpaoDao();
        ArrayList<Galpao> galpoes = galpaoDao.readAll();
        for (Galpao galpao : galpoes) {
            JProgressBar progressBar = new JProgressBar();
            progressBar.setStringPainted(true);
            progressBar.setOrientation(SwingConstants.VERTICAL);
            // Calcula a porcentagem de uso do galpão
            int porcentagemUso = (int) ((galpao.getCapArmazenada() * 100) /galpao.getCapMax());
            progressBar.setValue(porcentagemUso);
            containerPanel.add(progressBar);
        }
    }

    private void initComponents() {
        setBackground(new Color(128, 128, 128));

        GroupLayout groupLayout = new GroupLayout(this);
        setLayout(groupLayout);

        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addContainerGap()
                        .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                .addComponent(btnGerenciarSilos, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(btnGerenciarGalpao, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(18)
                        .addComponent(containerPanel, GroupLayout.PREFERRED_SIZE, 625, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addContainerGap()
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(containerPanel, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(btnGerenciarGalpao, GroupLayout.PREFERRED_SIZE, 51,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGap(18).addComponent(btnGerenciarSilos, GroupLayout.PREFERRED_SIZE, 50,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGap(246)))
                        .addContainerGap()));
    }

    /**
     * Retorna o botão "Gerenciar Galpões".
     *
     * @return O botão "Gerenciar Galpões".
     */
    public JButton getBtnGerenciarGalpao() {
        return btnGerenciarGalpao;
    }

    /**
     * Retorna o botão "Gerenciar Silos".
     *
     * @return O botão "Gerenciar Silos".
     */
    public JButton getBtnGerenciarSilos() {
        return btnGerenciarSilos;
    }

    /**
     * Retorna o painel de contêiner.
     *
     * @return O painel de contêiner.
     */
    public JPanel getContainerPanel() {
        return containerPanel;
    }

}
