package controlador;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vista.JuegoVista;

public class BotonWololoEventHandler extends BotonEventHandler {

    private final Stage escenario;
    private final TextField nombre_jugador1;
    private final TextField nombre_jugador2;

    BotonWololoEventHandler(Stage escenario, TextField nombre_jugador1, TextField nombre_jugador2) {
        this.escenario = escenario;
        this.nombre_jugador1 = nombre_jugador1;
        this.nombre_jugador2 = nombre_jugador2;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        JuegoVista juegoVista = new JuegoVista(this.escenario);
        juegoVista.iniciar();
    }
}
