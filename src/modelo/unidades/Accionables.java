package modelo.unidades;

import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.ExcedeLimiteDelMapa;

public abstract class Accionables extends UnidadMovil {

    public abstract void realizarAccionCorrespondiente() throws CasilleroOcupado, ExcedeLimiteDelMapa;
    private static final int
            DANO_ARQUERO = 15,
            DANO_ESPADACHIN = 25,
            DANO_CASTILLO = 20;


    public void recibirAtaque(int dano) throws ExcedeLimiteDelMapa {
        this.vida -= dano;
        if (this.vida <= 0)
            matar();
    }

    public void ataqueDeEspadachin() throws ExcedeLimiteDelMapa {
        recibirAtaque(DANO_ESPADACHIN);
    }

    public void ataqueDeArquero() throws ExcedeLimiteDelMapa {
        recibirAtaque(DANO_ARQUERO);
    }

    public void ataqueDeCastillo() throws ExcedeLimiteDelMapa {
        recibirAtaque(DANO_CASTILLO);
    }

    private void matar() throws ExcedeLimiteDelMapa {
        propietario.accionableMuerto(this);
        propietario.borrarUnidad(posicion);

    }

}
