package estructuras;
import Excepciones.EdificioConVidaMaxima;
import contenibles.Contenible;
import juego.Jugador;
import unidades.Aldeano;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public abstract class Estructura implements Contenible {
    int posY;
    int posX;
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

    public boolean sonDelMismoJugador(Jugador unPropietario){
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

    public int distancia(int x, int y){
        return max(abs(x - this.posX), abs(y - posY));
    }

}
