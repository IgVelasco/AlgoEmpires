package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import modelo.espacio.Posicion;
import modelo.estructuras.PlazaCentral;
import modelo.excepciones.*;
import modelo.juego.Juego;
import vista.JuegoVista;
import vista.MapaView;

public class CrearAldeanoHandler extends AccionSobreCasilla implements EventHandler<ActionEvent> {
    PlazaCentral plazaCentral;
    Juego juego;

    public CrearAldeanoHandler(PlazaCentral unaPlazaCentral, Juego unJuego) {
        plazaCentral = unaPlazaCentral;
        juego = unJuego;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        mapaView.setAccionSobreCasilla(this);
    }

    public void realizarAccion(MapaView mapaView, Posicion posicion) {
        try {
            juego.getJugadorActual().crearAldeano(plazaCentral, posicion);

            String rutaSonido = "/vista/sonidos/crear_aldeano.mp3";
            AudioClip sonidoCrearAldeano = new AudioClip(
                    BotonEventHandler.class.getResource(rutaSonido).toExternalForm()
            );

            sonidoCrearAldeano.play();

        }catch (CasilleroOcupado e){
            alertar("Casillero Ocupado!");
        } catch (ContenibleNoPropia e){
            alertar("No te pertence!");
        }  catch (OroInsuficiente e){
            alertar("Oro insuficiente!");
        } catch (PoblacionLimiteAlcanzada e){
            alertar("La población es maxima!");
        } catch (PosicionFueraDeRango e){
            alertar("Posición fuera de rango de creación!");
        }
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView.getJuego());
    }

}
