package unidades;

import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import Excepciones.UnidadYaUtilizada;
import contenibles.Contenible;
import espacio.Mapa;

import static java.lang.Math.abs;
import static sun.swing.MenuItemLayoutHelper.max;

public abstract class UnidadMovil implements Contenible {

    private int vida;
    int posX;
    int posY;
    boolean sePuedeMover;

    public UnidadMovil() {
        sePuedeMover = true;
    }


    /* int posicionHorizontal;
    int posicionVertical;

    public void mover(){

    }
     */

    public int distancia(int x, int y){
        return max(abs(x - this.posX), abs(y - posY));
    }


    public int rangoDeContenible(Contenible unContenible){
        return unContenible.distancia(this.posX, this.posY);

    }


    public void ataqueDeEspadachin() {
        int golpeDeEspadachin = 25;
        vida -= golpeDeEspadachin;
    }

    public void ataqueDeArquero() {
        int golpeDeArquero = 10;
        vida -= golpeDeArquero;
    }

    public void moverDerecha(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        if (!sePuedeMover) throw new UnidadYaUtilizada();
        mapa.mover( this.posX, this.posY, 1, 0);
        sePuedeMover = false;
    }

    public void moverIzquierda(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        if (!sePuedeMover) throw new UnidadYaUtilizada();
        mapa.mover(this.posX, this.posY, -1, 0);
        sePuedeMover = false;
    }

    public void moverArriba(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        if (!sePuedeMover) throw new UnidadYaUtilizada();
        mapa.mover(this.posX, this.posY, 0, 1);
        sePuedeMover = false;
    }

    public void moverAbajo(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        if (!sePuedeMover) throw new UnidadYaUtilizada();
        mapa.mover(this.posX, this.posY, 0, -1);
        sePuedeMover = false;
    }

    public void moverDerechaSuperior(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        if (!sePuedeMover) throw new UnidadYaUtilizada();
        mapa.mover(this.posX, this.posY, 1, 1);
        sePuedeMover = false;
    }

    public void moverDerechaInferior(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        if (!sePuedeMover) throw new UnidadYaUtilizada();
        mapa.mover(this.posX, this.posY, 1, -1);
        sePuedeMover = false;
    }

    public void moverIzquierdaSuperior(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        if (!sePuedeMover) throw new UnidadYaUtilizada();
        mapa.mover(this.posX, this.posY, -1, 1);
        sePuedeMover = false;
    }

    public void moverIzquierdaInferior(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        if (!sePuedeMover) throw new UnidadYaUtilizada();
        mapa.mover(this.posX, this.posY, -1, -1);
        sePuedeMover = false;
    }

    public int getPosicionHorizontal() {
        return this.posX;
    }

    public int getPosicionVertical() {
        return this.posY;
    }

    public void permitirMovimiento(){
        sePuedeMover = true;
    }

}
