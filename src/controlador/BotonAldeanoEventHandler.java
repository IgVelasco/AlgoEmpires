package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import modelo.espacio.Casillero;
import modelo.unidades.Aldeano;

public class BotonAldeanoEventHandler extends BotonEventHandler {
    Aldeano aldeano;
    Button boton;

    public BotonAldeanoEventHandler(Casillero unCasillero, Button unBoton) {
        aldeano = (Aldeano) unCasillero.getContenido();
        boton = unBoton;
        ContextMenu contextMenu = new ContextMenu();
        MenuItem mover = new MenuItem("Mover a");

        MenuItem construirPlazaCentral = new MenuItem("Construir plaza central");

        MenuItem construirCuartel = new MenuItem("Construir cuartel");


        contextMenu.getItems().addAll(mover,construirPlazaCentral, construirCuartel);
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
