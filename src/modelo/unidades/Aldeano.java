package modelo.unidades;

import modelo.estados.aldeano.Construyendo;
import modelo.estados.aldeano.EstadoAldeano;
import modelo.estados.aldeano.GenerandoOro;
import modelo.estados.aldeano.Reparando;
import modelo.estructuras.Cimiento;
import modelo.estructuras.Estructura;
import modelo.excepciones.*;
import modelo.juego.Jugador;

public class Aldeano extends Accionables {

    private EstadoAldeano estado = new GenerandoOro();

    public Aldeano(Jugador jugador) {
        propietario = jugador;
        vida = 50;
    }

    public int getVida() {
        return this.vida;
    }

    public void realizarAccionCorrespondiente() throws CasilleroOcupado, ExcedeLimiteDelMapa {
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