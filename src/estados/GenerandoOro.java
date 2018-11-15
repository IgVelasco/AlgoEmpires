package estados;

import unidades.Aldeano;

public class GenerandoOro implements Estado {

    @Override
    public void realizarAccionPasiva(Aldeano unAldeano) {
        unAldeano.recolectarOro(20);
    }

    public void estaOcupado(){
    }
}
