package modelo.unidades;

import modelo.espacio.Contenible;
import modelo.excepciones.ContenibleDelMismoJugador;
import modelo.excepciones.ContenibleFueraDeRango;
import modelo.excepciones.ContenibleNoPropia;
import modelo.excepciones.UnidadYaAtaco;
import modelo.juego.Jugador;

public class Infanteria extends UnidadMovil implements Atacante {

    public void atacar(Contenible unContenible, Jugador unJugador) {
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
