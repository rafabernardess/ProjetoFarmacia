package farmaciaAiMeuDeus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroMedicamentoFrame extends JFrame {

    private JTextField nomeField;
    private JTextField codigoField;
    private JTextField quantidadeField;
    private JTextField precoField;
    private JButton cadastrarButton;
    private JButton voltarButton;

    public CadastroMedicamentoFrame() {
        // Configurações da tela de cadastro de medicamento
        setTitle("Cadastro de Medicamento");
        setSize(400, 350);
        setLocationRelativeTo(null); // Tela no centro da tela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas a janela de cadastro
        setLayout(new GridBagLayout()); // Layout para um controle preciso

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margens maiores entre os componentes
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza os componentes

        // Fontes
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 15);

        // Criando os rótulos e campos de entrada com bordas
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(labelFont);
        nomeField = new JTextField(20);
        nomeField.setFont(fieldFont);
        nomeField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JLabel codigoLabel = new JLabel("Código:");
        codigoLabel.setFont(labelFont);
        codigoField = new JTextField(20);
        codigoField.setFont(fieldFont);
        codigoField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JLabel quantidadeLabel = new JLabel("Quantidade:");
        quantidadeLabel.setFont(labelFont);
        quantidadeField = new JTextField(20);
        quantidadeField.setFont(fieldFont);
        quantidadeField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JLabel precoLabel = new JLabel("Preço:");
        precoLabel.setFont(labelFont);
        precoField = new JTextField(20);
        precoField.setFont(fieldFont);
        precoField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        // Configurando o botão "Cadastrar"
        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setFont(buttonFont);
        cadastrarButton.setBackground(new Color(190, 190, 190)); // Cor cinza padrão
        cadastrarButton.setForeground(Color.BLACK); // Cor do texto preta
        cadastrarButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borda do botão
        cadastrarButton.setFocusPainted(false); // Remove a borda de foco
        cadastrarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cursor de mão ao passar o mouse
        cadastrarButton.setPreferredSize(new Dimension(130, 35)); // Tamanho do botão

        // Configurando o botão "Voltar"
        voltarButton = new JButton("Voltar");
        voltarButton.setFont(buttonFont);
        voltarButton.setBackground(new Color(190, 190, 190)); // Cor cinza padrão
        voltarButton.setForeground(Color.BLACK); // Cor do texto preta
        voltarButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borda do botão
        voltarButton.setFocusPainted(false); // Remove a borda de foco
        voltarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cursor de mão ao passar o mouse
        voltarButton.setPreferredSize(new Dimension(100, 35)); // Tamanho do botão

        // Adicionando ação ao botão "Cadastrar"
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String codigo = codigoField.getText();
                String quantidade = quantidadeField.getText();
                String preco = precoField.getText();

                // Verificação simples de campos não vazios
                if (nome.isEmpty() || codigo.isEmpty() || quantidade.isEmpty() || preco.isEmpty()) {
                    JOptionPane.showMessageDialog(CadastroMedicamentoFrame.this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Aqui você pode adicionar a lógica para armazenar os dados, como salvar em um banco de dados
                    JOptionPane.showMessageDialog(CadastroMedicamentoFrame.this, "Medicamento cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    // Limpar campos após o cadastro
                    nomeField.setText("");
                    codigoField.setText("");
                    quantidadeField.setText("");
                    precoField.setText("");
                }
            }
        });

        // Adicionando ação ao botão "Voltar"
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fecha a janela atual e volta para a tela de login
                new LoginFrame().setVisible(true);
                dispose(); // Fecha a janela de cadastro
            }
        });

        // Configurando o layout dos componentes
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa 2 colunas
        add(nomeLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(nomeField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(codigoLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(codigoField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(quantidadeLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(quantidadeField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(precoLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(precoField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(cadastrarButton, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(voltarButton, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CadastroMedicamentoFrame().setVisible(true);
            }
        });
    }
}
