package estructuras;

import Excepciones.CimientoFinalizado;
import Excepciones.CimientoNoFinalizado;
import espacio.Posicion;

import java.util.LinkedList;

public class Cimiento extends Estructura {

    private Estructura estructuraCorrespondiente;
    private int turnosRestantes = 3;

    public Cimiento(Estructura unaEstructura) {

        estructuraCorrespondiente = unaEstructura;
        posiciones = new LinkedList<Posicion>();


    }

    public int getTurnosRestantes() {
        return turnosRestantes;
    }

    public void avanzarConstruccion() throws CimientoFinalizado {
        if (turnosRestantes == 0) throw new CimientoFinalizado();

        turnosRestantes--;
    }

    public Estructura finalizarConstruccion() throws CimientoNoFinalizado {
        if (turnosRestantes != 0) throw new CimientoNoFinalizado();
        return estructuraCorrespondiente;
    }
}