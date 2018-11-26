package estadosAldeano;

import Excepciones.AldeanoOcupado;
import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import unidades.Aldeano;

public interface EstadoAldeano {

    void realizarAccion(Aldeano unAldeano) throws CasilleroOcupado, ExcedeLimiteDelMapa;

    void ocupar() throws AldeanoOcupado;
}
