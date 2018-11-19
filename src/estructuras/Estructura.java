package estructuras;
import Excepciones.EdificioConVidaMaxima;
import contenibles.Contenible;
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

    public int distancia(int x, int y) {
        ArrayList<Integer> distancias = new ArrayList<Integer>();
        int distanciaMinima = 20;
        Iterator<Integer> iterX = posX.iterator();
        Iterator<Integer> iterY = posY.iterator();
        while (iterX.hasNext()) {
            int pX = iterX.next();
            int pY = iterY.next();
            distanciaMinima = min(distanciaMinima, max(abs(x - pX),abs(y - pY)));
        }
        return distanciaMinima;
    }


}

