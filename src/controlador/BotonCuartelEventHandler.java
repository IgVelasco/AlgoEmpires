package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import modelo.espacio.Casillero;
import modelo.espacio.Posicion;
import modelo.estructuras.Cuartel;
import modelo.juego.Juego;
import vista.MapaView;

public class BotonCuartelEventHandler implements EventHandler<ActionEvent> {
    Button boton;
    Cuartel cuartel;
    Posicion posicion;

    public BotonCuartelEventHandler(Casillero unCasillero, Button unBoton, Juego unJuego) {
        cuartel = (Cuartel) unCasillero.getContenido();
        boton = unBoton;
        posicion =  unCasillero.getPosicion();
        ContextMenu contextMenu = new ContextMenu();

        MenuItem crearArquero = new MenuItem("Crear arquero");
        MenuItem crearEspadachin = new MenuItem("Crear espadachin");

        crearArquero.setOnAction(new CrearArqueroHandler(this.cuartel, unJuego));
        crearEspadachin.setOnAction(new CrearEspadachinHandler(this.cuartel, unJuego));

        contextMenu.getItems().addAll(crearArquero, crearEspadachin);
        boton.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(boton, event.getScreenX(), event.getScreenY());
            }
        });
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        mapaView.seleccionarCasillero(posicion);
        System.out.println(cuartel.getVida());
    }
}
