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
    public void ocupar() throws AldeanoOcupado {
        throw new AldeanoOcupado();
    }

    @Override
    public void realizarAccion(Aldeano unAldeano) {
        estructura.reparar(unAldeano);
    }
}
