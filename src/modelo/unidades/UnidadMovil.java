package modelo.unidades;

import modelo.espacio.Contenible;
import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.excepciones.AsedioNoAtacaUnidad;
import modelo.excepciones.ContenibleNoPropia;
import modelo.excepciones.MovimientoFueraDeRango;
import modelo.excepciones.UnidadYaUtilizada;
import modelo.juego.Jugador;


public abstract class UnidadMovil implements Contenible {

    private static final int
            DANO_ARQUERO = 15,
            DANO_ESPADACHIN = 25,
            DANO_CASTILLO = 20;
    public int vida;
    Posicion posicion;
    public Jugador propietario;


    public Jugador getPropietario() {
        return propietario;
    }

    public boolean sonDelMismoJugador(Jugador unPropietario) {
        return (unPropietario == this.propietario);
    }


    public void recibirAtaque(int dano) {
        this.vida -= dano;
        if (this.vida <= 0)
            propietario.borrarUnidad(posicion);
    }

    public void ataqueDeEspadachin() {
        recibirAtaque(DANO_ESPADACHIN);
    }

    public void ataqueDeArquero() {
        recibirAtaque(DANO_ARQUERO);
    }

    public void ataqueDeCastillo() {
        recibirAtaque(DANO_CASTILLO);
    }

    public void ataqueDeAsedio() {
        throw new AsedioNoAtacaUnidad();
    }


    public void realizarMovimiento(Mapa mapa, int x, int y, Jugador unJugador) {
        if(!this.sonDelMismoJugador(unJugador))
            throw new ContenibleNoPropia();
        if(propietario.movioUnidad(this))
            throw new UnidadYaUtilizada();
        if (this.calcularDistancia( x, y) != 1)
            throw new MovimientoFueraDeRango();
        mapa.mover(this.posicion.getPosX(), this.posicion.getPosY(), x, y);
        propietario.movio(this);
    }

    public int calcularDistancia(int x, int y) {
        return posicion.distancia(x, y);
    }

    public void setPosicion(Posicion pos) {
        posicion = pos;
    }

    public  Posicion getPosicion(){
        return posicion;
    }
}
