package unidades;


public class Arquero extends UnidadMovil {

    private int vida = 75;

    public int getVida() {
        return this.vida;
    }

    @Override
    public void setPosicion(int x, int y) {
        this.posX = x;
        this.posY = y;
    }
}
