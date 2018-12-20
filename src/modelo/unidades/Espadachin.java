package modelo.unidades;


import modelo.espacio.Contenible;
import modelo.espacio.Posicion;
import modelo.juego.Jugador;

public class Espadachin extends Infanteria implements Atacante {

    public Espadachin(Jugador unJugador, Posicion unaPosicion) {
        vida = 100;
        propietario = unJugador;
        rango = 1;
        posicion = unaPosicion;
    }

    public int getVida() {
        return this.vida;
    }


    public void atacar(Contenible unContenible, Jugador unJugador) {
        super.atacar(unContenible, unJugador);
        unContenible.ataqueDeEspadachin();
    }
}
