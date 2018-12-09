package modelo.unidades;

public abstract class Accionables extends UnidadMovil {

    public abstract void realizarAccionCorrespondiente();
    private static final int
            DANO_ARQUERO = 15,
            DANO_ESPADACHIN = 25,
            DANO_CASTILLO = 20;


    public void recibirAtaque(int dano) {
        this.vida -= dano;
        if (this.vida <= 0)
            matar();
    }

    public void ataqueDeEspadachin() {
        recibirAtaque(DANO_ESPADACHIN);
    }

    public void ataqueDeArquero() {
        recibirAtaque(DANO_ARQUERO);
    }

    public void ataqueDeCastillo() {
        recibirAtaque(DANO_CASTILLO);
    }

    private void matar() {
        propietario.accionableMuerto(this);
        propietario.borrarUnidad(posicion);

    }

}
