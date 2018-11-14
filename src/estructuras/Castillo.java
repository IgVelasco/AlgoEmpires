package estructuras;

import contenibles.Contenible;
import unidades.ArmaDeAsedio;

public class Castillo implements Contenible {

    private int vida = 1000;

    public int getVida() {
        return this.vida;
    }

    public ArmaDeAsedio crearArmaDeAsedio() {
        return new ArmaDeAsedio();
    }
}
