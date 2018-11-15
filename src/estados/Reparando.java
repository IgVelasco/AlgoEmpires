package estados;

import Excepciones.AldeanoOcupado;
import estructuras.Estructura;
import unidades.Aldeano;

public class Reparando implements Estado {

    public Estructura estructura;

    public Reparando(Estructura unaEstructura) {
        this.estructura = unaEstructura;
    }

    @Override
    public void estaOcupado() throws AldeanoOcupado {
        throw new AldeanoOcupado();
    }

    @Override
    public  void realizarAccionPasiva(Aldeano unAldeano) {
        estructura.reparar(unAldeano);
    }
}
