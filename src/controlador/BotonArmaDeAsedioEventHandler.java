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
import modelo.unidades.ArmaDeAsedio;
import vista.MapaView;

public class BotonArmaDeAsedioEventHandler extends BotonEventHandler {
    Button boton;
    ArmaDeAsedio armaDeAsedio;
    Posicion posicion;

    public BotonArmaDeAsedioEventHandler(Casillero unCasillero, Button unBoton, Juego unJuego) {
        armaDeAsedio = (ArmaDeAsedio) unCasillero.getContenido();
        boton = unBoton;
        posicion = unCasillero.getPosicion();
        ContextMenu contextMenu = new ContextMenu();

        MenuItem mover = new MenuItem("Mover a");
        MenuItem cargarArma = new MenuItem("Cargar arma");
        MenuItem atacar = new MenuItem("Atacar");
        MenuItem descargarArma = new MenuItem("Descargar Arma");
        MenuItem informacion = new MenuItem("Informacion");

        informacion.setOnAction(new MostrarInformacionUnidadHandler(this.armaDeAsedio));
        mover.setOnAction(new MoverHandler(this.armaDeAsedio, unJuego));
        atacar.setOnAction(new AtacarHandler(this.armaDeAsedio, unJuego));
        cargarArma.setOnAction(new CargarArmaHandler(this.armaDeAsedio, unJuego));
        descargarArma.setOnAction(new DescargarArmaHandler(this.armaDeAsedio, unJuego));

        contextMenu.getItems().addAll(mover,cargarArma, descargarArma, atacar, informacion);
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
