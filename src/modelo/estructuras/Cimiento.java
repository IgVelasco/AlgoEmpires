package modelo.estructuras;

import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.excepciones.ContenibleNoPropia;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;

import java.util.LinkedList;

public class Cimiento extends Estructura {

    private Estructura estructuraCorrespondiente;
    private int turnosRestantes = 3;
    private Mapa mapa;
    private int posX;
    private int posY;
    private int dimensionCimiento;
    private int signo;
    private Aldeano constructor;
    private boolean construccionDetenida = false;

    public Cimiento(Estructura unaEstructura, Mapa elMapa, int x, int y, int dimension) {

        estructuraCorrespondiente = unaEstructura;
        posiciones = new LinkedList<Posicion>();
        mapa = elMapa;
        posX = x;
        posY = y;
        dimensionCimiento = dimension;
        posiciones.add(new Posicion(x,y));
        propietario = unaEstructura.getPropietario();
    }

    public int getTurnosRestantes() {
        return turnosRestantes;
    }

    public void avanzarConstruccion(){
        if(construccionDetenida){
            return;
        }
        turnosRestantes--;
        if (turnosRestantes == 0){
            mapa.liberarUbicaciones(posiciones);
            mapa.colocarEstructuraEn(estructuraCorrespondiente, posX, posY, dimensionCimiento, signo);
            constructor.liberarAldeano();
        }

    }

    public int distanciaMenores(int posX, int posY) {
        signo = posiciones.getFirst().posicionesMayores(posX,posY);
        return signo;
    }

    public Estructura getFuturaEstructura(){
        return estructuraCorrespondiente;
    }

    @Override
    public void recibirAtaque(int dano) {
        constructor.liberarAldeano();
        this.propietario.borrarEstructura(posiciones);
    }

    public void setConstructor(Aldeano aldeano){
        constructor = aldeano;
    }

    public void detenerConstruccion(){
        this.construccionDetenida = true;
        constructor.liberarAldeano();

    }

    public void reanudarConstruccion(Aldeano unAldeano, Jugador jugadorActual) {
        if(jugadorActual != this.propietario){
            throw new ContenibleNoPropia();
        }
        unAldeano.comenzarCimientos(this, this.propietario);
        construccionDetenida = false;
    }
}
