package contenibles;

import juego.Jugador;

public interface Contenible {
    void setPosicion(int x, int y);
    void ataqueDeEspadachin();
    int distancia(int posX, int posY);

    void ataqueDeArquero();

    boolean sonDelMismoJugador(Jugador propietario);
}