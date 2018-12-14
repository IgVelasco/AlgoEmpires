package modelo.espacio;

import modelo.excepciones.CasilleroOcupado;

public class Casillero {

    private boolean estaOcupado = false;
    private Contenible contenido;
    private Posicion posicion;


    public boolean casilleroEstaOcupado() {
        return this.estaOcupado;
    }

    public Casillero(Posicion unaPosicion){
        this.posicion = unaPosicion;
    }


    public void contener(Contenible unContenible) throws CasilleroOcupado {
        if (estaOcupado) throw new CasilleroOcupado();
        contenido = unContenible;
        estaOcupado = true;
    }


    public Contenible getContenido() {
        return this.contenido;
    }

    public void liberar() {
        contenido = null;
        estaOcupado = false;
    }

    public Posicion getPosicion() {
        return posicion;
    }
}
