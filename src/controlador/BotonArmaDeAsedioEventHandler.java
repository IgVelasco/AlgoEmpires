package controlador;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import modelo.espacio.Casillero;
import modelo.unidades.ArmaDeAsedio;

public class BotonArmaDeAsedioEventHandler extends BotonEventHandler {
    Button boton;
    ArmaDeAsedio armaDeAsedio;

    public BotonArmaDeAsedioEventHandler(Casillero unCasillero, Button unBoton) {
        armaDeAsedio = (ArmaDeAsedio) unCasillero.getContenido();
        boton = unBoton;
        ContextMenu contextMenu = new ContextMenu();

        MenuItem mover = new MenuItem("Mover a");
        MenuItem cargarArma = new MenuItem("Cargar arma");
        MenuItem atacar = new MenuItem("Atacar");

        mover.setOnAction(new MoverHandler(this.armaDeAsedio));


        contextMenu.getItems().addAll(mover,cargarArma, atacar);
        boton.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(boton, event.getScreenX(), event.getScreenY());
            }
        });
    }
}
