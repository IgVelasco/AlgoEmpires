package vista;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;


public class AlgoEmpires extends Application {

    private Stage escenario;
    private Scene escenaInicial;
    private static final String TITULO_VENTANA = "Algo Empires";
    private static final String ICONO_VENTANA = "imagenes/icono.png";
    private static final String TITULO_ESCENA = "file:src/vista/imagenes/titulo.png";
    private static final String SONIDO_INICIO = "sonidos/sonido_inicio.mp3";
    private static final int ANCHO = 715;
    private static final int ALTO = 488;
    private static final String ARCHIVO_ESTILOS = "file:src/vista/style.css";

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage escenario) {
        this.escenario = escenario;

        Image icono = new Image(getClass().getResourceAsStream(ICONO_VENTANA));
        AudioClip sonidoInicio = new AudioClip(getClass().getResource(SONIDO_INICIO).toExternalForm());
        Image imagenTitulo = new Image(TITULO_ESCENA, true);
        ImageView titulo = new ImageView(imagenTitulo);

        BorderPane raiz = new BorderPane();
        BorderPane.setAlignment(titulo, Pos.CENTER);
        BorderPane.setMargin(titulo, new Insets(32, 0, 0, 0));

        raiz.setTop(titulo);

        Button botonJugar = new Button("¡Jugar!");
        botonJugar.setId("botonJugar");
        botonJugar.setOnAction(new BotonJugarEventHandler(this));

        Button botonAcercaDe = new Button("Acerca de...");
        botonAcercaDe.setId("botonAcercaDe");
        botonAcercaDe.setOnAction(new BotonEventHandler());

        Button botonSalir = new Button("Salir");
        botonSalir.setId("botonSalir");
        botonSalir.setOnAction(actionEvent -> Platform.exit());

        VBox botonera = new VBox(botonJugar, botonAcercaDe, botonSalir);
        botonera.setAlignment(Pos.CENTER);
        botonera.setSpacing(16);

        raiz.setCenter(botonera);

        Scene escenaInicial = new Scene(raiz, ANCHO, ALTO);
        escenaInicial.getStylesheets().add(ARCHIVO_ESTILOS);
        this.escenaInicial = escenaInicial;

        escenario.getIcons().add(icono);
        escenario.setTitle(TITULO_VENTANA);
        escenario.resizableProperty().setValue(false);
        escenario.setScene(escenaInicial);

        sonidoInicio.play();
        escenario.show();
    }

    void iniciarJugadores() {
        BorderPane raiz = new BorderPane();

        Scene escena = new Scene(raiz, ANCHO, ALTO);
        escena.getStylesheets().setAll(ARCHIVO_ESTILOS);

        Button botonAtras = new Button("\uD83E\uDC44 Atrás");
        botonAtras.setOnAction(new BotonAtrasEventHandler(this.escenario, this.escenaInicial));
        botonAtras.setAlignment(Pos.CENTER_LEFT);

        raiz.setBottom(botonAtras);

        GridPane formularios = new GridPane();
        formularios.setAlignment(Pos.CENTER);
        formularios.setHgap(32);
        formularios.setVgap(16);
        setColumnasCentradas(formularios, 2);

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
        botonWololo.setOnAction(new BotonWololoEventHandler(this, nombre_jugador1, nombre_jugador2));

        nombre_jugador1.setOnAction(actionEvent -> nombre_jugador2.requestFocus());

        formularios.add(jugador1, 0, 0);
        formularios.add(nombre_jugador1, 0, 1);
        formularios.add(jugador2, 1, 0);
        formularios.add(nombre_jugador2, 1, 1);
        formularios.add(botonWololo, 0, 4, 2, 1);

        raiz.setCenter(formularios);

        raiz.setPadding(new Insets(16));
        nombre_jugador1.requestFocus();
        this.escenario.setScene(escena);
    }

    private void setColumnasCentradas(GridPane grilla, int cantidadColumnas) {
        ColumnConstraints columnas = new ColumnConstraints();
        columnas.setHalignment(HPos.CENTER);

        for (int i = 0; i < cantidadColumnas; i++) {
            grilla.getColumnConstraints().add(columnas);
        }
    }
}
