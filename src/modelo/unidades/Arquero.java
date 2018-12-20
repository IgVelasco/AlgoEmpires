package modelo.unidades;


import modelo.espacio.Contenible;
import modelo.espacio.Posicion;
import modelo.juego.Jugador;

public class Arquero extends Infanteria implements Atacante{

    public Arquero(Jugador unJugador, Posicion unaPosicion) {
        vida = 75;
        propietario = unJugador;
        rango = 3;
        posicion = unaPosicion;
    }

    public int getVida() {
        return this.vida;
    }


    public void atacar(Contenible unContenible, Jugador unJugador) {
        super.atacar(unContenible, unJugador);
        unContenible.ataqueDeArquero();
    }

}
