package vista;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonAtrasEventHandler extends BotonEventHandler {

    private Stage escenario;
    private Scene escenaInicial;

    BotonAtrasEventHandler(Stage escenario, Scene escenaInicial) {
        this.escenario = escenario;
        this.escenaInicial = escenaInicial;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        this.escenario.setScene(this.escenaInicial);
    }
}
