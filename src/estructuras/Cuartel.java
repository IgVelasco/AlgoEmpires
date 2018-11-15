package estructuras;

import Excepciones.OroInsuficiente;
import contenibles.Contenible;
import unidades.Arquero;
import unidades.Espadachin;

public class Cuartel extends Estructura {

    private int precioEspadachin = 50;
    private int precioArquero = 75;

    public Cuartel() {
        vida = 250;
        vidaMaxima = 250;
        velocidadDeReparacion = 50;
    }

    public Espadachin crearEspadachin(int oroDisponible) throws OroInsuficiente {
        if(oroDisponible < precioEspadachin ) throw new OroInsuficiente();

        return new Espadachin();
    }

    public Arquero crearArquero(int oroDisponible) throws OroInsuficiente {
        if(oroDisponible < precioArquero) throw new OroInsuficiente();
        return new Arquero();
    }


}
