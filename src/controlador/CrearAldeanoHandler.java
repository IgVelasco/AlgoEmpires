package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.espacio.Posicion;
import modelo.estructuras.PlazaCentral;
import modelo.juego.Juego;
import modelo.unidades.Aldeano;
import vista.JuegoVista;
import vista.MapaView;

public class CrearAldeanoHandler implements EventHandler<ActionEvent>, AccionSobreCasilla {
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

    public void realizarAccion(MapaView mapaView) {
        Posicion destino = mapaView.getDestino();
        System.out.println(destino.getPosX());
        Aldeano unAldeano = plazaCentral.crearAldeano(plazaCentral.getPropietario().getOro(), juego.getJugadorActual());
        mapaView.getMapa().colocarUnidadEn(unAldeano, destino.getPosX(), destino.getPosY());
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView.getJuego());
    }

}
