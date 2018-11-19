package unidades;


import Excepciones.ContenibleFueraDeRango;
import contenibles.Contenible;
import juego.Jugador;

public class Arquero extends UnidadMovil {

    public Arquero(Jugador unJugador){
        vida = 75;
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
        if(rangoDeContenible(unContenible) > 3)
            throw new ContenibleFueraDeRango();
        unContenible.ataqueDeArquero();
    }

}
