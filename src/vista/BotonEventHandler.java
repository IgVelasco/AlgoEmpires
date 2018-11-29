package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class BotonEventHandler implements EventHandler<ActionEvent> {
    private Button boton;
    private Stage escenario;

    public BotonEventHandler(Stage escenario, Button boton) {
        this.boton = boton;
        this.escenario = escenario;
    }

    public void BotonEventHandler(Button boton) {
        this.boton = boton;
    }

    public void handle(ActionEvent actionEvent) {
        Alert wip = new Alert(Alert.AlertType.INFORMATION);
        wip.setTitle("WIP");
        wip.setContentText("WIP");

        AudioClip sonidoClick = new AudioClip(
                getClass().getResource("sonidos/click_boton.mp3").toExternalForm()
        );

        sonidoClick.play();
        wip.show();
    }
}
