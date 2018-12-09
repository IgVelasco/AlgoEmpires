package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import modelo.espacio.Casillero;
import modelo.estructuras.PlazaCentral;

public class BotonPlazaCentralEventHandler implements EventHandler<ActionEvent> {
    PlazaCentral plazaCentral;
    Button boton;

    public BotonPlazaCentralEventHandler(Casillero unCasillero, Button unBoton) {
        plazaCentral = (PlazaCentral) unCasillero.getContenido();
        boton = unBoton;
        ContextMenu contextMenu = new ContextMenu();
        MenuItem crearAldeano = new MenuItem("Crear aldeano ");


        contextMenu.getItems().addAll( crearAldeano);
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
