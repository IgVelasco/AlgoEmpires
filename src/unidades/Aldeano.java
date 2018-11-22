package unidades;

import Excepciones.AldeanoOcupado;
import Excepciones.EdificioConVidaMaxima;
import Excepciones.ContenibleNoPropia;
import estados.Construyendo;
import estados.Estado;
import estados.GenerandoOro;
import estados.Reparando;
import estructuras.Cimiento;
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

    public void comenzarCimientos(Cimiento cimiento, Jugador unJugador) throws AldeanoOcupado, ContenibleNoPropia {
        if(!this.sonDelMismoJugador(unJugador))
            throw new ContenibleNoPropia();
        estado.ocupar();
        this.estado = new Construyendo(cimiento);
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