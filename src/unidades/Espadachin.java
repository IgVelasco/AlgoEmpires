package unidades;


import Excepciones.ContenibleDelMismoJugador;
import Excepciones.ContenibleFueraDeRango;
import Excepciones.ExcedeLimiteDelMapa;
import contenibles.Contenible;
import espacio.Posicion;
import juego.Jugador;

public class Espadachin extends UnidadMovil {


    public Espadachin(Jugador unJugador) {
        vida = 100;
        propietario = unJugador;
    }

    public int getVida() {
        return this.vida;
    }

    @Override
    public void setPosicion(Posicion pos) {
        posicion = pos;
    }


    public void atacar(Contenible unContenible) throws ContenibleFueraDeRango, ContenibleDelMismoJugador, ExcedeLimiteDelMapa {
        if (unContenible.calcularDistancia(this.posicion.getPosX(), this.posicion.getPosY()) > 1)
            throw new ContenibleFueraDeRango();
        if (unContenible.sonDelMismoJugador(this.propietario))
            throw new ContenibleDelMismoJugador();
        unContenible.ataqueDeEspadachin();
    }
}
