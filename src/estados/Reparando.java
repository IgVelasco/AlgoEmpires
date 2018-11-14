package estados;

import estructuras.Estructura;
import unidades.Aldeano;

public class Reparando implements Estado {

    public Estructura estructura;

    public Reparando(Estructura unaEstructura) {
        this.estructura = unaEstructura;
    }

    @Override
    public  void realizarAccionPasiva(Aldeano unAldeano) {
        estructura.reparar(unAldeano);
    }
}
