package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.espacio.Posicion;
import modelo.juego.Juego;
import modelo.unidades.ArmaDeAsedio;
import vista.JuegoVista;
import vista.MapaView;

public class DescargarArmaHandler implements EventHandler<ActionEvent>, AccionSobreCasilla{
    ArmaDeAsedio armaDeAsedio;
    Juego juego;

    public DescargarArmaHandler(ArmaDeAsedio armaDeAsedio, Juego unJuego) {
        this.armaDeAsedio = armaDeAsedio;
        juego = unJuego;

    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        realizarAccion(mapaView);
    }

    @Override
    public void realizarAccion(MapaView mapaView){
        armaDeAsedio.descargarArmaDeAsedio(juego.getJugadorActual());
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(juego);
    }
}