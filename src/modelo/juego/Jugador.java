package modelo.juego;

import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.estructuras.*;
import modelo.excepciones.OroInsuficiente;
import modelo.excepciones.PoblacionLimiteAlcanzada;
import modelo.unidades.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class Jugador {

    private static final int
            PRECIO_PLAZA = 100,
            PRECIO_CUARTEL = 50,
            POBLACION_MAXIMA = 50,
            ALDEANOS_INICIALES = 3,
            ORO_INICIAL = 100,
            ORO_POR_ALDEANO = 20;
    private Juego juego;
    private Mapa mapa;
    private Castillo castillo;
    private ArrayList<Accionables> accionables = new ArrayList<Accionables>();
    private ArrayList<UnidadMovil> movidos = new ArrayList<UnidadMovil>();
    private ArrayList<Atacante> atacaron = new ArrayList<Atacante>();
    private int oro, poblacionActual, poblacionMaxima;
    private String nombreJugador;


    public Jugador(Mapa mapa, int posicionCastilloHorizontal, int posicionCastilloVertical, Juego juego) {
        castillo = new Castillo(this);
        PlazaCentral plazaInicial = new PlazaCentral(this);
        this.mapa = mapa;
        this.oro = Integer.MAX_VALUE;
        this.poblacionActual = 0;
        this.poblacionMaxima = POBLACION_MAXIMA;

        mapa.colocarEstructuraEn(castillo, posicionCastilloHorizontal, posicionCastilloVertical, 4,1);
        mapa.colocarEstructuraEn(plazaInicial, posicionCastilloHorizontal - 2, posicionCastilloVertical, 2, 1);

        for (int i = 0; i < ALDEANOS_INICIALES; i++) {
            Posicion posicion = new Posicion(posicionCastilloHorizontal - 3,posicionCastilloVertical + i);
            this.crearAldeano(plazaInicial, posicion);
        }
        this.oro = ORO_INICIAL - ALDEANOS_INICIALES * ORO_POR_ALDEANO ;
    }

    public void nuevoTurno() {
        for (Accionables accionable : accionables) {
            accionable.realizarAccionCorrespondiente();
        }
        castillo.atacar(mapa);
        movidos.clear();
        atacaron.clear();
    }

    public void finalizarTurno() {
        juego.siguienteTurno();
    }


    public void sumarOro(int unidadesDeOro) {
        this.oro += unidadesDeOro;
    }

    public void construirPlazaCentral(Aldeano aldeano, int x, int y) { // Podria ser asi o que se le pase un indez de array
        if (this.oro < PRECIO_PLAZA) {
            throw new OroInsuficiente();
        }
        PlazaCentral unaPlazaCentral = new PlazaCentral(this);
        Cimiento unCimiento = new Cimiento(unaPlazaCentral, this.mapa, x, y, 2);
        int signo = aldeano.comenzarCimientos(unCimiento, this);
        mapa.colocarEstructuraEn(unCimiento , x, y, 2 , signo);
        this.restarOro(PRECIO_PLAZA);
    }

    public void crearAldeano(PlazaCentral unaPlazaCentral, Posicion posicion){
        Aldeano unAldeano = unaPlazaCentral.crearAldeano(oro, this, posicion);
        mapa.colocarUnidadEn(unAldeano, posicion);
    }

    public void crearEspadachin(Cuartel unCuartel, Posicion posicion){
        Espadachin espadachin = unCuartel.crearEspadachin(oro, this, posicion);
        mapa.colocarUnidadEn(espadachin, posicion);
    }

    public void crearArquero(Cuartel unCuartel, Posicion posicion){
        Arquero arquero = unCuartel.crearArquero(oro, this, posicion);
        mapa.colocarUnidadEn(arquero, posicion);
    }


    public void crearArmaDeAsedio(Posicion posicion, Castillo unCastillo) {
        ArmaDeAsedio armaDeAsedio = unCastillo.crearArmaDeAsedio(this.oro, this, posicion);
        mapa.colocarUnidadEn(armaDeAsedio, posicion);

    }

    public void construirCuartel(Aldeano aldeano, int x, int y) {
        if (this.oro < PRECIO_CUARTEL) {
            throw new OroInsuficiente();
        }
        Cuartel unCuartel = new Cuartel(this);
        Cimiento unCimiento = new Cimiento(unCuartel, this.mapa, x, y, 2);
        int signo = aldeano.comenzarCimientos(unCimiento,this);
        mapa.colocarEstructuraEn(unCimiento , x, y, 2 , signo);
        this.restarOro(PRECIO_CUARTEL);
    }


    public void repararEstructura(Aldeano unAldeano, Estructura unaEstructura) {
        unAldeano.comenzarReparacion(unaEstructura, this);
    }

    public int getOro() {
        return this.oro;
    }

    public void disminuirPoblacion() {
        if (poblacionActual > 0)
            this.poblacionActual--;
    }

    public void aumentarPoblacion() {
        if (poblacionActual == poblacionMaxima)
            throw new PoblacionLimiteAlcanzada();
        this.poblacionActual++;
    }

    public void borrarUnidad(Posicion posicion) {
        this.disminuirPoblacion();
        mapa.liberarUbicacion(posicion);
    }

    public void borrarEstructura(LinkedList<Posicion> posiciones) {
        this.disminuirPoblacion();
        mapa.liberarUbicaciones(posiciones);
    }

    public void restarOro(int cantOro) {
        oro -= cantOro;
    }


    public int getPoblacionActual() {
        return this.poblacionActual;
    }

    public void movio(UnidadMovil unidad) {
        movidos.add(unidad);
    }

    public void atacar(Atacante unidad) {
        atacaron.add(unidad);
    }

    public void accionableMuerto(Accionables unAccionable) {
        accionables.remove(unAccionable);
    }


    public void agregarAccionable(Accionables unAccionable){
        accionables.add(unAccionable);
    }


    public void agregarAtacante(Atacante unAtacante){
        atacaron.add(unAtacante);
    }

    public void perdedor() {
        juego.perdedor();
    }

    public boolean movioUnidad(UnidadMovil unaUnidadMovil) {
        return movidos.contains((unaUnidadMovil));
    }

    public boolean ataco(Atacante unAtacante) {
        return atacaron.contains(unAtacante);
    }

    public void setNombreJugador(String suNombre){
        this.nombreJugador = suNombre;
    }
    public String getNombre() {
        return nombreJugador;
    }

    public Castillo getCastillo() {
        return castillo;
    }

    public void reanudarCimiento(Cimiento unCimiento, Aldeano unAldeano){
        unCimiento.reanudarConstruccion(unAldeano, this);
    }

    public void detenerCimiento(Cimiento unCimiento){
        unCimiento.detenerConstruccion();
    }
}


