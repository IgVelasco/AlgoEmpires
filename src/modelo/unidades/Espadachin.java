package modelo.unidades;


import modelo.espacio.Contenible;
import modelo.espacio.Posicion;
import modelo.excepciones.*;
import modelo.juego.Jugador;

public class Espadachin extends Infanteria implements Atacante {


    public Espadachin(Jugador unJugador) {
        vida = 100;
        propietario = unJugador;
    }

    public int getVida() {
        return this.vida;
    }


    public void atacar(Contenible unContenible, Jugador unJugador) throws ContenibleFueraDeRango, ContenibleDelMismoJugador, ExcedeLimiteDelMapa, ContenibleNoPropia, UnidadYaAtaco {
        super.atacar(unContenible, unJugador);
        unContenible.ataqueDeEspadachin();
    }
}
