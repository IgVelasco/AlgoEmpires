package controlador;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import vista.AlgoEmpires;

public class BotonAtrasEventHandler extends BotonEventHandler {

    private final AlgoEmpires aplicacion;
    private final Stage escenario;

    BotonAtrasEventHandler(AlgoEmpires aplicacion, Stage escenario) {
        super();
        this.aplicacion = aplicacion;
        this.escenario = escenario;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        this.aplicacion.start(this.escenario);
    }
}
