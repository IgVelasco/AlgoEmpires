package vista;

import controlador.BotonAldeanoEventHandler;
import controlador.BotonCastilloEventHandler;
import controlador.BotonPlazaCentralEventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modelo.espacio.Casillero;
import modelo.espacio.Contenible;
import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.estructuras.Castillo;
import modelo.estructuras.PlazaCentral;
import modelo.juego.Juego;
import modelo.unidades.Aldeano;

public class JuegoVista {

    private static final int ANCHO = 20;
    private static final int ALTO = 15;
    private final String IMAGEN_SUELO = "/vista/imagenes/suelo.png";
    private final Stage escenario;

    public JuegoVista(Stage escenario) {
        this.escenario = escenario;
    }

    public void actualizar() {

        BorderPane raiz = new BorderPane();
        GridPane vistaMapa = new GridPane();
        vistaMapa.setAlignment(Pos.CENTER);

        Juego nuevoJuego = new Juego(ANCHO, ALTO);
        Mapa mapa = nuevoJuego.getMapa();

        for (int x = 0; x < ANCHO; x++) {
            for (int y = 0; y < ALTO; y++) {
                Image imagenSuelo = new Image(getClass().getResourceAsStream(IMAGEN_SUELO));
                ImageView suelo = new ImageView(imagenSuelo);
                Button unBoton = new Button();
                Casillero unCasillero = mapa.getCasillero(new Posicion(x, y));
                Contenible elContenido = unCasillero.getContenido();
                if (elContenido instanceof Aldeano) {
                    unBoton.setId("botonAldeano");
                    unBoton.setOnAction(new BotonAldeanoEventHandler(unCasillero));
                } else if (elContenido instanceof Castillo) {
                    unBoton.setId("botonCastillo");
                    unBoton.setOnAction(new BotonCastilloEventHandler(unCasillero));
                } else if (elContenido instanceof PlazaCentral) {
                    unBoton.setId("botonPlazaCentral");
                    unBoton.setOnAction(new BotonPlazaCentralEventHandler(unCasillero));
                } else {
                    unBoton.setId("botonSuelo");
                }

                vistaMapa.add(unBoton, x, y);
            }
        }
        raiz.setCenter(vistaMapa);
        Scene escenaJuego = new Scene(raiz);
        escenaJuego.getStylesheets().add("/vista/styleJuego.css");

        this.escenario.setScene(escenaJuego);
        this.escenario.setMaximized(true);
    }
}
