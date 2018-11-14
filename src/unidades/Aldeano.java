package unidades;

import estados.Construyendo;
import estados.Estado;
import estados.GenerandoOro;
import estados.Reparando;
import estructuras.Estructura;
import juego.Jugador;

public class Aldeano extends UnidadMovil {

    private int vida = 50;
    private Estado estado = new GenerandoOro();
    public Jugador propietario;

    public Aldeano(Jugador jugador) {
        propietario = jugador;
    }

    public int getVida() {
        return this.vida;
    }

    public void realizarAccionCorrespondiente() {
        this.estado.realizarAccionPasiva(this);
    }

    public void comenzarConstruccion(Estructura estructura) {
        this.estado = new Construyendo(estructura);
    }
    public void finalizarConstruccion(Estructura unaEstructura){
        //Estaado Estructura
        this.liberarAldeano();
    }


    public void comenzarReparacion(Estructura unaEstructura){
        estado = new Reparando(unaEstructura);
    }

    public void finalizarReparacion(Estructura unaEstructura) {
       //Estructura estados falta
        this.liberarAldeano();
    }


    private void liberarAldeano() {
        this.estado = new GenerandoOro();
    }

    public void recolectarOro(int oro) {
        this.propietario.sumarOro(oro);
    }
}