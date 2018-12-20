package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.espacio.Posicion;
import modelo.estructuras.Castillo;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.ContenibleNoPropia;
import modelo.excepciones.OroInsuficiente;
import modelo.excepciones.PoblacionLimiteAlcanzada;
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
        } catch (CasilleroOcupado e){
            alertar("Casillero Ocupado!");
        } catch (OroInsuficiente e){
            alertar("El oro es insuficiente!");
        } catch (ContenibleNoPropia e){
            alertar("No te pertence!");
        } catch (PoblacionLimiteAlcanzada e){
            alertar("La población es maxima!");
        }
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView.getJuego());
    }
}
