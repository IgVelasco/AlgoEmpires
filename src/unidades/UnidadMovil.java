package unidades;

import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import Excepciones.UnidadYaUtilizada;
import contenibles.Contenible;
import espacio.Mapa;
import espacio.Posicion;
import juego.Jugador;

import static java.lang.Math.abs;
import static sun.swing.MenuItemLayoutHelper.max;

public abstract class UnidadMovil implements Contenible {

    public int vida;
    Posicion posicion;
    boolean sePuedeMover;
    Jugador propietario;

    public UnidadMovil() {
        sePuedeMover = true;
    }


    /* int posicionHorizontal;
    int posicionVertical;

    public void mover(){

    }
     */

    public boolean sonDelMismoJugador(Jugador unPropietario){
        return (unPropietario == this.propietario);
    }


    public void ataqueDeEspadachin() {
        int golpeDeEspadachin = 25;
        this.vida -= golpeDeEspadachin;
    }

    public void ataqueDeArquero() {
        int golpeDeArquero = 15;
        this.vida -= golpeDeArquero;
    }

    public void moverDerecha(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        if (!sePuedeMover) throw new UnidadYaUtilizada();
        mapa.mover( this.posicion.getPosX(), this.posicion.getPosY(), 1, 0);
        sePuedeMover = false;
    }

    public void moverIzquierda(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        if (!sePuedeMover) throw new UnidadYaUtilizada();
        mapa.mover(this.posicion.getPosX(), this.posicion.getPosY(), -1, 0);
        sePuedeMover = false;
    }

    public void moverArriba(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        if (!sePuedeMover) throw new UnidadYaUtilizada();
        mapa.mover(this.posicion.getPosX(), this.posicion.getPosY(), 0, 1);
        sePuedeMover = false;
    }

    public void moverAbajo(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        if (!sePuedeMover) throw new UnidadYaUtilizada();
        mapa.mover(this.posicion.getPosX(), this.posicion.getPosY(), 0, -1);
        sePuedeMover = false;
    }

    public void moverDerechaSuperior(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        if (!sePuedeMover) throw new UnidadYaUtilizada();
        mapa.mover(this.posicion.getPosX(), this.posicion.getPosY(), 1, 1);
        sePuedeMover = false;
    }

    public void moverDerechaInferior(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        if (!sePuedeMover) throw new UnidadYaUtilizada();
        mapa.mover(this.posicion.getPosX(), this.posicion.getPosY(), 1, -1);
        sePuedeMover = false;
    }

    public void moverIzquierdaSuperior(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        if (!sePuedeMover) throw new UnidadYaUtilizada();
        mapa.mover(this.posicion.getPosX(), this.posicion.getPosY(), -1, 1);
        sePuedeMover = false;
    }

    public void moverIzquierdaInferior(Mapa mapa) throws CasilleroOcupado, ExcedeLimiteDelMapa, UnidadYaUtilizada {
        if (!sePuedeMover) throw new UnidadYaUtilizada();
        mapa.mover(this.posicion.getPosX(), this.posicion.getPosY(), -1, -1);
        sePuedeMover = false;
    }

    public int calcularDistancia(int x, int y) {
        return posicion.distancia(x, y);
    }

    public void setPosicion(Posicion pos) {
        posicion = pos;
    }

    public int getPosicionHorizontal() {
        return this.posicion.getPosX();
    }

    public int getPosicionVertical() {
        return this.posicion.getPosY();
    }

    public void permitirMovimiento(){
        sePuedeMover = true;
    }

}
