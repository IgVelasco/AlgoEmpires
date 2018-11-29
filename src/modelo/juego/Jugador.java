package modelo.juego;

import modelo.espacio.Contenible;
import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.estructuras.*;
import modelo.excepciones.*;
import modelo.unidades.Accionables;
import modelo.unidades.Aldeano;
import modelo.unidades.Atacante;
import modelo.unidades.UnidadMovil;

import java.util.ArrayList;

public class Jugador {
    private Mapa mapa;
    private Juego juego;
    private Castillo castillo;
    private ArrayList<Estructura> estructuras = new ArrayList<Estructura>();
    private ArrayList<Accionables> accionables = new ArrayList<Accionables>();
    private ArrayList<UnidadMovil> movidos = new ArrayList<UnidadMovil>();
    private ArrayList<Atacante> atacaron = new ArrayList<Atacante>();
    private int oro, poblacionActual, poblacionMaxima;

    public Jugador(Mapa mapa, int posicionCastilloHorizontal, int posicionCastilloVertical, Juego juego) throws CasilleroOcupado, ExcedeLimiteDelMapa {
        castillo = new Castillo(this);
        estructuras.add(new PlazaCentral(this));
        this.mapa = mapa;
        this.oro = 100;
        this.poblacionActual = 3;
        this.poblacionMaxima = 50;

        mapa.colocarEstructuraEn(castillo, posicionCastilloHorizontal, posicionCastilloVertical, 4);
        mapa.colocarEstructuraEn(estructuras.get(0), posicionCastilloHorizontal - 2, posicionCastilloVertical, 2);

        for (int i = 0; i < 3; i++) {
            accionables.add(i, new Aldeano(this));
            mapa.colocarUnidadEn(accionables.get(i), posicionCastilloHorizontal - 3, posicionCastilloVertical + i);
        }
    }

    public void nuevoTurno() throws ExcedeLimiteDelMapa, ArmaYaCargada, CasilleroOcupado {
        for (Accionables accionable : accionables) {
            accionable.realizarAccionCorrespondiente();
        }
        castillo.atacar(mapa);
        movidos.clear();
        atacaron.clear();
    }

    public void finalizarTurno() throws ExcedeLimiteDelMapa, ArmaYaCargada, CasilleroOcupado {
        juego.siguienteTurno();
    }


    public void sumarOro(int unidadesDeOro) {
        this.oro += unidadesDeOro;
    }

    public void construirPlazaCentral(Aldeano aldeano, int x, int y) throws AldeanoOcupado, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleNoPropia { // Podria ser asi o que se le pase un indez de array
        PlazaCentral unaPlazaCentral = new PlazaCentral(this);
        Cimiento unCimiento = new Cimiento(unaPlazaCentral, this.mapa, x, y, 2);
        aldeano.comenzarCimientos(unCimiento, this);
        estructuras.add(unaPlazaCentral);
        mapa.colocarEstructuraEn(unaPlazaCentral, x, y, 2);
    }

    public void construirAsedio() throws PoblacionLimiteAlcanzada, OroInsuficiente {
        this.castillo.crearArmaDeAsedio(this.oro);
    }

    public void construirCuartel(Aldeano aldeano, int x, int y) throws AldeanoOcupado, CasilleroOcupado, ExcedeLimiteDelMapa, ContenibleNoPropia {

        Cuartel unCuartel = new Cuartel(this);
        Cimiento elCimiento = new Cimiento(unCuartel, this.mapa, x, y, 2);
        //estructuras.add(unCuartel);  Todavia no deberia agregarse
        aldeano.comenzarCimientos(elCimiento,this);
    }


    public void repararEstructura(Aldeano unAldeano, Estructura unaEstructura) throws EdificioConVidaMaxima, AldeanoOcupado {
        unAldeano.comenzarReparacion(unaEstructura);
    }

    public int getOro() {
        return this.oro;
    }

    public void disminuirPoblacion() {
        if (poblacionActual > 0)
            this.poblacionActual--;
    }

    public void aumentarPoblacion() throws PoblacionLimiteAlcanzada {
        if (poblacionActual == poblacionMaxima)
            throw new PoblacionLimiteAlcanzada();

        this.poblacionActual++;
    }

    public void borrarUnidad(Posicion posicion) throws  ExcedeLimiteDelMapa {
        this.disminuirPoblacion();
        mapa.liberarUbicacion(posicion);
    }

    public int getPoblacionActual() {
        return this.poblacionActual;
    }

    public void mover(UnidadMovil unidad, int x , int y) throws ExcedeLimiteDelMapa, CasilleroOcupado, UnidadYaUtilizada, MovimientoFueraDeRango, ContenibleNoPropia, ArmaCargadaNoSePuedeMover {
        if(movidos.contains(unidad))
            throw new UnidadYaUtilizada();
        unidad.realizarMovimiento(mapa, x, y, this);
        movidos.add(unidad);
    }

    public void atacar(Atacante unidad, int x , int y) throws ExcedeLimiteDelMapa, UnidadYaUtilizada, ArmaNoCargada, ContenibleFueraDeRango, AsedioNoAtacaUnidad, ContenibleDelMismoJugador {
        if(atacaron.contains(unidad))
            throw new UnidadYaUtilizada();

        Contenible objetivoDeAtaque = mapa.getContenido(x, y);
        unidad.atacar(objetivoDeAtaque);
        atacaron.add(unidad);
    }

    public void accionableMuerto(Accionables unAccionable) {
        accionables.remove(unAccionable);
    }
}
