package modelo.estados.ataque;

import modelo.excepciones.ArmaNoCargada;

public class ArmaDescargada implements EstadosAtaque {
    private boolean movible;

    public ArmaDescargada(boolean movible){
        this.movible = movible;
    }

    @Override
    public void ataqueListo() throws ArmaNoCargada {
        throw new ArmaNoCargada();
    }

    @Override
    public void cargarArma()  {
    }

    @Override
    public void realizarAccion() {
        movible = true;
    }

    @Override
    public boolean movible() {
        return movible;
    }
}
