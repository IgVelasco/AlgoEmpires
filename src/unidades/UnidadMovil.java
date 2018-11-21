package unidades;

import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;
import Excepciones.MovimientoFueraDeRango;
import Excepciones.UnidadYaUtilizada;
import contenibles.Contenible;
import espacio.Mapa;
import espacio.Posicion;
import juego.Jugador;

public abstract class UnidadMovil implements Contenible {

    public int vida;
    Posicion posicion;
    boolean sePuedeMover;
    Jugador propietario;

    public UnidadMovil() {
        sePuedeMover = true;
    }


    /* int posicionHorizontal;
    int posicionVertical;

    public void mover(){

    }
     */

    public boolean sonDelMismoJugador(Jugador unPropietario) {
        return (unPropietario == this.propietario);
    }


    public void ataqueDeEspadachin() {
        int golpeDeEspadachin = 25;
        this.vida -= golpeDeEspadachin;
    }

    public void ataqueDeArquero() {
        int golpeDeArquero = 15;
        this.vida -= golpeDeArquero;
    }

    public void ataqueDeCastillo() {
        int golpeDeCastillo = 20;
        vida -= golpeDeCastillo;
    }

    public void realizarMovimiento(Mapa mapa, int x, int y) throws ExcedeLimiteDelMapa, MovimientoFueraDeRango, UnidadYaUtilizada, CasilleroOcupado {
        if (!sePuedeMover) throw new UnidadYaUtilizada();
        if (this.calcularDistancia(this.posicion.getPosX() + x, this.posicion.getPosY() + y) != 1)
            throw new MovimientoFueraDeRango();
        mapa.mover(this.posicion.getPosX(), this.posicion.getPosY(), x, y);
        sePuedeMover = false;
    }

    public int calcularDistancia(int x, int y) {
        return posicion.distancia(x, y);
    }

    public void setPosicion(Posicion pos) {
        posicion = pos;
    }

    public void permitirMovimiento() {
        sePuedeMover = true;
    }

}
