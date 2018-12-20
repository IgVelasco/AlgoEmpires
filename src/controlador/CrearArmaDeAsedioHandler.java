package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.espacio.Posicion;
import modelo.estructuras.Castillo;
import modelo.excepciones.*;
import modelo.juego.Juego;
import vista.JuegoVista;
import vista.MapaView;

import java.io.File;

public class CrearArmaDeAsedioHandler extends AccionSobreCasilla implements EventHandler<ActionEvent> {
    Castillo castillo;
    Juego juego;

    public CrearArmaDeAsedioHandler(Castillo unCastillo, Juego unJuego) {
        castillo = unCastillo;
        juego = unJuego;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        mapaView.setAccionSobreCasilla(this);
    }

    public void realizarAccion(MapaView mapaView, Posicion posicion) {
        try {
            juego.getJugadorActual().crearArmaDeAsedio(posicion,castillo);

            String musicFile = "src/vista/sonidos/cargar_arma.mp3";

            Media sound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();

        } catch (CasilleroOcupado e){
            alertar("Casillero Ocupado!");
        } catch (OroInsuficiente e){
            alertar("El oro es insuficiente!");
        } catch (ContenibleNoPropia e){
            alertar("No te pertence!");
        } catch (PoblacionLimiteAlcanzada e){
            alertar("La población es maxima!");
        } catch (PosicionFueraDeRango e){
            alertar("Posición fuera de rango de creación!");
        }
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView.getJuego());
    }
}
