package controlador;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import modelo.espacio.Casillero;
import modelo.unidades.Espadachin;

public class BotonEspadachinEventHandler extends BotonEventHandler {
    Espadachin espadachin;
    Button boton;


    public BotonEspadachinEventHandler(Casillero unCasillero, Button unBoton) {
        espadachin = (Espadachin) unCasillero.getContenido();
        boton = unBoton;
        ContextMenu contextMenu = new ContextMenu();

        MenuItem mover = new MenuItem("Mover");
        MenuItem atacar = new MenuItem("Atacar");


        contextMenu.getItems().addAll(mover, atacar);
        boton.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(boton, event.getScreenX(), event.getScreenY());
            }
        });
    }
}
