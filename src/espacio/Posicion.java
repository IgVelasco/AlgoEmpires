package espacio;

import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Math.abs;

public class Posicion {
    ArrayList<Integer> posY = new ArrayList<Integer>();
    ArrayList<Integer> posX = new ArrayList<Integer>();

    public Posicion (int x, int y) {
        posX.add(x);
        posY.add(y);
    }

    public boolean posicionCorrespondiente(int x, int y) {
        Iterator<Integer> iterX = posX.iterator();
        Iterator<Integer> iterY = posY.iterator();
        while (iterX.hasNext()) {
            if (iterX.next() == x && iterY.next() == y) {
                return true;
            }
        }
        return false;
    }

    public int distancia(int x, int y) {
        int distanciaMinima = Integer.MAX_VALUE;
        Iterator<Integer> iterX = posX.iterator();
        Iterator<Integer> iterY = posY.iterator();
        while (iterX.hasNext()) {
            int pX = iterX.next();
            int pY = iterY.next();
            distanciaMinima = min(distanciaMinima, max(abs(x - pX), abs(y - pY)));
        }
        return distanciaMinima;
    }

    public int getPosX() {
        return posX.get(0);
    }

    public int getPosY() {
        return posY.get(0);
    }
}
