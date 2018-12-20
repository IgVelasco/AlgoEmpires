package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.espacio.Posicion;
import modelo.estados.ataque.ArmaCargada;
import modelo.excepciones.ArmaSeCargaEnSiguienteTurno;
import modelo.excepciones.ArmaYaCargada;
import modelo.excepciones.ContenibleNoPropia;
import modelo.juego.Juego;
import modelo.unidades.ArmaDeAsedio;
import vista.JuegoVista;
import vista.MapaView;

import java.io.File;

public class CargarArmaHandler extends AccionSobreCasilla implements EventHandler<ActionEvent> {
    ArmaDeAsedio armaDeAsedio;
    Juego juego;

    public CargarArmaHandler(ArmaDeAsedio armaDeAsedio, Juego unJuego) {
        this.armaDeAsedio = armaDeAsedio;
        juego = unJuego;

    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        realizarAccion(mapaView, null);
    }

    @Override
    public void realizarAccion(MapaView mapaView, Posicion posicion){
        try {
            armaDeAsedio.cargarArma(juego.getJugadorActual());

            String musicFile = "src/vista/sonidos/cargar_arma.mp3";

            Media sound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();

        } catch (ArmaYaCargada e){
            alertar("El arma ya esta cargada!");
        } catch (ArmaSeCargaEnSiguienteTurno e){
            alertar("El arma podra atacar en el siguiente turno!");
        } catch (ContenibleNoPropia e){
          alertar("No te pertence!");
        }
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(juego);
    }
}
