package unidades;

import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import contenibles.Contenible;
import espacio.Mapa;

public abstract class UnidadMovil implements Contenible {

    private int vida;
    private int posX;
    private int posY;


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

    public void moverDerecha(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        mapa.mover( this.posX, this.posY, 1, 0);
    }

    public void moverIzquierda(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        mapa.mover(this.posX, this.posY, -1, 0);
    }

    public void moverArriba(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        mapa.mover(this.posX, this.posY, 0, 1);
    }

    public void moverAbajo(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        mapa.mover(this.posX, this.posY, 0, -1);
    }

    public void moverDerechaSuperior(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        mapa.mover(this.posX, this.posY, 1, 1);
    }

    public void moverDerechaInferior(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        mapa.mover(this.posX, this.posY, 1, -1);
    }

    public void moverIzquierdaSuperior(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        mapa.mover(this.posX, this.posY, -1, 1);
    }

    public void moverIzquierdaInferior(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        mapa.mover(this.posX, this.posY, -1, -1);
    }

}
