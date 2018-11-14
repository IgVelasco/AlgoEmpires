package estados;

import estructuras.Estructura;
import juego.Jugador;

public class Construyendo implements Estado {
    private int cantTurnos = 0;
    private int maxTurnos = 3;
    public Estructura estructura;

    public Construyendo(Estructura estruct) {
        estructura = estruct;
    }

    @Override
    public  void realizarAccionPasiva(Jugador jugador) {
        cantTurnos ++;
        if (cantTurnos == maxTurnos) {
            jugador.finalizarConstruccion(estructura);
        }
    }

}
