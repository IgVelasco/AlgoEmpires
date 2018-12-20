package modelo.estados.aldeano;

import modelo.estructuras.Cimiento;
import modelo.excepciones.AldeanoOcupado;
import modelo.unidades.Aldeano;

public class Construyendo implements EstadoAldeano {
    private Cimiento cimiento;

    public Construyendo(Cimiento cimiento) {

        this.cimiento = cimiento;

    }

    public void ocupar() {
        throw new AldeanoOcupado();
    }

    @Override
    public void realizarAccion(Aldeano unAldeano) {
            cimiento.avanzarConstruccion();
    }

}
