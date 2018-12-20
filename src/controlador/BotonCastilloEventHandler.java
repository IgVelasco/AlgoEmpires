package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.espacio.Casillero;
import modelo.espacio.Posicion;
import modelo.estructuras.Castillo;
import modelo.juego.Juego;
import vista.MapaView;

import java.io.File;

public class BotonCastilloEventHandler implements EventHandler<ActionEvent> {
    Castillo castillo;
    Button boton;
    Posicion posicion ;

    public BotonCastilloEventHandler(Casillero unCasillero, Button unBoton, Juego unJuego) {
        castillo = (Castillo) unCasillero.getContenido();
        posicion =  unCasillero.getPosicion();
        boton = unBoton;
        ContextMenu contextMenu = new ContextMenu();
        MenuItem crearArmaDeAsedio = new MenuItem("Crear arma de asedio ");
        MenuItem informacion = new MenuItem("Informacion");

        informacion.setOnAction(new MostrarInformacionEstructuraHandler(this.castillo));
        crearArmaDeAsedio.setOnAction(new CrearArmaDeAsedioHandler(this.castillo, unJuego));


        contextMenu.getItems().addAll( crearArmaDeAsedio, informacion);
        boton.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(boton, event.getScreenX(), event.getScreenY());

                String musicFile = "src/vista/sonidos/edificio.wav";

                Media sound = new Media(new File(musicFile).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();

            }
        });
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        mapaView.seleccionarCasillero(posicion);
    }
}
