package control;

import vista.Interfaz;

public class Proyecto_buscaminas {
    public static void main(String[] args) {
        // Inicializar el juego
        Controlador.iniciarJuego(8, 8, 10);

        // Crear la interfaz gráfica
        Interfaz interfaz = new Interfaz(8, 8, 10);
        Controlador.setInterfaz(interfaz);

        // Mostrar la interfaz
        interfaz.mostrar();
    }
}
