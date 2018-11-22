package contenibles;

import Excepciones.AsedioNoAtacaUnidad;
import Excepciones.ExcedeLimiteDelMapa;
import juego.Jugador;

public interface Contenible {
    void ataqueDeEspadachin() throws ExcedeLimiteDelMapa;

    void ataqueDeArquero() throws ExcedeLimiteDelMapa;

    int calcularDistancia(int x, int y);

    boolean sonDelMismoJugador(Jugador propietario);

    void ataqueDeCastillo() throws ExcedeLimiteDelMapa;

    void ataqueDeAsedio() throws AsedioNoAtacaUnidad;
}