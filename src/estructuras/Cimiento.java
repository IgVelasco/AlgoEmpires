package estructuras;

import Excepciones.CimientoFinalizado;
import Excepciones.CimientoNoFinalizado;
import contenibles.Contenible;
import espacio.Posicion;

public class Cimiento extends Estructura{

    private Estructura estructuraCorrespondiente;
    private int turnosRestantes = 3;

    public Cimiento(Estructura unaEstructura) {

        estructuraCorrespondiente = unaEstructura;

    }

    public int getTurnosRestantes() {
        return turnosRestantes;
    }

    public void avanzarConstruccion() throws CimientoFinalizado {
        if(turnosRestantes == 0) throw new CimientoFinalizado();

        turnosRestantes --;
    }

    public Estructura finalizarConstruccion() throws CimientoNoFinalizado {
        if (turnosRestantes != 0) throw new CimientoNoFinalizado();

        return estructuraCorrespondiente;
    }

    @Override
    public void setPosicion(Posicion posicion) {
         this.posicion = posicion;
    }
}
