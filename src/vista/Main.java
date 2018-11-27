package vista;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String TITULO_VENTANA = "Algo Empires";
    private static final String TITULO_ESCENA = "file:src/vista/imagenes/titulo.png";
    private static final int ANCHO = 715;
    private static final int ALTO = 488;
    private static final String ARCHIVO_ESTILOS = "file:src/vista/style.css";

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage) throws Exception {
        Image imagenTitulo = new Image(TITULO_ESCENA, true);
        ImageView titulo = new ImageView(imagenTitulo);

        Alert wip = new Alert(Alert.AlertType.INFORMATION);
        wip.setResizable(false);
        wip.setTitle("WIP");
        wip.setContentText("WIP");

        Button botonJugar = new Button();
        botonJugar.setId("botonJugar");
        botonJugar.setOnAction(actionEvent -> wip.show());

        Button botonCreditos = new Button();
        botonCreditos.setId("botonCreditos");
        botonCreditos.setOnAction(actionEvent -> wip.show());

        Button botonSalir = new Button();
        botonSalir.setId("botonSalir");
        botonSalir.setOnAction(actionEvent -> Platform.exit());

        BorderPane raiz = new BorderPane();
        GridPane grilla = new GridPane();

        ColumnConstraints columnas = new ColumnConstraints();
        columnas.setHalignment(HPos.CENTER);

        grilla.getColumnConstraints().add(columnas);
        grilla.setAlignment(Pos.CENTER);
        grilla.setVgap(32);

        grilla.add(botonJugar, 0, 0);
        grilla.add(botonCreditos, 0, 1);
        grilla.add(botonSalir, 0, 2);

        raiz.setTop(titulo);
        BorderPane.setAlignment(titulo, Pos.CENTER);
        raiz.setCenter(grilla);

        stage.setTitle(TITULO_VENTANA);
        Scene escena = new Scene(raiz, ANCHO, ALTO);
        escena.getStylesheets().add(ARCHIVO_ESTILOS);
        stage.setScene(escena);
        stage.show();
    }
}
