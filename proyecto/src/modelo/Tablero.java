package modelo;

import java.util.Random;
import javax.swing.JOptionPane;
import vista.Interfaz;

public class Tablero {
    private static Tablero instancia;
    private int filas;
    private int columnas;
    private int minas;
    private Casilla[][] casillas;
    private Interfaz interfaz;
    private boolean juegoTerminado;

    private Tablero(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        this.casillas = new Casilla[filas][columnas];
        this.juegoTerminado = false;

        inicializarCasillas();
        colocarMinas();
        calcularValores();
    }

    public static Tablero getInstancia(int filas, int columnas, int minas) {
        if (instancia == null) {
            instancia = new Tablero(filas, columnas, minas);
        }
        return instancia;
    }

    private void inicializarCasillas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla(this);
            }
        }
    }

    private void colocarMinas() {
        Random random = new Random();
        int minasRestantes = minas;

        while (minasRestantes > 0) {
            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);

            if (!casillas[fila][columna].isMina()) {
                casillas[fila][columna].setMina(true);
                minasRestantes--;
            }
        }
    }

    private void calcularValores() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!casillas[i][j].isMina()) {
                    int valor = contarMinasAdyacentes(i, j);
                    casillas[i][j].setValor(valor);
                }
            }
        }
    }

    private int contarMinasAdyacentes(int fila, int columna) {
        int contador = 0;
        int inicioFila = Math.max(0, fila - 1);
        int finFila = Math.min(filas - 1, fila + 1);
        int inicioColumna = Math.max(0, columna - 1);
        int finColumna = Math.min(columnas - 1, columna + 1);

        for (int i = inicioFila; i <= finFila; i++) {
            for (int j = inicioColumna; j <= finColumna; j++) {
                if (casillas[i][j].isMina()) {
                    contador++;
                }
            }
        }

        return contador;
    }

    public void abrirCasilla(int fila, int columna) {
        casillas[fila][columna].abrir();
    }

    public void marcarCasilla(int fila, int columna) {
        casillas[fila][columna].marcar();
    }

    public void desmarcarCasilla(int fila, int columna) {
        casillas[fila][columna].marcar();
    }

    public void reiniciarJuego() {
        instancia = null;
        juegoTerminado = false;
        interfaz.mostrarMenu();
    }

    public boolean estadoJuego() {
        return juegoTerminado;
    }

    public void mostrarMensajeVictoria() {
        juegoTerminado = true;
        JOptionPane.showMessageDialog(null, "¡Has ganado!", "Victoria", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMensajeDerrota() {
        juegoTerminado = true;
        JOptionPane.showMessageDialog(null, "¡Has perdido!", "Derrota", JOptionPane.ERROR_MESSAGE);
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getMinas() {
        return minas;
    }

    public Casilla getCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    public void setInterfaz(Interfaz interfaz) {
        this.interfaz = interfaz;
    }

    public void iniciarTiempo() {
        // Lógica para iniciar el tiempo
    }
}
