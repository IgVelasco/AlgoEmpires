package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    public void realizarAccion(MapaView mapaView){
        Posicion destino = mapaView.getDestino();
        System.out.println(destino.getPosX());
        unidad.realizarMovimiento(mapaView.getMapa(),destino.getPosX(),destino.getPosY(),juego.getJugadorActual());
        mapaView = mapaView.iniciar(mapaView.getMapa());
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView.getJuego());

    }




}
