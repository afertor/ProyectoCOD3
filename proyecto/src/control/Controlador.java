package control;

import modelo.Tablero;
import vista.Interfaz;

public class Controlador {
    private static Tablero tablero;
    private static Interfaz interfaz;

    public static void iniciarJuego(int filas, int columnas, int minas) {
        tablero = Tablero.getInstancia(filas, columnas, minas);
        tablero.iniciarTiempo();
    }

    public static void setInterfaz(Interfaz interfaz) {
        Controlador.interfaz = interfaz;
        tablero.setInterfaz(interfaz);
    }

    public static void abrirCasilla(int fila, int columna) {
        tablero.abrirCasilla(fila, columna);
        if (tablero.estadoJuego()) {
            tablero.mostrarMensajeVictoria();
        }
    }

    public static void marcarCasilla(int fila, int columna) {
        tablero.marcarCasilla(fila, columna);
    }

    public static void desmarcarCasilla(int fila, int columna) {
        tablero.desmarcarCasilla(fila, columna);
    }

    public static void reiniciarJuego() {
        tablero.reiniciarJuego();
    }
}
