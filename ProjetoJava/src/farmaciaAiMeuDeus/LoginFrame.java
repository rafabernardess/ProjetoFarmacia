package farmaciaAiMeuDeus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {

    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame() {
        // Configurações da tela de login
        setTitle("Login Farmácia Ai Meu Deus");
        setSize(350, 400);
        setLocationRelativeTo(null); // Tela no centro da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout()); // Layout para um controle preciso

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margens maiores entre os componentes
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza os componentes

        // Rótulos e campos de entrada com bordas
        JLabel userLabel = new JLabel("Usuário:");
        userLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userField = new JTextField(25);
        userField.setFont(new Font("Arial", Font.PLAIN, 14));
        userField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordField = new JPasswordField(25);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        // Configurando o botão "Entrar"
        loginButton = new JButton("Entrar");
        loginButton.setFont(new Font("Arial", Font.BOLD, 15));
        loginButton.setBackground(new Color(190, 190, 190)); // Cor cinza padrão
        loginButton.setForeground(Color.BLACK); // Cor do texto preta
        loginButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borda para aparência de botão
        loginButton.setFocusPainted(false); // Remove a borda de foco
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cursor de mão ao passar o mouse
        loginButton.setPreferredSize(new Dimension(110, 30)); // Tamanho do botão

        // Adicionando ação ao botão de login
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = userField.getText();
                String senha = new String(passwordField.getPassword());

                // Validação simples de login
                if (usuario.equals("admin") && senha.equals("1234")) {
                    // Se o login for correto, abre o menu principal e fecha o login
                    new MainMenuFrame().setVisible(true);
                    dispose(); // Fecha a tela de login
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Usuário ou senha inválidos", "Erro de login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Configurando o layout dos componentes
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa 2 colunas
        add(userLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(userField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(passwordLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(passwordField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(loginButton, gbc);

        // Criando um painel para os links "Cadastre-se" e "Esqueci a senha"
        JPanel linksPanel = new JPanel();
        linksPanel.setBackground(new Color(240, 240, 240)); // Cor de fundo para o painel
        linksPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5)); // Layout com espaçamento

        JLabel registerLabel = new JLabel("<html><a href='#'>Cadastre-se</a></html>");
        JLabel forgotPasswordLabel = new JLabel("<html><a href='#'>Esqueci a senha</a></html>");

        // Configurando a aparência dos links
        registerLabel.setForeground(Color.BLUE);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new RegisterFrame().setVisible(true); // Abre a tela de cadastro
            }
        });

        forgotPasswordLabel.setForeground(Color.BLUE);
        forgotPasswordLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        forgotPasswordLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new ForgotPasswordFrame().setVisible(true); // Abre a tela de recuperação de senha
            }
        });

        // Adicionando os links ao painel
        linksPanel.add(registerLabel);
        linksPanel.add(forgotPasswordLabel);

        // Adicionando o painel de links à tela
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(linksPanel, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
