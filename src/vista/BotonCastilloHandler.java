package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.espacio.Casillero;

public class BotonCastilloHandler implements EventHandler<ActionEvent> {

    public BotonCastilloHandler(Button unBoton, Casillero unCasillero) {
        Image imagenCastillo = new Image(getClass().getResourceAsStream("imagenes/castillo.png"));
        ImageView castillo = new ImageView(imagenCastillo);
        unBoton.setGraphic(castillo);
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
