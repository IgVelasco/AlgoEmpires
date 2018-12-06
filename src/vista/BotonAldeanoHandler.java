package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.espacio.Casillero;

public class BotonAldeanoHandler implements EventHandler<ActionEvent> {
    public BotonAldeanoHandler(Button unBoton, Casillero unCasillero) {
        Image imagenAldeano = new Image(getClass().getResourceAsStream("imagenes/aldeano_16_azul.png"));
        ImageView aldeano = new ImageView(imagenAldeano);
        unBoton.setGraphic(aldeano);
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
