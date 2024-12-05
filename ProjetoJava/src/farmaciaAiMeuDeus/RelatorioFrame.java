package farmaciaAiMeuDeus;

import javax.swing.*;
import java.awt.*;

public class RelatorioFrame extends JFrame {

    public RelatorioFrame() {
        // Configurações da tela de relatórios
        setTitle("Relatório de Vendas");
        setSize(600, 400);
        setLocationRelativeTo(null); // Centraliza a tela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha a janela apenas
        setLayout(new BorderLayout()); // Layout principal com BorderLayout

        // Criação de um painel de informações
        JPanel reportPanel = new JPanel();
        reportPanel.setLayout(new BoxLayout(reportPanel, BoxLayout.Y_AXIS));
        reportPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Título do relatório
        JLabel titleLabel = new JLabel("Relatório de Vendas");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Texto de descrição
        JLabel descriptionLabel = new JLabel("Aqui você pode visualizar as informações detalhadas sobre as vendas realizadas.");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adicionando componentes ao painel
        reportPanel.add(titleLabel);
        reportPanel.add(Box.createVerticalStrut(10));
        reportPanel.add(descriptionLabel);
        reportPanel.add(Box.createVerticalStrut(20));

        // Área de texto para exibir o relatório (simulação)
        JTextArea reportArea = new JTextArea(10, 50);
        reportArea.setFont(new Font("Arial", Font.PLAIN, 14));
        reportArea.setText( "O resumo das vendas realizadas será mostrado neste campo.\n");
        reportArea.setWrapStyleWord(true);
        reportArea.setLineWrap(true);
        reportArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportArea);

        // Adicionando a área de texto ao painel
        reportPanel.add(scrollPane);

        // Adicionando o painel ao JFrame
        add(reportPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RelatorioFrame().setVisible(true);
            }
        });
    }
}
