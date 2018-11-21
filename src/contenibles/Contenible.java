package contenibles;

import Excepciones.ExcedeLimiteDelMapa;
import Excepciones.PoblacionNula;
import juego.Jugador;

public interface Contenible {
    void ataqueDeEspadachin() throws ExcedeLimiteDelMapa, PoblacionNula;

    void ataqueDeArquero() throws ExcedeLimiteDelMapa, PoblacionNula;

    int calcularDistancia(int x, int y);

    boolean sonDelMismoJugador(Jugador propietario);

    void ataqueDeCastillo() throws ExcedeLimiteDelMapa, PoblacionNula;
}