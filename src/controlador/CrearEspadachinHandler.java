package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.espacio.Posicion;
import modelo.estructuras.Cuartel;
import modelo.excepciones.*;
import modelo.juego.Juego;
import vista.JuegoVista;
import vista.MapaView;

public class CrearEspadachinHandler extends AccionSobreCasilla implements EventHandler<ActionEvent> {
    Cuartel cuartel;
    Juego juego;

    public CrearEspadachinHandler(Cuartel unCuartel, Juego unJuego) {
        cuartel = unCuartel;
        juego = unJuego;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        mapaView.setAccionSobreCasilla(this);
    }

    public void realizarAccion(MapaView mapaView, Posicion posicion) {
        try{
            juego.getJugadorActual().crearEspadachin(cuartel, posicion);
        } catch (CasilleroOcupado e){
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
