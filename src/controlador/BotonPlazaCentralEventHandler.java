package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import modelo.espacio.Casillero;
import modelo.estructuras.PlazaCentral;
import modelo.juego.Juego;

public class BotonPlazaCentralEventHandler implements EventHandler<ActionEvent> {
    PlazaCentral plazaCentral;
    Button boton;

    public BotonPlazaCentralEventHandler(Casillero unCasillero, Button unBoton, Juego unJuego) {
        plazaCentral = (PlazaCentral) unCasillero.getContenido();
        boton = unBoton;
        ContextMenu contextMenu = new ContextMenu();
        MenuItem crearAldeano = new MenuItem("Crear aldeano ");
        MenuItem informacion = new MenuItem("Informacion");

        informacion.setOnAction(new MostrarInformacionEstructuraHandler(plazaCentral));
        crearAldeano.setOnAction(new CrearAldeanoHandler(this.plazaCentral, unJuego));


        contextMenu.getItems().addAll( crearAldeano, informacion);
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
