package unidades;

import Excepciones.AldeanoOcupado;
import Excepciones.EdificioConVidaMaxima;
import Excepciones.ContenibleNoPropia;
import estadosAldeano.Construyendo;
import estadosAldeano.EstadoAldeano;
import estadosAldeano.GenerandoOro;
import estadosAldeano.Reparando;
import estructuras.Cimiento;
import estructuras.Estructura;
import juego.Jugador;

public class Aldeano extends Accionables {

    private EstadoAldeano estado = new GenerandoOro();

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

    public EstadoAldeano getEstado() {
        return estado;
    }

}