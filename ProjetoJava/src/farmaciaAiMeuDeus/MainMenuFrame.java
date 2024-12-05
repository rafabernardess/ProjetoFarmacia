package farmaciaAiMeuDeus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuFrame extends JFrame {

    public MainMenuFrame() {
        // Configurações da tela do menu principal
        setTitle("Menu Principal - Farmácia");
        setSize(400, 300);
        setLocationRelativeTo(null); // Tela no centro da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout
        setLayout(new FlowLayout());

        // Criando os menus
        JMenuBar menuBar = new JMenuBar();
        JMenu cadastroMenu = new JMenu("Cadastro");
        JMenuItem cadastroMedicamento = new JMenuItem("Cadastrar Medicamento");
        cadastroMedicamento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CadastroMedicamentoFrame().setVisible(true);
            }
        });
        cadastroMenu.add(cadastroMedicamento);

        JMenu vendasMenu = new JMenu("Vendas");
        JMenuItem realizarVenda = new JMenuItem("Realizar Venda");
        realizarVenda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cria e exibe a tela de vendas
                new VendaFrame().setVisible(true);
            }
        });
        vendasMenu.add(realizarVenda);

        JMenu estoqueMenu = new JMenu("Estoque");
        JMenuItem controleEstoque = new JMenuItem("Controle de Estoque");
        controleEstoque.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cria e exibe a tela de controle de estoque
                new EstoqueFrame().setVisible(true);
            }
        });
        estoqueMenu.add(controleEstoque);

        JMenu relatoriosMenu = new JMenu("Relatórios");
        JMenuItem relatorioVendas = new JMenuItem("Relatório de Vendas");
        relatorioVendas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cria e exibe a tela de relatórios
                new RelatorioFrame().setVisible(true);
            }
        });
        relatoriosMenu.add(relatorioVendas);

        // Adicionando os menus à barra de menu
        menuBar.add(cadastroMenu);
        menuBar.add(vendasMenu);
        menuBar.add(estoqueMenu);
        menuBar.add(relatoriosMenu);

        // Configurando a barra de menu
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainMenuFrame().setVisible(true);
            }
        });
    }
}
