package estructuras;
import Excepciones.EdificioConVidaMaxima;
import contenibles.Contenible;
import unidades.Aldeano;

public abstract class Estructura implements Contenible {
    int posY;
    int posX;
    int vida;
    int vidaMaxima;
    int velocidadDeReparacion;

    public void reparar(Aldeano unAldeano) {
        if (vida + velocidadDeReparacion > vidaMaxima) {
            vida = vidaMaxima;
            unAldeano.liberarAldeano();
            return;
        }
        vida += velocidadDeReparacion;
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
}
