package estados;

import Excepciones.AldeanoOcupado;
import estructuras.Estructura;
import unidades.Aldeano;

public class Construyendo implements Estado {
    private int cantTurnos = 0;
    private int maxTurnos = 3;
    public Estructura estructura;

    public Construyendo(Estructura estruct) {
        estructura = estruct;
    }

    public void ocupar() throws AldeanoOcupado {
        throw new AldeanoOcupado();
    }

    @Override
    public  void realizarAccion(Aldeano unAldeano) {
        cantTurnos ++;
        if (cantTurnos == maxTurnos) {
            unAldeano.liberarAldeano();
        }
    }

}
