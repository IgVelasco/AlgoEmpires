package estados;

import estructuras.Estructura;
import unidades.Aldeano;

public class Reparando implements Ocupado {

    public Estructura estructura;

    public Reparando(Estructura unaEstructura) {
        this.estructura = unaEstructura;
    }

    @Override
    public  void realizarAccionPasiva(Aldeano unAldeano) {
        estructura.reparar(unAldeano);
    }
}
