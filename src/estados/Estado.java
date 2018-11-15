package estados;

import Excepciones.AldeanoOcupado;
import unidades.Aldeano;

public interface Estado {

    void realizarAccionPasiva(Aldeano jugador);
    void estaOcupado() throws AldeanoOcupado;
}
