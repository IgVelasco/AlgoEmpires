package unidades;

import Excepciones.CasilleroOcupado;
import Excepciones.ExcedeLimiteDelMapa;

public abstract class Accionables extends UnidadMovil {

    public abstract void realizarAccionCorrespondiente() throws CasilleroOcupado, ExcedeLimiteDelMapa;

}
