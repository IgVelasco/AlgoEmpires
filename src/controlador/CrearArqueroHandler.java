package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.espacio.Posicion;
import modelo.estructuras.Cuartel;
import modelo.unidades.Arquero;
import vista.JuegoVista;
import vista.MapaView;

public class CrearArqueroHandler implements EventHandler<ActionEvent> {
    Cuartel cuartel;

    public CrearArqueroHandler(Cuartel unCuartel) {
        cuartel = unCuartel;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();

        mapaView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                crearArquero(mapaView);
                mapaView.setOnMouseClicked(null);
            }
        });
    }

    public void crearArquero(MapaView mapaView) {
        Posicion destino = mapaView.getDestino();
        System.out.println(destino.getPosX());
        Arquero unArquero = cuartel.crearArquero(1000);
        mapaView.getMapa().colocarUnidadEn(unArquero, destino.getPosX(), destino.getPosY());
        mapaView = mapaView.iniciar(mapaView.getMapa());
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView);
    }
}
