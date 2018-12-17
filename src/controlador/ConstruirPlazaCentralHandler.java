package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.espacio.Posicion;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;
import vista.JuegoVista;
import vista.MapaView;

public class ConstruirPlazaCentralHandler implements EventHandler<ActionEvent>, AccionSobreCasilla {
    Aldeano aldeano;
    Jugador aldeanoPropietario;

    public ConstruirPlazaCentralHandler(Aldeano unAldeano) {
        aldeano = unAldeano;
        aldeanoPropietario = unAldeano.getPropietario();
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        mapaView.setAccionSobreCasilla(this);
    }

    public void realizarAccion(MapaView mapaView) {
        Posicion destino = mapaView.getDestino();
        System.out.println(destino.getPosX());
        aldeanoPropietario.construirPlazaCentral(aldeano, destino.getPosX(), destino.getPosY());
        mapaView = mapaView.iniciar(mapaView.getMapa());
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView);
    }
}
