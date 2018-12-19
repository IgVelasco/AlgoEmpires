package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import modelo.espacio.Casillero;
import modelo.estructuras.Castillo;
import modelo.juego.Juego;

public class BotonCastilloEventHandler implements EventHandler<ActionEvent> {
    Castillo castillo;
    Button boton;

    public BotonCastilloEventHandler(Casillero unCasillero, Button unBoton, Juego unJuego) {
        castillo = (Castillo) unCasillero.getContenido();
        boton = unBoton;
        ContextMenu contextMenu = new ContextMenu();
        MenuItem crearArmaDeAsedio = new MenuItem("Crear arma de asedio ");
        crearArmaDeAsedio.setOnAction(new CrearArmaDeAsedioHandler(this.castillo, unJuego));


        contextMenu.getItems().addAll( crearArmaDeAsedio);
        boton.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(boton, event.getScreenX(), event.getScreenY());
            }
        });
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
