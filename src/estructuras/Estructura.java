package estructuras;

import Excepciones.EdificioConVidaMaxima;
import contenibles.Contenible;
import espacio.Posicion;
import juego.Jugador;
import unidades.Aldeano;

import java.util.LinkedList;

import static java.lang.Integer.min;

public abstract class Estructura implements Contenible {

    private static final int
            DANO_ARQUERO = 10,
            DANO_ESPADACHIN = 15,
            DANO_CASTILLO = 20;
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
        vida -= DANO_ESPADACHIN;
        //    if ( this.vida <= 0 ) propietario.borrarUnidad(posiciones);

    }

    public void ataqueDeArquero() {
        vida -= DANO_ARQUERO;
        //    if ( this.vida <= 0 ) propietario.borrarUnidad(posiciones);

    }

    public void ataqueDeCastillo() {
        vida -= DANO_CASTILLO;
        //    if ( this.vida <= 0 ) propietario.borrarUnidad(posiciones);

    }

    public void ataqueDeAsedio() {
        vida -= 75;
    //    if ( this.vida <= 0 ) propietario.borrarUnidad(posiciones);

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

    public void agregarPosicion(Posicion posicion) {
        posiciones.add(posicion);
    }


}

