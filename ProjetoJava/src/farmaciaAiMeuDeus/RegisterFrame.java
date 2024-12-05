package farmaciaAiMeuDeus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {

    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton registerButton;
    private JButton backButton;

    public RegisterFrame() {
        // Configurações da tela de cadastro
        setTitle("Cadastro - Farmácia Ai Meu Deus");
        setSize(350, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margens maiores entre os componentes
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza os componentes

        // Rótulos e campos de entrada com bordas e fontes
        JLabel nameLabel = new JLabel("Nome:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameField = new JTextField(20);
        nameField.setFont(new Font("Arial", Font.PLAIN, 14));
        nameField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JLabel emailLabel = new JLabel("Usuário:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        emailField = new JTextField(20);
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JLabel confirmPasswordLabel = new JLabel("Confirmar Senha:");
        confirmPasswordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        confirmPasswordField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        // Botão "Cadastrar"
        registerButton = new JButton("Cadastrar");
        registerButton.setFont(new Font("Arial", Font.BOLD, 15));
        registerButton.setBackground(new Color(190, 190, 190)); // Cor cinza padrão
        registerButton.setForeground(Color.BLACK); // Cor do texto preta
        registerButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borda do botão
        registerButton.setFocusPainted(false); // Remove a borda de foco
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cursor de mão
        registerButton.setPreferredSize(new Dimension(120, 30)); // Tamanho do botão

        // Botão "Voltar" menor
        backButton = new JButton("Voltar");
        backButton.setFont(new Font("Arial", Font.BOLD, 12));
        backButton.setBackground(new Color(190, 190, 190)); // Cor cinza padrão
        backButton.setForeground(Color.BLACK); // Cor do texto preta
        backButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borda do botão
        backButton.setFocusPainted(false); // Remove a borda de foco
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cursor de mão
        backButton.setPreferredSize(new Dimension(100, 25)); // Tamanho menor do botão

        // Adicionando ação ao botão "Cadastrar"
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "Por favor, preencha todos os campos", "Erro", JOptionPane.WARNING_MESSAGE);
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "As senhas não coincidem", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Simulação de cadastro bem-sucedido
                    JOptionPane.showMessageDialog(RegisterFrame.this, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // Fecha a janela de cadastro
                }
            }
        });

        // Adicionando ação ao botão "Voltar"
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela de cadastro
                new LoginFrame().setVisible(true); // Abre a tela de login
            }
        });

        // Configurando o layout dos componentes
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa 2 colunas
        add(nameLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(nameField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(emailLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(emailField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(passwordLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(passwordField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(confirmPasswordLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(confirmPasswordField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(registerButton, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(backButton, gbc);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RegisterFrame().setVisible(true);
            }
        });
    }
}
