package vista;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BotonJugarEventHandler extends BotonEventHandler {
    private final Stage escenario;

    BotonJugarEventHandler(Stage escenario) {
        super();
        this.escenario = escenario;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        BorderPane raiz = new BorderPane();

        Button botonAtras = new Button("\uD83E\uDC44 Atrás");
        botonAtras.setOnAction(new BotonAtrasEventHandler(this.escenario));
        botonAtras.setAlignment(Pos.CENTER_LEFT);

        raiz.setBottom(botonAtras);

        GridPane formularios = new GridPane();
        formularios.setAlignment(Pos.CENTER);
        formularios.setHgap(32);
        formularios.setVgap(16);
        ColumnConstraints columnas = new ColumnConstraints();
        columnas.setHalignment(HPos.CENTER);
        formularios.getColumnConstraints().add(columnas);
        formularios.getColumnConstraints().add(columnas);

        Label jugador1 = new Label("Jugador 1:");
        jugador1.setId("nombreJugador");

        TextField nombre_jugador1 = new TextField();
        nombre_jugador1.setId("campoJugador");

        Label jugador2 = new Label("Jugador 2:");
        jugador2.setId("nombreJugador");

        TextField nombre_jugador2 = new TextField();
        nombre_jugador2.setId("campoJugador");

        Button botonWololo = new Button("Wololo ⚔");
        botonWololo.setId("botonWololo");
        botonWololo.setOnAction(new BotonWololoEventHandler(this.escenario, nombre_jugador1, nombre_jugador2));

        nombre_jugador1.setOnAction(event -> nombre_jugador2.requestFocus());

        formularios.add(jugador1, 0, 0);
        formularios.add(nombre_jugador1, 0, 1);
        formularios.add(jugador2, 1, 0);
        formularios.add(nombre_jugador2, 1, 1);
        formularios.add(botonWololo, 0, 4, 2, 1);

        raiz.setCenter(formularios);

        raiz.setPadding(new Insets(16));
        nombre_jugador1.requestFocus();
        this.escenario.getScene().setRoot(raiz);
    }
}
