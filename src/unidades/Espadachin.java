package unidades;


import Excepciones.ContenibleFueraDeRango;
import contenibles.Contenible;
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
    public void setPosicion(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public void atacar(Contenible unContenible) throws ContenibleFueraDeRango {
        if(rangoDeContenible(unContenible) != 1)
            throw new ContenibleFueraDeRango();
        unContenible.ataqueDeEspadachin();
    }
}
