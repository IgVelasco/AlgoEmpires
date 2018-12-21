package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import modelo.espacio.Posicion;
import modelo.excepciones.ContenibleNoPropia;
import modelo.juego.Juego;
import modelo.unidades.ArmaDeAsedio;
import vista.JuegoVista;
import vista.MapaView;

public class DescargarArmaHandler extends AccionSobreCasilla implements EventHandler<ActionEvent> {
    ArmaDeAsedio armaDeAsedio;
    Juego juego;

    public DescargarArmaHandler(ArmaDeAsedio armaDeAsedio, Juego unJuego) {
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
            armaDeAsedio.descargarArmaDeAsedio(juego.getJugadorActual());

            String rutaSonido = "/vista/sonidos/cargar_arma.mp3";
            AudioClip sonidoDescargarArma = new AudioClip(
                    BotonEventHandler.class.getResource(rutaSonido).toExternalForm()
            );

            sonidoDescargarArma.play();

        } catch (ContenibleNoPropia e){
            alertar("¡No te pertence!");
        }
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(juego);
    }
}