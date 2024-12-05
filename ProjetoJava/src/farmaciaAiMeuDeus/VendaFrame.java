package farmaciaAiMeuDeus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendaFrame extends JFrame {

    private JTextField clienteField;
    private JTextField medicamentoField;
    private JTextField quantidadeField;
    private JTextField precoUnitarioField;
    private JTextField totalField;
    private JButton finalizarButton;
    private JButton voltarButton;

    public VendaFrame() {
        // Configurações da tela de venda
        setTitle("Realizar Venda");
        setSize(400, 450);
        setLocationRelativeTo(null); // Tela no centro da tela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas a janela de venda
        setLayout(new GridBagLayout()); // Layout para um controle preciso

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margens maiores entre os componentes
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza os componentes

        // Fontes
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 15);

        // Criando os rótulos e campos de entrada com bordas
        JLabel clienteLabel = new JLabel("Cliente:");
        clienteLabel.setFont(labelFont);
        clienteField = new JTextField(20);
        clienteField.setFont(fieldFont);
        clienteField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JLabel medicamentoLabel = new JLabel("Medicamento:");
        medicamentoLabel.setFont(labelFont);
        medicamentoField = new JTextField(20);
        medicamentoField.setFont(fieldFont);
        medicamentoField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JLabel quantidadeLabel = new JLabel("Quantidade:");
        quantidadeLabel.setFont(labelFont);
        quantidadeField = new JTextField(20);
        quantidadeField.setFont(fieldFont);
        quantidadeField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JLabel precoUnitarioLabel = new JLabel("Preço Unitário:");
        precoUnitarioLabel.setFont(labelFont);
        precoUnitarioField = new JTextField(20);
        precoUnitarioField.setFont(fieldFont);
        precoUnitarioField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JLabel totalLabel = new JLabel("Total:");
        totalLabel.setFont(labelFont);
        totalField = new JTextField(20);
        totalField.setFont(fieldFont);
        totalField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        totalField.setEditable(false); // Campo de total é somente leitura

        // Configurando o botão "Finalizar"
        finalizarButton = new JButton("Finalizar");
        finalizarButton.setFont(buttonFont);
        finalizarButton.setBackground(new Color(190, 190, 190)); // Cor cinza padrão
        finalizarButton.setForeground(Color.BLACK); // Cor do texto preta
        finalizarButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borda do botão
        finalizarButton.setFocusPainted(false); // Remove a borda de foco
        finalizarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cursor de mão ao passar o mouse
        finalizarButton.setPreferredSize(new Dimension(130, 35)); // Tamanho do botão

        // Configurando o botão "Voltar"
        voltarButton = new JButton("Voltar");
        voltarButton.setFont(buttonFont);
        voltarButton.setBackground(new Color(190, 190, 190)); // Cor cinza padrão
        voltarButton.setForeground(Color.BLACK); // Cor do texto preta
        voltarButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borda do botão
        voltarButton.setFocusPainted(false); // Remove a borda de foco
        voltarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cursor de mão ao passar o mouse
        voltarButton.setPreferredSize(new Dimension(100, 35)); // Tamanho do botão

        // Adicionando ação ao botão "Finalizar"
        finalizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cliente = clienteField.getText();
                String medicamento = medicamentoField.getText();
                String quantidade = quantidadeField.getText();
                String precoUnitario = precoUnitarioField.getText();

                // Verificação simples de campos não vazios
                if (cliente.isEmpty() || medicamento.isEmpty() || quantidade.isEmpty() || precoUnitario.isEmpty()) {
                    JOptionPane.showMessageDialog(VendaFrame.this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        int quant = Integer.parseInt(quantidade);
                        double preco = Double.parseDouble(precoUnitario);
                        double total = quant * preco;
                        totalField.setText(String.format("%.2f", total));

                        // Simulação de confirmação de venda
                        JOptionPane.showMessageDialog(VendaFrame.this, "Venda realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                        // Limpar campos após a venda
                        clienteField.setText("");
                        medicamentoField.setText("");
                        quantidadeField.setText("");
                        precoUnitarioField.setText("");
                        totalField.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(VendaFrame.this, "Por favor, insira valores válidos para quantidade e preço.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Adicionando ação ao botão "Voltar"
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fecha a janela atual e volta para o menu principal
                new MainMenuFrame().setVisible(true);
                dispose(); // Fecha a janela de venda
            }
        });

        // Configurando o layout dos componentes
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa 2 colunas
        add(clienteLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(clienteField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(medicamentoLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(medicamentoField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(quantidadeLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(quantidadeField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(precoUnitarioLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(precoUnitarioField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(totalLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(totalField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(finalizarButton, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(voltarButton, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VendaFrame().setVisible(true);
            }
        });
    }
}
