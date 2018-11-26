package estados;

import Excepciones.AldeanoOcupado;
import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import unidades.Aldeano;

public interface Estado {

    void realizarAccion(Aldeano unAldeano) throws CasilleroOcupado, ExcedeLimiteDelMapa;

    void ocupar() throws AldeanoOcupado;
}
