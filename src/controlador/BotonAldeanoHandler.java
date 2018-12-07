package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.espacio.Casillero;

public class BotonAldeanoHandler implements EventHandler<ActionEvent> {

    private final String IMAGEN_ALDEANO = "/vista/imagenes/aldeano_16_azul.png";

    BotonAldeanoHandler(Button unBoton, Casillero unCasillero) {
        Image imagenAldeano = new Image(getClass().getResourceAsStream(IMAGEN_ALDEANO));
        ImageView aldeano = new ImageView(imagenAldeano);
        unBoton.setGraphic(aldeano);
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
