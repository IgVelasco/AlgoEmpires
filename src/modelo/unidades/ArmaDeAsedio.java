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


    public int getVida() {
        return this.vida;
    }

    public ArmaDeAsedio(Jugador unJugador) {
        vida = 150;
        propietario = unJugador;
        estado = new ArmaDescargada(true);

    }


    public void realizarMovimiento(Mapa mapa, int x, int y, Jugador unJugador) throws ExcedeLimiteDelMapa, MovimientoFueraDeRango, UnidadYaUtilizada, CasilleroOcupado, ContenibleNoPropia, ArmaCargadaNoSePuedeMover {
        if(!estado.movible())
            throw new ArmaCargadaNoSePuedeMover();
        super.realizarMovimiento(mapa, x, y, unJugador);
    }


        public void realizarAccionCorrespondiente()  {
        this.estado.realizarAccion();
    }

    public void cargarArma() throws ArmaYaCargada, ArmaSeCargaEnSiguienteTurno {
        estado.cargarArma();
        estado = new ArmaCargada();
    }

    public void atacar(Contenible unContenible) throws ContenibleFueraDeRango, ContenibleDelMismoJugador, AsedioNoAtacaUnidad, ArmaNoCargada {
        estado.ataqueListo();
        if (unContenible.calcularDistancia(this.posicion.getPosX(), this.posicion.getPosY()) > 3)
            throw new ContenibleFueraDeRango();
        if (unContenible.sonDelMismoJugador(this.propietario))
            throw new ContenibleDelMismoJugador();
        unContenible.ataqueDeAsedio();
        this.estado = new ArmaDescargada(false);
    }
}