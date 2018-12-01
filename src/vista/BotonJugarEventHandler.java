package vista;

import javafx.event.ActionEvent;

public class BotonJugarEventHandler extends BotonEventHandler {
    private AlgoEmpires aplicacion;

    BotonJugarEventHandler(AlgoEmpires aplicacion) {
        super();
        this.aplicacion = aplicacion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        this.aplicacion.iniciarJugadores();
    }
}
