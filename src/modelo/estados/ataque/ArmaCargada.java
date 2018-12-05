package modelo.estados.ataque;

import modelo.excepciones.ArmaNoCargada;
import modelo.excepciones.ArmaSeCargaEnSiguienteTurno;
import modelo.excepciones.ArmaYaCargada;

public class ArmaCargada implements EstadosAtaque{
    private boolean cargada;

    public ArmaCargada(){
        cargada = false;
    }


    @Override
    public void ataqueListo() {
        if(!cargada)
            throw new ArmaNoCargada();
    }

    @Override
    public void cargarArma() {
        if(cargada)
            throw new ArmaYaCargada();
        throw new ArmaSeCargaEnSiguienteTurno();
    }

    @Override
    public void realizarAccion() {
        cargada = true;
    }

    @Override
    public boolean movible() {
        return false;
    }


}
