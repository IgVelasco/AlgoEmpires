package modelo.espacio;

import java.util.ArrayList;
import java.util.Collection;

import static java.lang.Integer.max;
import static java.lang.Math.abs;

public class Posicion {
    int posX;
    int posY;

    public Posicion(int x, int y) {
        posX = x;
        posY = y;
    }

    //Pasar posicion ?
    public boolean posicionCorrespondiente(int x, int y) {
        return (posX == x && posY == y);
    }

    public int distancia(int x, int y) {
        return max(abs(x - posX), abs(y - posY));
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Collection<Posicion> getPosicionesEnAlcance(int alcance, Mapa mapa) {
        Collection<Posicion> posiciones = new ArrayList<>();

        for(Posicion otraPosicion: mapa.getAllPosiciones()){
            if (this.distancia(otraPosicion.getPosX(), otraPosicion.getPosY()) <= alcance){
                posiciones.add(otraPosicion);
            }

        }
        return posiciones;
    }
}