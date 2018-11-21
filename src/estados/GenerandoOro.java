package estados;

import unidades.Aldeano;

public class GenerandoOro implements Estado {

    private static final int ORO_GENERADO = 20;
    @Override
    public void realizarAccion(Aldeano unAldeano) {
        unAldeano.recolectarOro(ORO_GENERADO);
    }

    public void ocupar() {
    }
}
