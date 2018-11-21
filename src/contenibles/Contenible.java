package contenibles;

import juego.Jugador;

public interface Contenible {
    void ataqueDeEspadachin();

    void ataqueDeArquero();

    int calcularDistancia(int x, int y);

    boolean sonDelMismoJugador(Jugador propietario);

    void ataqueDeCastillo();
}