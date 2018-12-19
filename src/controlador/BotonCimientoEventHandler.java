package controlador;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import modelo.espacio.Casillero;
import modelo.estructuras.Castillo;
import modelo.estructuras.Cimiento;

public class BotonCimientoEventHandler extends BotonEventHandler {
    public BotonCimientoEventHandler(Casillero unCasillero, Button botonMapa) {
        Cimiento cimiento = (Cimiento) unCasillero.getContenido();
        ContextMenu contextMenu = new ContextMenu();
        MenuItem informacion = new MenuItem("Informacion");

        informacion.setOnAction(new MostrarInformacionCimientoHandler(cimiento));


        contextMenu.getItems().addAll(informacion);
        botonMapa.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(botonMapa, event.getScreenX(), event.getScreenY());
            }
        });
    }
}
