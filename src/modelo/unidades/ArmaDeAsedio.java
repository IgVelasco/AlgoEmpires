package modelo.unidades;


import modelo.espacio.Contenible;
import modelo.espacio.Mapa;
import modelo.estados.ataque.ArmaCargada;
import modelo.estados.ataque.ArmaDescargada;
import modelo.estados.ataque.EstadosAtaque;
import modelo.excepciones.*;
import modelo.juego.Jugador;

public class ArmaDeAsedio extends Accionables implements Atacante{
    private EstadosAtaque estado;
    private final static int rango = 5;


    public int getVida() {
        return this.vida;
    }

    public ArmaDeAsedio(Jugador unJugador) {
        vida = 150;
        propietario = unJugador;
        estado = new ArmaDescargada(true);

    }

    public void descargarArmaDeAsedio(Jugador unJugador){
        this.sonDelMismoJugador(unJugador);
        estado = new ArmaDescargada(false);
    }

    public void realizarMovimiento(Mapa mapa, int x, int y, Jugador unJugador) {
        if(!estado.movible())
            throw new ArmaCargadaNoSePuedeMover();
        super.realizarMovimiento(mapa, x, y, unJugador);
    }


    public void realizarAccionCorrespondiente() {
        this.estado.realizarAccion();
    }

    public void cargarArma(Jugador unJugador) throws ArmaYaCargada, ArmaSeCargaEnSiguienteTurno {
        this.sonDelMismoJugador(unJugador);
        estado.cargarArma();
        estado = new ArmaCargada();
    }

    public void atacar(Contenible unContenible, Jugador unJugador) {
        estado.ataqueListo();
        if(!this.sonDelMismoJugador(unJugador))
            throw new ContenibleNoPropia();
        if (unContenible.calcularDistancia(this.posicion.getPosX(), this.posicion.getPosY()) > rango)
            throw new ContenibleFueraDeRango();
        if (unContenible.sonDelMismoJugador(this.propietario))
            throw new ContenibleDelMismoJugador();
        unJugador.agregarAtacante(this);
        unContenible.ataqueDeAsedio();
        this.estado = new ArmaDescargada(false);
    }
}