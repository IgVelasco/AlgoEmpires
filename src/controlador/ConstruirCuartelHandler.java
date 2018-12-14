package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.espacio.Posicion;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;
import vista.JuegoVista;
import vista.MapaView;

public class ConstruirCuartelHandler implements EventHandler<ActionEvent> {
    Aldeano aldeano;
    Jugador aldeanoPropietario;

    public ConstruirCuartelHandler(Aldeano unAldeano) {
        aldeano = unAldeano;
        aldeanoPropietario = unAldeano.getPropietario();
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();

        mapaView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                crearCuartel(mapaView);
                mapaView.setOnMouseClicked(null);
            }
        });
    }

    public void crearCuartel(MapaView mapaView) {
        Posicion destino = mapaView.getDestino();
        System.out.println(destino.getPosX());
        aldeanoPropietario.construirCuartel(aldeano, destino.getPosX(), destino.getPosY());
        mapaView = mapaView.iniciar(mapaView.getMapa());
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView);
    }
}
