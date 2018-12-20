package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import vista.AlgoEmpires;
import vista.JuegoVista;

public class BotonTurnosEventHandler implements EventHandler<ActionEvent> {
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
        elJuego.siguienteTurno();

        vistaJuego.actualizar(elJuego);

        for (Jugador jugador : elJuego.getJugadores()) {
            if (jugador.getCastillo().getVida() <= 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Has ganado!");
                alert.showAndWait();
                this.aplicacion.start(escenario);
            }
        }
    }
}
