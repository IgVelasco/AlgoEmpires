package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public class BotonEventHandler implements EventHandler<ActionEvent> {

    private static final AudioClip sonidoClick = new AudioClip(
            BotonEventHandler.class.getResource("sonidos/click_boton.mp3").toExternalForm()
    );

    public void handle(ActionEvent actionEvent) {
        sonidoClick.play();
    }
}
