package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.espacio.Casillero;

public class BotonPlazaCentralHandler implements EventHandler<ActionEvent> {
    public BotonPlazaCentralHandler(Button unBoton, Casillero unCasillero) {
        Image imagenPlazaCentral = new Image(getClass().getResourceAsStream("imagenes/plaza_central.png"));
        ImageView PlazaCentral = new ImageView(imagenPlazaCentral);
        unBoton.setGraphic(PlazaCentral);
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
