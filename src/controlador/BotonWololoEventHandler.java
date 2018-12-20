package controlador;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vista.AlgoEmpires;
import vista.JuegoVista;

public class BotonWololoEventHandler extends BotonEventHandler {

    private final AlgoEmpires aplicacion;
    private final Stage escenario;
    private final TextField nombre_jugador1;
    private final TextField nombre_jugador2;

    BotonWololoEventHandler(AlgoEmpires aplicacion, Stage escenario, TextField nombre_jugador1, TextField nombre_jugador2) {
        this.aplicacion = aplicacion;
        this.escenario = escenario;
        this.nombre_jugador1 = nombre_jugador1;
        this.nombre_jugador2 = nombre_jugador2;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        JuegoVista juegoVista = new JuegoVista(this.aplicacion, this.escenario);
        juegoVista.iniciar(nombre_jugador1,nombre_jugador2);
    }
}
