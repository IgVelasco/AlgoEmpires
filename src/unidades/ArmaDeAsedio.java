package unidades;


import juego.Jugador;

public class ArmaDeAsedio extends UnidadMovil {



    public int getVida() {
        return this.vida;
    }

    @Override
    public void setPosicion(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public ArmaDeAsedio(Jugador unJugador){
        vida = 150;
        propietario = unJugador;

    }
}