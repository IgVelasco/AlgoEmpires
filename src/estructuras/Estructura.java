package estructuras;
import Excepciones.EdificioConVidaMaxima;
import contenibles.Contenible;
import unidades.Aldeano;

public abstract class Estructura implements Contenible {
    int vida;
    int vidaMaxima;
    int velocidadDeReparacion;

    public void reparar(Aldeano unAldeano) {
        if (vida + velocidadDeReparacion > vidaMaxima) {
            vida = vidaMaxima;
            unAldeano.finalizarReparacion(this);
            return;
        }
        vida += velocidadDeReparacion;
    }

    public int getVida() {
        return vida;
    }

    public void ataqueDeEspadachin() {
        int dañoDeEspadachin = 25;
        vida = vida - dañoDeEspadachin;
    }

    ;

    public void reparar() throws EdificioConVidaMaxima { //TODO esto tendria que ser un estado
        if (vida == vidaMaxima)
            throw new EdificioConVidaMaxima();

    }
}
