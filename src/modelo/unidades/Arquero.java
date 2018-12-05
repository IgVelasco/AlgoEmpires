package modelo.unidades;


import modelo.espacio.Contenible;
import modelo.excepciones.*;
import modelo.juego.Jugador;

public class Arquero extends Infanteria implements Atacante{

    public Arquero(Jugador unJugador) {
        vida = 75;
        propietario = unJugador;
    }

    public int getVida() {
        return this.vida;
    }


    public void atacar(Contenible unContenible, Jugador unJugador) throws ContenibleFueraDeRango, ContenibleDelMismoJugador, ExcedeLimiteDelMapa, ContenibleNoPropia, UnidadYaAtaco {
        super.atacar(unContenible, unJugador);
        unContenible.ataqueDeArquero();
    }

}
