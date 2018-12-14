package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.estructuras.PlazaCentral;
import modelo.unidades.Aldeano;
import vista.JuegoVista;
import vista.MapaView;

public class CrearAldeanoHandler implements EventHandler<ActionEvent> {
    PlazaCentral plazaCentral;

    public CrearAldeanoHandler(PlazaCentral unaPlazaCentral) {
        plazaCentral = unaPlazaCentral;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();

        mapaView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                crearAldeano(mapaView);
                mapaView.setOnMouseClicked(null);
            }
        });
    }

    public void crearAldeano(MapaView mapaView) {
        Posicion destino = mapaView.getDestino();
        System.out.println(destino.getPosX());
        Aldeano unAldeano = plazaCentral.crearAldeano(1000);
        mapaView.getMapa().colocarUnidadEn(unAldeano, destino.getPosX(), destino.getPosY());
        mapaView = mapaView.iniciar(mapaView.getMapa());
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView);
    }

}
