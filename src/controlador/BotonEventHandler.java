package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public class BotonEventHandler implements EventHandler<ActionEvent> {

    private static final String SONIDO_CLICK = "/vista/sonidos/click_boton.mp3";

    private static final AudioClip sonidoClick = new AudioClip(
            BotonEventHandler.class.getResource(SONIDO_CLICK).toExternalForm()
    );

    public void handle(ActionEvent actionEvent) {
        sonidoClick.play();
    }
}
