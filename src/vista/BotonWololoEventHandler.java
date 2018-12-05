package vista;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BotonWololoEventHandler extends BotonEventHandler {
    private static final int ANCHO = 20;
    private static final int ALTO = 15;
    private final Stage escenario;
    private final TextField nombre_jugador1;
    private final TextField nombre_jugador2;

    BotonWololoEventHandler(Stage escenario, TextField nombre_jugador1, TextField nombre_jugador2) {
        this.escenario = escenario;
        this.nombre_jugador1 = nombre_jugador1;
        this.nombre_jugador2 = nombre_jugador2;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        BorderPane raiz = new BorderPane();
        GridPane mapa = new GridPane();
        mapa.setAlignment(Pos.CENTER);

        for (int x = 0; x < ANCHO; x++) {
            for (int y = 0; y < ALTO; y++) {
                Image imagenSuelo = new Image(getClass().getResourceAsStream("imagenes/suelo.png"));
                ImageView suelo = new ImageView(imagenSuelo);
                mapa.add(suelo, x, y);
            }
        }

        raiz.setCenter(mapa);
        Scene escenaJuego = new Scene(raiz);

        this.escenario.setScene(escenaJuego);
        this.escenario.setMaximized(true);
    }
}
