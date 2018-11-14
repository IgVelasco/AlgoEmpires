package estructuras;

import contenibles.Contenible;
import unidades.Arquero;
import unidades.Espadachin;

public class Cuartel implements Contenible {

    private int vida = 250;

    public int getVida() {
        return this.vida;
    }

    public Espadachin crearEspadachin() {
        return new Espadachin();
    }

    public Arquero crearArquero() {
        return new Arquero();
    }
}
