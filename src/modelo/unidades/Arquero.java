package modelo.unidades;


import modelo.espacio.Contenible;
import modelo.excepciones.ContenibleDelMismoJugador;
import modelo.excepciones.ContenibleFueraDeRango;
import modelo.excepciones.ExcedeLimiteDelMapa;
import modelo.juego.Jugador;

public class Arquero extends UnidadMovil implements Atacante{

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
