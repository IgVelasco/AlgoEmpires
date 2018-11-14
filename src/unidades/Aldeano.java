package unidades;

import estados.Construyendo;
import estados.Estado;
import estados.GenerandoOro;
import estructuras.Estructura;
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

    public void comenzarConstruccion(Estructura estructura) {
        estado = new Construyendo(estructura);

    }

}