package vista;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class BotonWololoEventHandler extends BotonEventHandler {
    private final AlgoEmpires aplicacion;
    private final TextField nombre_jugador1;
    private final TextField nombre_jugador2;

    BotonWololoEventHandler(AlgoEmpires aplicacion, TextField nombre_jugador1, TextField nombre_jugador2) {
        this.aplicacion = aplicacion;
        this.nombre_jugador1 = nombre_jugador1;
        this.nombre_jugador2 = nombre_jugador2;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        System.out.println((nombre_jugador1.getText()));
        System.out.println((nombre_jugador2.getText()));
    }
}
