package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.espacio.Posicion;
import modelo.estructuras.PlazaCentral;
import modelo.juego.Juego;
import vista.JuegoVista;
import vista.MapaView;

public class CrearAldeanoHandler extends AccionSobreCasilla implements EventHandler<ActionEvent> {
    PlazaCentral plazaCentral;
    Juego juego;

    public CrearAldeanoHandler(PlazaCentral unaPlazaCentral, Juego unJuego) {
        plazaCentral = unaPlazaCentral;
        juego = unJuego;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        mapaView.setAccionSobreCasilla(this);
    }

    public void realizarAccion(MapaView mapaView, Posicion posicion) {
        juego.getJugadorActual().crearAldeano(plazaCentral, posicion);
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView.getJuego());
    }

}
