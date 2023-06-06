package control;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MenuPrincipal {

    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 400;

    private static final String FRAME_TITLE = "Menú Principal";
    private static final String BUSCAMINAS_BUTTON_TEXT = "Iniciar Buscaminas";
    private static final String SNAKE_BUTTON_TEXT = "Iniciar Snake";
    private static final String CLASIFICACION_BUTTON_TEXT = "Clasificación";
    private static final String MENU_LABEL_TEXT = "Elige un juego";

    private JFrame frame;
    private JPanel panel;
    private JButton buscaminasButton;
    private JButton snakeButton;
    private JButton clasificacionButton;

    public MenuPrincipal() {
        createFrame();
        createPanel();
        createButtons();
        addComponents();
    }

    private void createFrame() {
        frame = new JFrame(FRAME_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(18, 32, 53));
    }

    private void createPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(18, 32, 53));
        frame.add(panel);
    }

    private void createButtons() {
        buscaminasButton = new JButton(BUSCAMINAS_BUTTON_TEXT);
        buscaminasButton.setPreferredSize(new Dimension(350, 50));
        buscaminasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para iniciar el juego de Buscaminas
            }
        });
        buscaminasButton.setBackground(new Color(74, 137, 220));
        buscaminasButton.setForeground(Color.WHITE);
        buscaminasButton.setFont(new Font("Arial", Font.BOLD, (int) (0.04 * FRAME_WIDTH)));

        snakeButton = new JButton(SNAKE_BUTTON_TEXT);
        snakeButton.setPreferredSize(new Dimension(350, 50));
        snakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para iniciar el juego de Snake
            }
        });
        snakeButton.setBackground(new Color(74, 137, 220));
        snakeButton.setForeground(Color.WHITE);
        snakeButton.setFont(new Font("Arial", Font.BOLD, (int) (0.04 * FRAME_WIDTH)));

        clasificacionButton = new JButton(CLASIFICACION_BUTTON_TEXT);
        clasificacionButton.setPreferredSize(new Dimension(350, 50));
        clasificacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para mostrar la clasificación
            }
        });
        clasificacionButton.setBackground(new Color(74, 137, 220));
        clasificacionButton.setForeground(Color.WHITE);
        clasificacionButton.setFont(new Font("Arial", Font.BOLD, (int) (0.04 * FRAME_WIDTH)));

        // Calcular coordenadas x centradas
        int centerX = (FRAME_WIDTH - buscaminasButton.getPreferredSize().width) / 2;

        // Establecer coordenadas x centradas para los botones
        buscaminasButton.setBounds(centerX, 130, buscaminasButton.getPreferredSize().width, buscaminasButton.getPreferredSize().height);
        snakeButton.setBounds(centerX, 200, snakeButton.getPreferredSize().width, snakeButton.getPreferredSize().height);
        clasificacionButton.setBounds(centerX, 270, clasificacionButton.getPreferredSize().width, clasificacionButton.getPreferredSize().height);
    }

    private void addComponents() {
        JLabel menuLabel = new JLabel(MENU_LABEL_TEXT);
        menuLabel.setBounds(0, 50, FRAME_WIDTH, 50);
        menuLabel.setBackground(new Color(18, 32, 53));
        menuLabel.setForeground(Color.WHITE);
        menuLabel.setFont(new Font("Arial", Font.BOLD, (int) (0.06 * FRAME_WIDTH)));
        menuLabel.setHorizontalAlignment(JLabel.CENTER); // Alineación centrada del texto
        panel.add(menuLabel);

        panel.add(buscaminasButton);
        panel.add(snakeButton);
        panel.add(clasificacionButton);
    }

    public void show() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.show();
    }
}

