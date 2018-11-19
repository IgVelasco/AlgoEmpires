package estructuras;

import Excepciones.OroInsuficiente;
import contenibles.Contenible;
import juego.Jugador;
import unidades.ArmaDeAsedio;

public class Castillo extends Estructura {

    private int precioArmaDeAsedio = 200;

    public Castillo(Jugador jugador) {
        propietario = jugador;
        vida = 1000;
        vidaMaxima = 1000;
        velocidadDeReparacion = 15;
    }

    public ArmaDeAsedio crearArmaDeAsedio(int oroDisponible) throws OroInsuficiente {
        if(oroDisponible < precioArmaDeAsedio) {
            throw new OroInsuficiente();
        }
        return new ArmaDeAsedio(propietario);
    }

    @Override
    public void setPosicion(int x, int y) {
        this.posX.add(x);
        this.posY.add(y);
    }

    public void atacar(Castillo otroCastillo) {

    }
}
