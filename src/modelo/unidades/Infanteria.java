package modelo.unidades;

import modelo.espacio.Contenible;
import modelo.excepciones.*;
import modelo.juego.Jugador;

public class Infanteria extends UnidadMovil implements Atacante {

    public void atacar(Contenible unContenible, Jugador unJugador) throws ContenibleNoPropia, UnidadYaAtaco, ContenibleFueraDeRango, ContenibleDelMismoJugador, ExcedeLimiteDelMapa {
        if(!this.sonDelMismoJugador(unJugador))
            throw new ContenibleNoPropia();
        if(unJugador.ataco( this))
            throw new UnidadYaAtaco();
        if (unContenible.calcularDistancia(this.posicion.getPosX(), this.posicion.getPosY()) > 1)
            throw new ContenibleFueraDeRango();
        if (unContenible.sonDelMismoJugador(this.propietario))
            throw new ContenibleDelMismoJugador();
        unJugador.agregarAtacante(this);
    }
}
