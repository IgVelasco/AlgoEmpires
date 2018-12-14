package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.espacio.Posicion;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;
import vista.JuegoVista;
import vista.MapaView;

public class ConstruirPlazaCentralHandler implements EventHandler<ActionEvent> {
    Aldeano aldeano;
    Jugador aldeanoPropietario;

    public ConstruirPlazaCentralHandler(Aldeano unAldeano) {
        aldeano = unAldeano;
        aldeanoPropietario = unAldeano.getPropietario();
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();

        mapaView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                construirPlaza(mapaView);
                mapaView.setOnMouseClicked(null);
            }
        });
    }

    public void construirPlaza(MapaView mapaView) {
        Posicion destino = mapaView.getDestino();
        System.out.println(destino.getPosX());
        aldeanoPropietario.construirPlazaCentral(aldeano, destino.getPosX(), destino.getPosY());
        mapaView = mapaView.iniciar(mapaView.getMapa());
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView);
    }
}
