package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.espacio.Posicion;
import modelo.estructuras.Castillo;
import modelo.unidades.ArmaDeAsedio;
import vista.JuegoVista;
import vista.MapaView;

public class CrearArmaDeAsedioHandler implements EventHandler<ActionEvent> {
    Castillo castillo;

    public CrearArmaDeAsedioHandler(Castillo unCastillo) {
        castillo = unCastillo;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();

        mapaView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                crearArma(mapaView);
                mapaView.setOnMouseClicked(null);
            }
        });
    }

    public void crearArma(MapaView mapaView) {
        Posicion destino = mapaView.getDestino();
        System.out.println(destino.getPosX());
        ArmaDeAsedio unArma = castillo.crearArmaDeAsedio(1000);
        mapaView.getMapa().colocarUnidadEn(unArma, destino.getPosX(), destino.getPosY());
        mapaView = mapaView.iniciar(mapaView.getMapa());
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView);
    }
}
