package estadosAldeano;

import Excepciones.AldeanoOcupado;
import unidades.Aldeano;

public interface EstadoAldeano {

    void realizarAccion(Aldeano unAldeano);

    void ocupar() throws AldeanoOcupado;
}
