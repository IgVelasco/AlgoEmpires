package espacio;

import contenibles.Contenible;

public class Casillero {

    private boolean estaOcupado = false;
    private Contenible contenido;

    public boolean casilleroEstaOcupado() {
        return this.estaOcupado;
    }

    public void contener(Contenible unContenible) {
        contenido = unContenible;
        estaOcupado = true;
    }

    public Contenible getContenido() {
        return this.contenido;
    }
}
