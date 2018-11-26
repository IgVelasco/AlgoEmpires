package modelo.unidades;

import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.ExcedeLimiteDelMapa;

public abstract class Accionables extends UnidadMovil {

    public abstract void realizarAccionCorrespondiente() throws CasilleroOcupado, ExcedeLimiteDelMapa;

}
