package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.espacio.Contenible;
import modelo.espacio.Posicion;
import modelo.juego.Juego;
import modelo.unidades.Arquero;
import modelo.unidades.Atacante;
import modelo.unidades.Infanteria;
import vista.JuegoVista;
import vista.MapaView;

public class AtacarHandler implements EventHandler<ActionEvent>, AccionSobreCasilla {
    Atacante atacante;
    Juego juego;

    public AtacarHandler(Atacante unAtacante, Juego unJuego) {
        atacante = unAtacante;
        juego = unJuego;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        mapaView.setAccionSobreCasilla(this);
    }

    @Override
    public void realizarAccion(MapaView mapaView) {
        Posicion destino = mapaView.getDestino();
        Contenible unContenible = mapaView.getMapa().getContenido(destino.getPosX(), destino.getPosY());
        atacante.atacar(unContenible, juego.getJugadorActual());
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(juego);
    }
}
