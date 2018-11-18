package unidades;

import contenibles.Contenible;

public abstract class UnidadMovil implements Contenible {

    private int vida;


    /* int posicionHorizontal;
    int posicionVertical;

    public void mover(){

    }
     */

    public void ataqueDeEspadachin() {
        int golpeDeEspadachin = 25;
        vida -= golpeDeEspadachin;
    }

    public void ataqueDeArquero() {
        int golpeDeArquero = 10;
        vida -= golpeDeArquero;
    }

}
