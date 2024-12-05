package farmaciaAiMeuDeus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPasswordFrame extends JFrame {

    private JTextField emailField;
    private JPasswordField newPasswordField;
    private JPasswordField confirmPasswordField;
    private JButton resetPasswordButton;

    public ForgotPasswordFrame() {
        // Configurações da tela de redefinição de senha
        setTitle("Esqueci a Senha - Farmácia Ai Meu Deus");
        setSize(350, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margens maiores entre os componentes
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza os componentes

        // Rótulos e campos de entrada com bordas e fontes
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        emailField = new JTextField(20);
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borda visível

        JLabel newPasswordLabel = new JLabel("Nova Senha:");
        newPasswordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        newPasswordField = new JPasswordField(20);
        newPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        newPasswordField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borda visível

        JLabel confirmPasswordLabel = new JLabel("Confirmar Senha:");
        confirmPasswordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        confirmPasswordField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borda visível

        // Configurando o botão "Redefinir Senha"
        resetPasswordButton = new JButton("Redefinir Senha");
        resetPasswordButton.setFont(new Font("Arial", Font.BOLD, 15));
        resetPasswordButton.setBackground(new Color(190, 190, 190)); // Cor cinza padrão
        resetPasswordButton.setForeground(Color.BLACK); // Cor do texto preta
        resetPasswordButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borda do botão
        resetPasswordButton.setFocusPainted(false); // Remove a borda de foco
        resetPasswordButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cursor de mão
        resetPasswordButton.setPreferredSize(new Dimension(140, 30)); // Tamanho do botão

        // Adicionando ação ao botão de redefinição de senha
        resetPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String newPassword = new String(newPasswordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (email.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(ForgotPasswordFrame.this, "Por favor, preencha todos os campos", "Erro", JOptionPane.WARNING_MESSAGE);
                } else if (!newPassword.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(ForgotPasswordFrame.this, "As senhas não coincidem", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Simulação de redefinição de senha bem-sucedida
                    JOptionPane.showMessageDialog(ForgotPasswordFrame.this, "Senha redefinida com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // Fecha a janela de recuperação de senha
                }
            }
        });

        // Configurando o layout dos componentes
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa 2 colunas
        add(emailLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(emailField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(newPasswordLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(newPasswordField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(confirmPasswordLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(confirmPasswordField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(resetPasswordButton, gbc);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ForgotPasswordFrame().setVisible(true);
            }
        });
    }
}
