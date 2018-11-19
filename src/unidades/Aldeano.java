package unidades;

import Excepciones.AldeanoOcupado;
import Excepciones.EdificioConVidaMaxima;
import estados.*;
import estructuras.Estructura;
import juego.Jugador;

public class Aldeano extends UnidadMovil {

    private Estado estado = new GenerandoOro();
    private Jugador propietario;

    public Aldeano(Jugador jugador) {
        propietario = jugador;
        sePuedeMover = true;
        vida = 50;
    }

    public int getVida() {
        return this.vida;
    }

    public void realizarAccionCorrespondiente() {
        this.estado.realizarAccionPasiva(this);
    }

    public void comenzarConstruccion(Estructura estructura) throws AldeanoOcupado {
        estado.estaOcupado();
        this.estado = new Construyendo(estructura);
    }


    public void comenzarReparacion(Estructura unaEstructura) throws EdificioConVidaMaxima, AldeanoOcupado {
        estado.estaOcupado();
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

    @Override
    public void setPosicion(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

}