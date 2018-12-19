package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Juego;
import vista.JuegoVista;

public class BotonTurnosEventHandler implements EventHandler<ActionEvent> {
    private Juego elJuego;
    private JuegoVista vistaJuego;

    public BotonTurnosEventHandler(Juego unJuego, JuegoVista vista){
        this.elJuego = unJuego;
        this.vistaJuego = vista;
    }


    @Override
    public void handle(ActionEvent event) {
        elJuego.siguienteTurno();

        vistaJuego.actualizar(elJuego);
    }
}
