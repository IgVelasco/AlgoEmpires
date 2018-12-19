package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Juego;

public class BotonTurnosEventHandler implements EventHandler<ActionEvent> {
    private Juego elJuego;

    public BotonTurnosEventHandler(Juego unJuego){
        this.elJuego = unJuego;
    }


    @Override
    public void handle(ActionEvent event) {
        elJuego.siguienteTurno();
        System.out.print(elJuego.getJugadorActual());
    }
}
