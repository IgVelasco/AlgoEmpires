package vista;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
