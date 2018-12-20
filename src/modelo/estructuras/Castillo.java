package modelo.estructuras;

import modelo.espacio.Contenible;
import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.excepciones.ContenibleNoPropia;
import modelo.excepciones.OroInsuficiente;
import modelo.excepciones.PosicionFueraDeRango;
import modelo.juego.Jugador;
import modelo.unidades.ArmaDeAsedio;

import java.util.ArrayList;
import java.util.LinkedList;

public class Castillo extends Estructura {

    private static final int
            PRECIO_ARMA_DE_ASEDIO = 200,
            ALCANCE = 5;

    public Castillo(Jugador jugador) {
        propietario = jugador;
        vida = 1000;
        vidaMaxima = 1000;
        velocidadDeReparacion = 15;
        posiciones = new LinkedList<Posicion>();

    }



    public ArmaDeAsedio crearArmaDeAsedio(int oroDisponible, Jugador unJugador, Posicion unaPosicion) {
        if (! sonDelMismoJugador(unJugador)) {
            throw new ContenibleNoPropia();
        }
        if (oroDisponible < PRECIO_ARMA_DE_ASEDIO) {
            throw new OroInsuficiente();
        }
        if (calcularDistancia(unaPosicion.getPosX(),unaPosicion.getPosY())>1)
            throw new PosicionFueraDeRango();
        propietario.restarOro(PRECIO_ARMA_DE_ASEDIO);
        this.propietario.aumentarPoblacion();
        ArmaDeAsedio  armaDeAsedio = new ArmaDeAsedio(propietario, unaPosicion);
        propietario.agregarAccionable(armaDeAsedio);
        return armaDeAsedio;
    }

    public void atacar(Mapa mapa) {
        LinkedList<Contenible> atacables =  mapa.getConteniblesEnRango(posiciones, ALCANCE);

        while (atacables.contains(this)){ //Saco al castillo de los atacables
            atacables.remove(this);
        }

        ArrayList<Contenible> yaAtacados = new ArrayList<>();

        for (Contenible atacable : atacables) {
            if (atacable.sonDelMismoJugador(this.propietario) || yaAtacados.contains(atacable))
                continue;
            atacable.ataqueDeCastillo();
            yaAtacados.add(atacable);
        }
    }

    public void borrarEstructura() {
        propietario.borrarEstructura(posiciones);
        propietario.perdedor();
    }
}
