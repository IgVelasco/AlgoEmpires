package estados;

import estructuras.Estructura;
import unidades.Aldeano;

public class Reparando implements Estado {

    private int cantTurnos = 0;
    private int maxTurnos = 3;
    public Estructura estructura;

    public Reparando(Estructura unaEstructura) {
        this.estructura = unaEstructura;
    }

    @Override
    public  void realizarAccionPasiva(Aldeano unAldeano) {
        cantTurnos ++;
        if (cantTurnos == maxTurnos) {
            unAldeano.finalizarReparacion(estructura);
        }
    }
}
