package vista;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonAtrasEventHandler extends BotonEventHandler {

    private final Stage escenario;
    private Scene escenaInicial;

    BotonAtrasEventHandler(Stage escenario) {
        super();
        this.escenario = escenario;
        this.escenaInicial = this.escenario.getScene();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        this.escenario.setScene(escenaInicial);
    }
}
