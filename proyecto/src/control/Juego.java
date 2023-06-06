package control;

import javax.swing.JFrame;


public class Juego extends JFrame {

    PanelJuego obj = new PanelJuego();

    public Juego() {
        this.add(obj);
        this.setTitle("Juego de Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
