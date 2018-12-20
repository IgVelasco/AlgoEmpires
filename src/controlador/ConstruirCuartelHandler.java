package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.espacio.Posicion;
import modelo.excepciones.AldeanoOcupado;
import modelo.excepciones.ContenibleNoPropia;
import modelo.excepciones.PosicionFueraDeRango;
import modelo.juego.Juego;
import modelo.unidades.Aldeano;
import vista.JuegoVista;
import vista.MapaView;

import java.io.File;

public class ConstruirCuartelHandler extends AccionSobreCasilla implements EventHandler<ActionEvent> {
    Aldeano aldeano;
    Juego juego;

    public ConstruirCuartelHandler(Aldeano unAldeano, Juego unJuego) {
        aldeano = unAldeano;
        juego = unJuego;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        mapaView.setAccionSobreCasilla(this);
    }

    public void realizarAccion(MapaView mapaView, Posicion posicion) {
        try{
            juego.getJugadorActual().construirCuartel(aldeano, posicion.getPosX(), posicion.getPosY());

            String musicFile = "src/vista/sonidos/reparar.mp3";

            Media sound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();

        } catch (PosicionFueraDeRango e){
            alertar("Posición fuera de rango de construcción!");
        } catch (ContenibleNoPropia e){
            alertar("No te pertenece!");
        } catch (AldeanoOcupado e){
            alertar("Aldeano ocupado!");
        }
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView.getJuego());
    }
}
