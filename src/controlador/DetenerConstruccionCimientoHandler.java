package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.espacio.Posicion;
import modelo.estructuras.Cimiento;
import modelo.juego.Juego;
import vista.JuegoVista;
import vista.MapaView;

public class DetenerConstruccionCimientoHandler extends AccionSobreCasilla implements EventHandler<ActionEvent> {

    Cimiento cimiento;
    Juego unJuego;

    public DetenerConstruccionCimientoHandler(Cimiento cimiento, Juego juego){
        this.cimiento = cimiento;
        this.unJuego = juego;
    }


    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        realizarAccion(mapaView,null);
    }

    @Override
    public void realizarAccion(MapaView mapaView, Posicion posicion) {

        unJuego.getJugadorActual().detenerCimiento(this.cimiento);

        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView.getJuego());
    }
}
