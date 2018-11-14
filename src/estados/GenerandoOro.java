package estados;

import contenibles.Contenible;
import juego.Jugador;

public class GenerandoOro implements Estado {

    @Override
    public void realizarAccionPasiva(Jugador jugador) {
        jugador.sumarOro(20);
    }
}
