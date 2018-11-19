package espacio;

import java.util.ArrayList;
import java.util.Iterator;

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
}
