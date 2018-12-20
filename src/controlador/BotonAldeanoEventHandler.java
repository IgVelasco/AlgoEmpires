package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import modelo.espacio.Casillero;
import modelo.espacio.Posicion;
import modelo.juego.Juego;
import modelo.unidades.Aldeano;
import vista.MapaView;

public class BotonAldeanoEventHandler extends BotonEventHandler {
    Aldeano aldeano;
    Button boton;
    Posicion posicion;

    public BotonAldeanoEventHandler(Casillero unCasillero, Button unBoton, Juego unJuego) {
        aldeano = (Aldeano) unCasillero.getContenido();
        boton = unBoton;
        posicion = aldeano.getPosicion();
        ContextMenu contextMenu = new ContextMenu();
        MenuItem mover = new MenuItem("Mover a");
        MenuItem construirPlazaCentral = new MenuItem("Construir plaza central");
        MenuItem construirCuartel = new MenuItem("Construir cuartel");
        MenuItem reparar = new MenuItem("Reparar");
        MenuItem estadoUnidad = new MenuItem("Informacion");

        mover.setOnAction(new MoverHandler(this.aldeano, unJuego));
        construirPlazaCentral.setOnAction(new ConstruirPlazaCentralHandler(this.aldeano, unJuego));
        construirCuartel.setOnAction(new ConstruirCuartelHandler(this.aldeano, unJuego));
        reparar.setOnAction(new RepararHandler(this.aldeano, unJuego));
        estadoUnidad.setOnAction(new MostrarInformacionUnidadHandler(this.aldeano));


        contextMenu.getItems().addAll(mover,construirPlazaCentral, construirCuartel, reparar, estadoUnidad);
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

    }
}
