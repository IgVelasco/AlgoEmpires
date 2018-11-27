package modelo.unidades;

import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.ExcedeLimiteDelMapa;

public abstract class Accionables extends UnidadMovil {

    public abstract void realizarAccionCorrespondiente() throws CasilleroOcupado, ExcedeLimiteDelMapa;
    private static final int
            DANO_ARQUERO = 15,
            DANO_ESPADACHIN = 25,
            DANO_CASTILLO = 20;


    public void ataqueDeEspadachin() throws ExcedeLimiteDelMapa {
        this.vida -= DANO_ESPADACHIN;
        if ( this.vida <= 0 )
            matar();
    }

    public void ataqueDeArquero() throws ExcedeLimiteDelMapa {
        this.vida -= DANO_ARQUERO;
        if ( this.vida <= 0 )
            matar();
    }

    public void ataqueDeCastillo() throws ExcedeLimiteDelMapa {
        vida -= DANO_CASTILLO;
        if ( this.vida <= 0 )
            matar();
    }

    private void matar() throws ExcedeLimiteDelMapa {
        propietario.accionableMuerto(this);
        propietario.borrarUnidad(posicion);

    }

}
