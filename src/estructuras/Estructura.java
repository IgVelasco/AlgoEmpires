package estructuras;

import unidades.Aldeano;

public abstract class Estructura {
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
}
