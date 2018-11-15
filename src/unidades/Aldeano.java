package unidades;

import Excepciones.AldeanoOcupado;
import Excepciones.EdificioConVidaMaxima;
import estados.*;
import estructuras.Estructura;
import juego.Jugador;

public class Aldeano extends UnidadMovil {

    private int vida = 50;
    private Estado estado = new GenerandoOro();
    public Jugador propietario;

    public Aldeano(Jugador jugador) {
        propietario = jugador;
    }

    public int getVida() {
        return this.vida;
    }

    public void realizarAccionCorrespondiente() {
        this.estado.realizarAccionPasiva(this);
    }

    public void comenzarConstruccion(Estructura estructura) throws AldeanoOcupado {
        this.estaOcupado();
        this.estado = new Construyendo(estructura);
    }

    private void estaOcupado() throws AldeanoOcupado {
        if(estado instanceof Ocupado)
            throw new AldeanoOcupado();
    }

    public void finalizarConstruccion(Estructura unaEstructura){
        //Estado Estructura
        this.liberarAldeano();
    }


    public void comenzarReparacion(Estructura unaEstructura) throws EdificioConVidaMaxima, AldeanoOcupado {
        this.estaOcupado();
        unaEstructura.reparar();
        estado = new Reparando(unaEstructura);
    }

    public void finalizarReparacion(Estructura unaEstructura) {
       //Estructura estados falta
        this.liberarAldeano();
    }

    private void liberarAldeano() {
        this.estado = new GenerandoOro();
    }

    public void recolectarOro(int oro) {
        this.propietario.sumarOro(oro);
    }

    public Estado getEstado() {
        return estado;
    }
}