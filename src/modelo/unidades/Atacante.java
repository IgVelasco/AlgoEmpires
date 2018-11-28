package modelo.unidades;

import modelo.espacio.Contenible;
import modelo.excepciones.*;

public interface Atacante {
    void atacar(Contenible unContenible) throws ContenibleFueraDeRango, ContenibleDelMismoJugador, ExcedeLimiteDelMapa, AsedioNoAtacaUnidad, ArmaNoCargada;
}
