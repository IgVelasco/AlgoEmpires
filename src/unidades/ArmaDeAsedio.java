package unidades;


public class ArmaDeAsedio extends UnidadMovil {

    private int vida = 150;

    public int getVida() {
        return this.vida;
    }

    @Override
    public void setPosicion(int x, int y) {
        this.posX = x;
        this.posY = y;
    }
}