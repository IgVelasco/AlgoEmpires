package unidades;


public class Espadachin extends UnidadMovil {

    private int vida = 100;

    public int getVida() {
        return this.vida;
    }

    @Override
    public void setPosicion(int x, int y) {
        this.posX = x;
        this.posY = y;
    }
}
