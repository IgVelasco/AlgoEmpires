package modelo.juego;

import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.estructuras.*;
import modelo.excepciones.OroInsuficiente;
import modelo.excepciones.PoblacionLimiteAlcanzada;
import modelo.unidades.Accionables;
import modelo.unidades.Aldeano;
import modelo.unidades.Atacante;
import modelo.unidades.UnidadMovil;

import java.util.ArrayList;
import java.util.LinkedList;

public class Jugador {

    private static final int
            PRECIO_PLAZA = 100,
            PRECIO_CUARTEL = 50;

    private Mapa mapa;
    private Juego juego;
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
        this.oro = 100;
        this.poblacionActual = 3;
        this.poblacionMaxima = 50;

        mapa.colocarEstructuraEn(castillo, posicionCastilloHorizontal, posicionCastilloVertical, 4,1);
        mapa.colocarEstructuraEn(plazaInicial, posicionCastilloHorizontal - 2, posicionCastilloVertical, 2, 1);

        for (int i = 0; i < 3; i++) {
            accionables.add(i, new Aldeano(this));
            mapa.colocarUnidadEn(accionables.get(i), posicionCastilloHorizontal - 3, posicionCastilloVertical + i);
        }
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

    /*public void construirAsedio() {
        this.castillo.crearArmaDeAsedio(this.oro);
    }*/

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
        unAldeano.comenzarReparacion(unaEstructura);
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
}


