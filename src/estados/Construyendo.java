package estados;

import estructuras.Estructura;
import juego.Jugador;
import unidades.Aldeano;

public class Construyendo implements Ocupado {
    private int cantTurnos = 0;
    private int maxTurnos = 3;
    public Estructura estructura;

    public Construyendo(Estructura estruct) {
        estructura = estruct;
    }

    @Override
    public  void realizarAccionPasiva(Aldeano unAldeano) {
        cantTurnos ++;
        if (cantTurnos == maxTurnos) {
            unAldeano.finalizarConstruccion(estructura);
        }
    }

}
