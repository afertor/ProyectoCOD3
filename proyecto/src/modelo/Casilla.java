package modelo;

import java.awt.Image;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Casilla extends JButton {

    private boolean abierta;
    private boolean mina;
    private int valor;
    private boolean marcada;
    private ImageIcon imagenBandera;
    private ImageIcon imagenMina;
    private Tablero tablero;

    public Casilla(Tablero tablero) {
        this.tablero = tablero;
        this.abierta = false;
        this.mina = false;
        this.valor = 0;
        this.marcada = false;

        // Carga las imágenes de la bandera y la mina y escala su tamaño
        Image bandera = new ImageIcon("bandera.png").getImage().getScaledInstance(175, 175, Image.SCALE_SMOOTH);
        imagenBandera = new ImageIcon(bandera);

        Image mina = new ImageIcon("mina.png").getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        imagenMina = new ImageIcon(mina);

        // Agrega un MouseAdapter para manejar los eventos del mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    abrir();
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    marcar();
                }
            }
        });
    }

    public void abrir() {
        if (!abierta && !marcada) {
            abierta = true;
            setEnabled(false);
            if (mina) {
                setBackground(Color.RED);
                setIcon(imagenMina);
                tablero.mostrarMensajeDerrota();
            } else {
                setText(String.valueOf(valor));
            }

            if (tablero.estadoJuego()) {
                tablero.mostrarMensajeVictoria();
            }
        }
    }

    public void marcar() {
        if (!abierta) {
            marcada = !marcada;
            if (marcada) {
                setBackground(Color.RED);
                setIcon(imagenBandera);
            } else {
                setBackground(null);
                setIcon(null);
            }
        }
    }

    public boolean isAbierta() {
        return abierta;
    }

    public boolean isMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isMarcada() {
        return marcada;
    }

    public void setMarcada(boolean marcada) {
        this.marcada = marcada;
    }
}
