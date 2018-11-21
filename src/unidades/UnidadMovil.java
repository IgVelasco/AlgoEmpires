package unidades;

import Excepciones.*;
import contenibles.Contenible;
import espacio.Mapa;
import espacio.Posicion;
import juego.Jugador;

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

    public boolean sonDelMismoJugador(Jugador unPropietario) {
        return (unPropietario == this.propietario);
    }


    public void ataqueDeEspadachin() throws ExcedeLimiteDelMapa, PoblacionNula {
        int golpeDeEspadachin = 25;
        this.vida -= golpeDeEspadachin;
        if ( this.vida <= 0 ) propietario.borrarUnidad(posicion);
    }

    public void ataqueDeArquero() throws ExcedeLimiteDelMapa, PoblacionNula {
        int golpeDeArquero = 15;
        this.vida -= golpeDeArquero;
        if ( this.vida <= 0 ) propietario.borrarUnidad(posicion);
    }

    public void ataqueDeCastillo() throws ExcedeLimiteDelMapa, PoblacionNula {
        int golpeDeCastillo = 20;
        vida -= golpeDeCastillo;
        if ( this.vida <= 0 ) propietario.borrarUnidad(posicion);
    }

    public void realizarMovimiento(Mapa mapa, int x, int y) throws ExcedeLimiteDelMapa, MovimientoFueraDeRango, UnidadYaUtilizada, CasilleroOcupado {
        if (!sePuedeMover) throw new UnidadYaUtilizada();
        if (this.calcularDistancia(this.posicion.getPosX() + x, this.posicion.getPosY() + y) != 1)
            throw new MovimientoFueraDeRango();
        mapa.mover(this.posicion.getPosX(), this.posicion.getPosY(), x, y);
        sePuedeMover = false;
    }

    public int calcularDistancia(int x, int y) {
        return posicion.distancia(x, y);
    }

    public void setPosicion(Posicion pos) {
        posicion = pos;
    }

    public void permitirMovimiento() {
        sePuedeMover = true;
    }

}
