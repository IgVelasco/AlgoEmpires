package estadosAtaque;

import Excepciones.ArmaSeCargaEnSiguienteTurno;
import Excepciones.ArmaYaCargada;
import Excepciones.ArmaNoCargada;

public class ArmaCargada implements EstadosAtaque{
    private boolean cargada;

    public ArmaCargada(){
        cargada = false;
    }


    @Override
    public void ataqueListo() throws ArmaNoCargada {
        if(!cargada)
            throw new ArmaNoCargada();
    }

    @Override
    public void cargarArma() throws ArmaYaCargada, ArmaSeCargaEnSiguienteTurno {
        if(cargada)
            throw new ArmaYaCargada();
        throw new ArmaSeCargaEnSiguienteTurno();
    }

    @Override
    public void realizarAccion() {
        cargada = true;
    }


}
