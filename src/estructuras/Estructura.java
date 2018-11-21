package estructuras;
import Excepciones.EdificioConVidaMaxima;
import contenibles.Contenible;
import espacio.Posicion;
import juego.Jugador;
import unidades.Aldeano;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import static java.lang.Integer.min;
import static java.lang.Math.abs;
import static java.lang.Math.max;

public abstract class Estructura implements Contenible {

    int vida;
    int vidaMaxima;
    int velocidadDeReparacion;
    Jugador propietario;
    LinkedList<Posicion> posiciones;


    public void reparar(Aldeano unAldeano) {
        if (vida + velocidadDeReparacion > vidaMaxima) {
            vida = vidaMaxima;
            unAldeano.liberarAldeano();
            return;
        }
        vida += velocidadDeReparacion;
    }

    public boolean sonDelMismoJugador(Jugador unPropietario) {
        return (unPropietario == this.propietario);
    }

    public int getVida() {
        return vida;
    }

    public void ataqueDeEspadachin() {
        int golpeDeEspadachin = 15;
        vida -= golpeDeEspadachin;
    }

    public void ataqueDeArquero() {
        int golpeDeArquero = 10;
        vida -= golpeDeArquero;
    }

    public void ataqueDeCastillo(){
        int golpeDeCastillo = 20;
        vida -= golpeDeCastillo;
    }


    public void ponerAReparar() throws EdificioConVidaMaxima {
        if (vida == vidaMaxima)
            throw new EdificioConVidaMaxima();
    }

    public int calcularDistancia(int x, int y) {
        int distanciaMinima = Integer.MAX_VALUE;
        for (Posicion posicion : posiciones) {
            distanciaMinima = min(distanciaMinima, posicion.distancia(x, y));
        }
        return distanciaMinima;

    }

    public  void agregarPosicion(Posicion posicion){
        posiciones.add(posicion);
    }


}

