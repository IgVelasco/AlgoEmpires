package modelo.unidades;

import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.estados.aldeano.Construyendo;
import modelo.estados.aldeano.EstadoAldeano;
import modelo.estados.aldeano.GenerandoOro;
import modelo.estados.aldeano.Reparando;
import modelo.estructuras.Cimiento;
import modelo.estructuras.Estructura;
import modelo.excepciones.ContenibleFueraDeRango;
import modelo.excepciones.ContenibleNoPropia;
import modelo.excepciones.PosicionFueraDeRango;
import modelo.juego.Jugador;

public class Aldeano extends Accionables {

    private EstadoAldeano estado = new GenerandoOro();

    public Aldeano(Jugador jugador, Posicion unaPosicion) {
        propietario = jugador;
        vida = 50;
        posicion = unaPosicion;
    }

    public int getVida() {
        return this.vida;
    }

    public void realizarMovimiento(Mapa mapa, int x, int y, Jugador unJugador){
        estado.ocupar();
        super.realizarMovimiento(mapa, x, y, unJugador);
    }

    public void realizarAccionCorrespondiente() {
        this.estado.realizarAccion(this);
    }

    public int comenzarCimientos(Cimiento cimiento, Jugador unJugador) {
        if(!this.sonDelMismoJugador(unJugador))
            throw new ContenibleNoPropia();
        if(cimiento.calcularDistancia(posicion.getPosX(),posicion.getPosY()) > 1)
            throw new PosicionFueraDeRango();
        estado.ocupar();
        this.estado = new Construyendo(cimiento);
        cimiento.setConstructor(this);
        return (cimiento.distanciaMenores(this.posicion.getPosX(),this.posicion.getPosY()));
    }


    public void comenzarReparacion(Estructura unaEstructura, Jugador unJugador) {
        if(!this.sonDelMismoJugador(unJugador))
            throw new ContenibleNoPropia();
        estado.ocupar();
        unaEstructura.ponerAReparar(this);
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