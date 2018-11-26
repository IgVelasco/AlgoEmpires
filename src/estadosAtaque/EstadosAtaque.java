package estadosAtaque;

import Excepciones.ArmaSeCargaEnSiguienteTurno;
import Excepciones.ArmaYaCargada;
import Excepciones.ArmaNoCargada;


public interface EstadosAtaque {
    void ataqueListo() throws ArmaNoCargada;
    void cargarArma() throws ArmaYaCargada, ArmaSeCargaEnSiguienteTurno;

    void realizarAccion();
}
