package vista;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;


public class AlgoEmpires extends Application {

    private static final String TITULO_VENTANA = "Algo Empires";
    private static final String TITULO_ESCENA = "file:src/vista/imagenes/titulo.png";
    private static final int ANCHO = 715;
    private static final int ALTO = 488;
    private static final String ARCHIVO_ESTILOS = "file:src/vista/style.css";

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage escenario) {
        AudioClip sonidoInicio = new AudioClip(
                getClass().getResource("sonidos/sonido_inicio.mp3").toExternalForm()
        );
        sonidoInicio.play();

        BorderPane raiz = new BorderPane();

        Image imagenTitulo = new Image(TITULO_ESCENA, true);
        ImageView titulo = new ImageView(imagenTitulo);
        BorderPane.setAlignment(titulo, Pos.CENTER);
        BorderPane.setMargin(titulo, new Insets(32, 0, 0, 0));

        raiz.setTop(titulo);

        GridPane botonera = new GridPane();

        Button botonJugar = new Button("¡Jugar!");
        botonJugar.setId("botonJugar");
        botonJugar.setOnAction(new BotonEventHandler(escenario, botonJugar));

        Button botonAcercaDe = new Button("Acerca de...");
        botonAcercaDe.setId("botonAcercaDe");
        botonAcercaDe.setOnAction(new BotonEventHandler(escenario, botonAcercaDe));

        Button botonSalir = new Button("Salir");
        botonSalir.setId("botonSalir");
        botonSalir.setOnAction(actionEvent -> Platform.exit());

        ColumnConstraints columnas = new ColumnConstraints();
        columnas.setHalignment(HPos.CENTER);

        botonera.getColumnConstraints().add(columnas);
        botonera.setAlignment(Pos.CENTER);
        botonera.setVgap(16);

        botonera.add(botonJugar, 0, 0);
        botonera.add(botonAcercaDe, 0, 1);
        botonera.add(botonSalir, 0, 2);

        raiz.setCenter(botonera);

        Scene escena = new Scene(raiz, ANCHO, ALTO);
        escena.getStylesheets().add(ARCHIVO_ESTILOS);

        escenario.setTitle(TITULO_VENTANA);
        escenario.resizableProperty().setValue(false);
        escenario.setScene(escena);

        escenario.show();
    }
}
