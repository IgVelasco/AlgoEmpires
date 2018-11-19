package unidades;

import Excepciones.AldeanoOcupado;
import Excepciones.EdificioConVidaMaxima;
import estados.*;
import estructuras.Estructura;
import juego.Jugador;

public class Aldeano extends UnidadMovil {

    private Estado estado = new GenerandoOro();

    public Aldeano(Jugador jugador) {
        propietario = jugador;
        sePuedeMover = true;
        vida = 50;
    }

    public int getVida() {
        return this.vida;
    }

    public void realizarAccionCorrespondiente() {
        this.estado.realizarAccion(this);
    }

    public void comenzarConstruccion(Estructura estructura) throws AldeanoOcupado {
        estado.ocupar();
        this.estado = new Construyendo(estructura);
    }


    public void comenzarReparacion(Estructura unaEstructura) throws EdificioConVidaMaxima, AldeanoOcupado {
        estado.ocupar();
        unaEstructura.ponerAReparar();
        estado = new Reparando(unaEstructura);
    }

    public void liberarAldeano() {
        this.estado = new GenerandoOro();
    }

    public void recolectarOro(int oro) {
        this.propietario.sumarOro(oro);
    }

    public Estado getEstado() {
        return estado;
    }

}