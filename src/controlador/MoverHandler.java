package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import modelo.espacio.Posicion;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.unidades.UnidadMovil;
import vista.JuegoVista;
import vista.MapaView;

public class MoverHandler implements EventHandler<ActionEvent>, AccionSobreCasilla {
    UnidadMovil unidad;
    Juego juego;

    public MoverHandler(UnidadMovil unaUnidad, Juego unJuego) {
        unidad = unaUnidad;
        juego = unJuego;
    }

    @Override
    public void handle(ActionEvent event){
        MapaView mapaView = MapaView.getInstancia();
        mapaView.setAccionSobreCasilla(this);
    }

    @Override
    public void realizarAccion(MapaView mapaView, Posicion posicion){
        unidad.realizarMovimiento(mapaView.getMapa(),posicion.getPosX(),posicion.getPosY(),juego.getJugadorActual());
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(juego);

    }




}
