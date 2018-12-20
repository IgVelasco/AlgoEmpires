package modelo.unidades;

import modelo.espacio.Contenible;
import modelo.estados.aldeano.Construyendo;
import modelo.estados.aldeano.EstadoAldeano;
import modelo.estados.aldeano.GenerandoOro;
import modelo.estados.aldeano.Reparando;
import modelo.estructuras.Cimiento;
import modelo.estructuras.Estructura;
import modelo.excepciones.ContenibleFueraDeRango;
import modelo.excepciones.ContenibleNoPropia;
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

    public void realizarAccionCorrespondiente() {
        this.estado.realizarAccion(this);
    }

    public int comenzarCimientos(Cimiento cimiento, Jugador unJugador) {
        if(!this.sonDelMismoJugador(unJugador))
            throw new ContenibleNoPropia();
        if(cimiento.calcularDistancia(posicion.getPosX(),posicion.getPosY()) > 1)
            throw new ContenibleFueraDeRango();
        estado.ocupar();
        this.estado = new Construyendo(cimiento);
        cimiento.setConstructor(this);
        return (cimiento.distanciaMenores(this.posicion.getPosX(),this.posicion.getPosY()));
    }


    public void comenzarReparacion(Estructura unaEstructura) {
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