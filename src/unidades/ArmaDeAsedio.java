package unidades;


import Excepciones.*;
import contenibles.Contenible;
import juego.Jugador;

public class ArmaDeAsedio extends UnidadMovil {


    public int getVida() {
        return this.vida;
    }

    public ArmaDeAsedio(Jugador unJugador) {
        vida = 150;
        propietario = unJugador;

    }

    public void atacar(Contenible unContenible) throws ContenibleFueraDeRango, ContenibleDelMismoJugador, ExcedeLimiteDelMapa, AsedioNoAtacaUnidad {
        if (unContenible.calcularDistancia(this.posicion.getPosX(), this.posicion.getPosY()) > 3)
            throw new ContenibleFueraDeRango();
        if (unContenible.sonDelMismoJugador(this.propietario))
            throw new ContenibleDelMismoJugador();
        unContenible.ataqueDeAsedio();
    }
}