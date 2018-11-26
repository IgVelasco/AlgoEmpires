package unidades;


import Excepciones.ContenibleDelMismoJugador;
import Excepciones.ContenibleFueraDeRango;
import Excepciones.ExcedeLimiteDelMapa;
import contenibles.Contenible;
import juego.Jugador;

public class Arquero extends UnidadMovil {

    public Arquero(Jugador unJugador) {
        vida = 75;
        propietario = unJugador;
    }

    public int getVida() {
        return this.vida;
    }


    public void atacar(Contenible unContenible) throws ContenibleFueraDeRango, ContenibleDelMismoJugador, ExcedeLimiteDelMapa {
        if (unContenible.calcularDistancia(this.posicion.getPosX(), this.posicion.getPosY()) > 3)
            throw new ContenibleFueraDeRango();
        if (unContenible.sonDelMismoJugador(this.propietario))
            throw new ContenibleDelMismoJugador();
        unContenible.ataqueDeArquero();
    }


}
