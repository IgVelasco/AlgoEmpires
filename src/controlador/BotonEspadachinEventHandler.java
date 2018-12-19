package controlador;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import modelo.espacio.Casillero;
import modelo.juego.Juego;
import modelo.unidades.Espadachin;

public class BotonEspadachinEventHandler extends BotonEventHandler {
    Espadachin espadachin;
    Button boton;


    public BotonEspadachinEventHandler(Casillero unCasillero, Button unBoton, Juego unJuego) {
        espadachin = (Espadachin) unCasillero.getContenido();
        boton = unBoton;
        ContextMenu contextMenu = new ContextMenu();

        MenuItem mover = new MenuItem("Mover");
        MenuItem atacar = new MenuItem("Atacar");

        mover.setOnAction(new MoverHandler(this.espadachin, unJuego));
        atacar.setOnAction(new AtacarHandler(this.espadachin, unJuego));


        contextMenu.getItems().addAll(mover, atacar);
        boton.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(boton, event.getScreenX(), event.getScreenY());
            }
        });
    }
}
