package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.espacio.Posicion;
import modelo.excepciones.PosicionFueraDeRango;
import modelo.juego.Juego;
import modelo.unidades.Aldeano;
import vista.JuegoVista;
import vista.MapaView;

public class ConstruirPlazaCentralHandler extends AccionSobreCasilla implements EventHandler<ActionEvent> {
    Aldeano aldeano;
    Juego juego;

    public ConstruirPlazaCentralHandler(Aldeano unAldeano, Juego unJuego) {
        aldeano = unAldeano;
        juego = unJuego;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        mapaView.setAccionSobreCasilla(this);
    }

    public void realizarAccion(MapaView mapaView, Posicion posicion) {
        try {
            juego.getJugadorActual().construirPlazaCentral(aldeano, posicion.getPosX(), posicion.getPosY());
        } catch (PosicionFueraDeRango e){
            alertar("Posición fuera de rango de construcción!");
        }
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView.getJuego());
    }
}
