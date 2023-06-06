package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import control.Controlador;
import modelo.Casilla;
import modelo.Tablero;

public class Interfaz extends JFrame {

    private Tablero tablero;
    private JButton[][] botones;
    private JLabel labelTiempo;
    private JLabel labelMinasRestantes;
    private JPanel panelTablero;
    private JPanel panelInformacion;

    public Interfaz(int filas, int columnas, int minas) {
        tablero = Tablero.getInstancia(filas, columnas, minas);
        tablero.setInterfaz(this);

        setTitle("Buscaminas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inicializarTablero();
        inicializarInformacion();

        add(panelTablero, BorderLayout.CENTER);
        add(panelInformacion, BorderLayout.NORTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(false);

        tablero.iniciarTiempo();
    }

    private void inicializarTablero() {
        panelTablero = new JPanel();
        panelTablero.setLayout(new GridLayout(tablero.getFilas(), tablero.getColumnas()));
        panelTablero.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        botones = new JButton[tablero.getFilas()][tablero.getColumnas()];

        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                botones[i][j] = new JButton();
                botones[i][j].setPreferredSize(new Dimension(30, 30));
                botones[i][j].setFont(new Font("Arial", Font.BOLD, 12));
                botones[i][j].setFocusable(false);
                botones[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton boton = (JButton) e.getSource();
                        int fila = -1;
                        int columna = -1;
                        boolean encontrado = false;
                        for (int i = 0; i < tablero.getFilas(); i++) {
                            for (int j = 0; j < tablero.getColumnas(); j++) {
                                if (botones[i][j] == boton) {
                                    fila = i;
                                    columna = j;
                                    encontrado = true;
                                    break;
                                }
                            }
                            if (encontrado) {
                                break;
                            }
                        }
                        if (fila != -1 && columna != -1) {
                            Controlador.abrirCasilla(fila, columna);
                        }
                    }
                });
                panelTablero.add(botones[i][j]);
            }
        }
    }

    private void inicializarInformacion() {
        panelInformacion = new JPanel();
        panelInformacion.setLayout(new FlowLayout());
        panelInformacion.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        labelTiempo = new JLabel("Tiempo: 0");
        labelTiempo.setFont(new Font("Arial", Font.BOLD, 16));
        panelInformacion.add(labelTiempo);

        labelMinasRestantes = new JLabel("Minas restantes: " + tablero.getMinas());
        labelMinasRestantes.setFont(new Font("Arial", Font.BOLD, 16));
        panelInformacion.add(labelMinasRestantes);
    }

    public void actualizarCasilla(int fila, int columna) {
        Casilla casilla = tablero.getCasilla(fila, columna);
        JButton boton = botones[fila][columna];
        boton.setEnabled(false);
        boton.setBackground(Color.LIGHT_GRAY);

        if (casilla.isMina()) {
            boton.setText("*");
            boton.setBackground(Color.RED);
        } else {
            int valor = casilla.getValor();
            if (valor > 0) {
                boton.setText(String.valueOf(valor));
            }
        }
    }

    public void actualizarTiempo(int tiempo) {
        labelTiempo.setText("Tiempo: " + tiempo);
    }

    public void actualizarMinasRestantes(int minasRestantes) {
        labelMinasRestantes.setText("Minas restantes: " + minasRestantes);
    }

    public void mostrar() {
        setVisible(true);
    }

    public void mostrarMenu() {
        String[] opciones = { "Fácil", "Medio", "Difícil", "Personalizado", "Salir" };
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Buscaminas", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == 0) {
            Controlador.iniciarJuego(8, 8, 10);
        } else if (seleccion == 1) {
            Controlador.iniciarJuego(12, 12, 20);
        } else if (seleccion == 2) {
            Controlador.iniciarJuego(16, 16, 40);
        } else if (seleccion == 3) {
            String filasStr = JOptionPane.showInputDialog(null, "Ingrese el número de filas:", "Personalizado", JOptionPane.PLAIN_MESSAGE);
            String columnasStr = JOptionPane.showInputDialog(null, "Ingrese el número de columnas:", "Personalizado", JOptionPane.PLAIN_MESSAGE);
            String minasStr = JOptionPane.showInputDialog(null, "Ingrese el número de minas:", "Personalizado", JOptionPane.PLAIN_MESSAGE);

            int filas = Integer.parseInt(filasStr);
            int columnas = Integer.parseInt(columnasStr);
            int minas = Integer.parseInt(minasStr);

            Controlador.iniciarJuego(filas, columnas, minas);
        } else if (seleccion == 4) {
            System.exit(0);
        }
    }
}
