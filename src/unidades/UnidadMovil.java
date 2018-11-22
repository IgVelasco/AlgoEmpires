package unidades;

import Excepciones.*;
import contenibles.Contenible;
import espacio.Mapa;
import espacio.Posicion;
import juego.Jugador;

public abstract class UnidadMovil implements Contenible {

    private static final int
            DANO_ARQUERO = 15,
            DANO_ESPADACHIN = 25,
            DANO_CASTILLO = 20;
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


    public void ataqueDeEspadachin() throws ExcedeLimiteDelMapa {
        this.vida -= DANO_ESPADACHIN;
        if ( this.vida <= 0 ) propietario.borrarUnidad(posicion);
    }

    public void ataqueDeArquero() throws ExcedeLimiteDelMapa {
        this.vida -= DANO_ARQUERO;
        if ( this.vida <= 0 ) propietario.borrarUnidad(posicion);
    }

    public void ataqueDeCastillo() throws ExcedeLimiteDelMapa {
        vida -= DANO_CASTILLO;
        if ( this.vida <= 0 ) propietario.borrarUnidad(posicion);
    }

    public void ataqueDeAsedio() throws AsedioNoAtacaUnidad {
        throw new AsedioNoAtacaUnidad();
    }


    public void realizarMovimiento(Mapa mapa, int x, int y, Jugador unJugador) throws ExcedeLimiteDelMapa, MovimientoFueraDeRango, UnidadYaUtilizada, CasilleroOcupado, ContenibleNoPropia {
        if(!this.sonDelMismoJugador(unJugador))
            throw new ContenibleNoPropia();
        if (!sePuedeMover)
            throw new UnidadYaUtilizada();
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
