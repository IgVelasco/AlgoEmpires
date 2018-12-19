package modelo.unidades;


import modelo.espacio.Contenible;
import modelo.juego.Jugador;

public class Espadachin extends Infanteria implements Atacante {

    public Espadachin(Jugador unJugador) {
        vida = 100;
        propietario = unJugador;
        rango = 1;
    }

    public int getVida() {
        return this.vida;
    }


    public void atacar(Contenible unContenible, Jugador unJugador) {
        super.atacar(unContenible, unJugador);
        unContenible.ataqueDeEspadachin();
    }
}
