package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.media.AudioClip;
import modelo.espacio.Casillero;
import modelo.espacio.Posicion;
import modelo.juego.Juego;
import modelo.unidades.Arquero;
import vista.MapaView;

public class BotonArqueroEventHandler extends BotonEventHandler {
    Button boton;
    Arquero arquero;
    Posicion posicion;

    public BotonArqueroEventHandler(Casillero unCasillero, Button unBoton, Juego unJuego) {
        arquero = (Arquero) unCasillero.getContenido();
        boton = unBoton;
        posicion = unCasillero.getPosicion();

        ContextMenu contextMenu = new ContextMenu();
        MenuItem mover = new MenuItem("Mover");
        MenuItem atacar = new MenuItem("Atacar");
        MenuItem informacion = new MenuItem("Informacion");

        informacion.setOnAction(new MostrarInformacionUnidadHandler(this.arquero));

        mover.setOnAction(new MoverHandler(this.arquero, unJuego));
        atacar.setOnAction(new AtacarHandler(this.arquero, unJuego));

        contextMenu.getItems().addAll(mover, atacar, informacion);
        boton.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {
                String rutaSonido = "/vista/sonidos/aldeano.mp3";
                AudioClip sonidoArquero = new AudioClip(
                        BotonEventHandler.class.getResource(rutaSonido).toExternalForm()
                );

                sonidoArquero.play();

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
