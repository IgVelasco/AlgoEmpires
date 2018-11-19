package estados;

import Excepciones.AldeanoOcupado;
import unidades.Aldeano;

public interface Estado {

    void realizarAccion(Aldeano jugador);
    void ocupar() throws AldeanoOcupado;
}
