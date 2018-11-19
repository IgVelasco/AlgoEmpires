package unidades;


import juego.Jugador;

public class ArmaDeAsedio extends UnidadMovil {



    public int getVida() {
        return this.vida;
    }

    public ArmaDeAsedio(Jugador unJugador){
        vida = 150;
        propietario = unJugador;

    }
}