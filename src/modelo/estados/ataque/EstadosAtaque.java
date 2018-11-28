package modelo.estados.ataque;

import modelo.excepciones.ArmaNoCargada;
import modelo.excepciones.ArmaSeCargaEnSiguienteTurno;
import modelo.excepciones.ArmaYaCargada;


public interface EstadosAtaque {
    void ataqueListo() throws ArmaNoCargada;
    void cargarArma() throws ArmaYaCargada, ArmaSeCargaEnSiguienteTurno;

    void realizarAccion();

    boolean movible();
}
