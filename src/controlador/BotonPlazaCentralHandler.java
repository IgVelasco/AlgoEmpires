package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.espacio.Casillero;

public class BotonPlazaCentralHandler implements EventHandler<ActionEvent> {

    private final String IMAGEN_PLAZA_CENTRAL = "/vista/imagenes/plaza_central.png";

    BotonPlazaCentralHandler(Button unBoton, Casillero unCasillero) {
        Image imagenPlazaCentral = new Image(getClass().getResourceAsStream(IMAGEN_PLAZA_CENTRAL));
        ImageView PlazaCentral = new ImageView(imagenPlazaCentral);
        unBoton.setGraphic(PlazaCentral);
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
