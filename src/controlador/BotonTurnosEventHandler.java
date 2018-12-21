package controlador;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import modelo.juego.Juego;
import vista.AlgoEmpires;
import vista.JuegoVista;

public class BotonTurnosEventHandler extends BotonEventHandler {

    private final AlgoEmpires aplicacion;
    private final Stage escenario;
    private Juego elJuego;
    private JuegoVista vistaJuego;

    public BotonTurnosEventHandler(Juego unJuego, JuegoVista vista, AlgoEmpires aplicacion, Stage escenario){
        this.aplicacion = aplicacion;
        this.escenario = escenario;
        this.elJuego = unJuego;
        this.vistaJuego = vista;
    }


    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        elJuego.siguienteTurno();

        vistaJuego.actualizar(elJuego);
    }
}

