package unidades;

import estados.Estado;
import estados.GenerandoOro;
import juego.Jugador;

public class Aldeano extends UnidadMovil {

    private int vida = 50;
    private Estado estado;
    public Jugador perteneceA;

    public Aldeano(Jugador jugador) {
        estado = new GenerandoOro();
        perteneceA = jugador;
    }

    public int getVida() {
        return this.vida;
    }

    public void realizarAccionCorrespondiente() {
        estado.realizarAccionPasiva(this.perteneceA);
    }

}