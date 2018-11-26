package modelo.estados.aldeano;

import modelo.estructuras.Cimiento;
import modelo.excepciones.AldeanoOcupado;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.ExcedeLimiteDelMapa;
import modelo.unidades.Aldeano;

public class Construyendo implements EstadoAldeano {
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
