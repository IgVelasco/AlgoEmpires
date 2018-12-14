package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.estructuras.Cuartel;
import modelo.unidades.Espadachin;
import vista.JuegoVista;
import vista.MapaView;

public class CrearEspadachinHandler implements EventHandler<ActionEvent> {
    Cuartel cuartel;

    public CrearEspadachinHandler(Cuartel unCuartel) {
        cuartel = unCuartel;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();

        mapaView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                crearEspadachin(mapaView);
                mapaView.setOnMouseClicked(null);
            }
        });
    }

    public void crearEspadachin(MapaView mapaView) {
        Posicion destino = mapaView.getDestino();
        System.out.println(destino.getPosX());
        Espadachin unEspadachin = cuartel.crearEspadachin(1000);
        mapaView.getMapa().colocarUnidadEn(unEspadachin, destino.getPosX(), destino.getPosY());
        mapaView = mapaView.iniciar(mapaView.getMapa());
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView);
    }
}
