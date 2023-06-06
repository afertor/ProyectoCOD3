package buscaminas;

public class Proyecto_buscaminas {
    public static void main(String[] args) {
        Tablero tablero = Tablero.getInstance(8, 8, 10);
        Interfaz interfaz = new Interfaz(tablero);
        tablero.setInterfaz(interfaz);
        interfaz.setVisible(true);
    }
}

