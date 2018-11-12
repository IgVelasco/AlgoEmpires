package espacio;

public class Mapa {

    private int cantCeldas;
    Casillero[][] mapa;

    public Mapa(int x, int y) {
        mapa = new Casillero[x][y];

        cantCeldas = x*y;

        for (int i = 0 ; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Casillero casillero = new Casillero();
                mapa[i][j] = casillero;
            }
        }
    }

    public int getCantCeldas() { return this.cantCeldas;}
}
