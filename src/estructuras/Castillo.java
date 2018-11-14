package estructuras;

import Excepciones.OroInsuficiente;
import contenibles.Contenible;
import unidades.ArmaDeAsedio;

public class Castillo implements Contenible {

    private int vida = 1000;
    private int precioArmaDeAsedio = 200;

    public int getVida() {
        return this.vida;
    }

    public ArmaDeAsedio crearArmaDeAsedio(int oroDisponible) throws OroInsuficiente {
        if(oroDisponible < precioArmaDeAsedio) {
            throw new OroInsuficiente();
        }
        return new ArmaDeAsedio();
    }
}
