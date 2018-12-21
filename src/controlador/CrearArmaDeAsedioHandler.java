package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import modelo.espacio.Posicion;
import modelo.estructuras.Castillo;
import modelo.excepciones.*;
import modelo.juego.Juego;
import vista.JuegoVista;
import vista.MapaView;

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

            String rutaSonido = "/vista/sonidos/cargar_arma.mp3";
            AudioClip sonidoCrearArma = new AudioClip(
                    BotonEventHandler.class.getResource(rutaSonido).toExternalForm()
            );

            sonidoCrearArma.play();

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
