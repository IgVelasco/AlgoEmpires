package modelo.estructuras;

import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.unidades.Aldeano;

import java.util.LinkedList;

public class Cimiento extends Estructura {

    private Estructura estructuraCorrespondiente;
    private int turnosRestantes = 3;
    private Mapa mapa;
    private int posX;
    private int posY;
    private int dimensionCimiento;

    public Cimiento(Estructura unaEstructura, Mapa elMapa, int x, int y, int dimension) {

        estructuraCorrespondiente = unaEstructura;
        posiciones = new LinkedList<Posicion>();
        mapa = elMapa;
        posX = x;
        posY = y;
        dimensionCimiento = dimension;
        elMapa.colocarEstructuraEn(this , x, y, dimension );

    }

    public int getTurnosRestantes() {
        return turnosRestantes;
    }

    public void avanzarConstruccion(Aldeano aldeano){
        turnosRestantes--;
        if (turnosRestantes == 0){
            mapa.liberarUbicaciones(posiciones);
            mapa.colocarEstructuraEn(estructuraCorrespondiente, posX, posY, dimensionCimiento );
            aldeano.liberarAldeano();
        }

    }
}
