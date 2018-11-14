package estructuras;

import contenibles.Contenible;
import unidades.Aldeano;

public class PlazaCentral implements Contenible {
    private int vida = 450;

    public int getVida() {
        return this.vida;
    }

    public Aldeano crearAldeano() {
        return new Aldeano();
    }
}
