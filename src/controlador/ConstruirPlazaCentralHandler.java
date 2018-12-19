package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.espacio.Posicion;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;
import vista.JuegoVista;
import vista.MapaView;

public class ConstruirPlazaCentralHandler implements EventHandler<ActionEvent>, AccionSobreCasilla {
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

    public void realizarAccion(MapaView mapaView) {
        Posicion destino = mapaView.getDestino();
        System.out.println(destino.getPosX());
        juego.getJugadorActual().construirPlazaCentral(aldeano, destino.getPosX(), destino.getPosY());
        mapaView = mapaView.iniciar(mapaView.getMapa());
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView.getJuego());
    }
}
