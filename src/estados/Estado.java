package estados;

import Excepciones.AldeanoOcupado;
import unidades.Aldeano;

public interface Estado {

    void realizarAccion(Aldeano unAldeano);

    void ocupar() throws AldeanoOcupado;
}
