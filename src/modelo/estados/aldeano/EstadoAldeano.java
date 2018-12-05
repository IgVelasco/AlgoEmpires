package modelo.estados.aldeano;

import modelo.excepciones.AldeanoOcupado;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.ExcedeLimiteDelMapa;
import modelo.unidades.Aldeano;

public interface EstadoAldeano {

    void realizarAccion(Aldeano unAldeano);

    void ocupar() throws AldeanoOcupado;
}
