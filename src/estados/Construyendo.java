package estados;

import Excepciones.AldeanoOcupado;
import Excepciones.CasilleroOcupado;
import Excepciones.CimientoFinalizado;
import Excepciones.ExcedeLimiteDelMapa;
import estructuras.Cimiento;
import unidades.Aldeano;

public class Construyendo implements Estado {
    private Cimiento cimiento;

    public Construyendo(Cimiento cimiento) {

        this.cimiento = cimiento;

    }

    public void ocupar() throws AldeanoOcupado {
        throw new AldeanoOcupado();
    }

    @Override
    public void realizarAccion(Aldeano unAldeano) throws CasilleroOcupado, ExcedeLimiteDelMapa {
            cimiento.avanzarConstruccion(unAldeano);
    }

}
