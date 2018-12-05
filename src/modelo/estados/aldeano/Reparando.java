package modelo.estados.aldeano;

import modelo.estructuras.Estructura;
import modelo.excepciones.AldeanoOcupado;
import modelo.unidades.Aldeano;

public class Reparando implements EstadoAldeano {

    public Estructura estructura;

    public Reparando(Estructura unaEstructura) {
        this.estructura = unaEstructura;
    }

    @Override
    public void ocupar() {
        throw new AldeanoOcupado();
    }

    @Override
    public void realizarAccion(Aldeano unAldeano) {
        estructura.reparar(unAldeano);
    }
}
