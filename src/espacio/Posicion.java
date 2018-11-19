package espacio;

public class Posicion {
    private int posX;
    private int posY;

    public Posicion (int x, int y) {
        posX = x;
        posY = y;
    }

    public boolean posicionCorrespondiente(int x, int y) {
        if(x == posX  && y == posY) {
            return true;
        }
        return false;
    }
}
