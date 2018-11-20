package estructuras;
import Excepciones.EdificioConVidaMaxima;
import contenibles.Contenible;
import espacio.Posicion;
import juego.Jugador;
import unidades.Aldeano;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.Integer.min;
import static java.lang.Math.abs;
import static java.lang.Math.max;

public abstract class Estructura implements Contenible {

    ArrayList<Integer> posY = new ArrayList<Integer>();
    ArrayList<Integer> posX = new ArrayList<Integer>();
    int vida;
    int vidaMaxima;
    int velocidadDeReparacion;
    Jugador propietario;
    Posicion posicion;


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


    public void ponerAReparar() throws EdificioConVidaMaxima { //TODO esto tendria que ser un estado
        if (vida == vidaMaxima)
            throw new EdificioConVidaMaxima();
    }

    public int calcularDistancia(int x, int y) {
        return posicion.distancia(x, y);

    }
}

