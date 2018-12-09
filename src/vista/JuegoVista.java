package vista;

import controlador.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modelo.espacio.Casillero;
import modelo.espacio.Contenible;
import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.estructuras.Castillo;
import modelo.estructuras.Cimiento;
import modelo.estructuras.Cuartel;
import modelo.estructuras.PlazaCentral;
import modelo.juego.Juego;
import modelo.unidades.Aldeano;
import modelo.unidades.ArmaDeAsedio;
import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;

public class JuegoVista {

    private static final int ANCHO = 20;
    private static final int ALTO = 15;
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
                Button botonMapa = new Button();

                Casillero unCasillero = mapa.getCasillero(new Posicion(x, y));
                Contenible elContenido = unCasillero.getContenido();
                
                if (elContenido instanceof Aldeano) {
                    botonMapa.setId("botonAldeano");
                    botonMapa.setOnAction(new BotonAldeanoEventHandler(unCasillero, botonMapa));
                } else if (elContenido instanceof Castillo) {
                    botonMapa.setId("botonCastillo");
                    botonMapa.setOnAction(new BotonCastilloEventHandler(unCasillero, botonMapa));
                } else if (elContenido instanceof PlazaCentral) {
                    botonMapa.setId("botonPlazaCentral");
                    botonMapa.setOnAction(new BotonPlazaCentralEventHandler(unCasillero, botonMapa));
                } else if (elContenido instanceof ArmaDeAsedio){
                    botonMapa.setId("botonAldeano");
                    botonMapa.setOnAction(new BotonArmaDeAsedioEventHandler(unCasillero, botonMapa));

                }else if (elContenido instanceof Espadachin){
                    botonMapa.setId("botonAldeano");
                    botonMapa.setOnAction(new BotonEspadachinEventHandler(unCasillero, botonMapa));

                } else if(elContenido instanceof Arquero){
                    botonMapa.setId("botonAldeano");
                    botonMapa.setOnAction(new BotonArqueroEventHandler(unCasillero, botonMapa));
                } else if(elContenido instanceof Cimiento){
                    botonMapa.setId("botonAldeano");
                    botonMapa.setOnAction(new BotonCimientoEventHandler(unCasillero, botonMapa));
                } else if(elContenido instanceof Cuartel){
                    botonMapa.setId("botonAldeano");
                    botonMapa.setOnAction(new BotonCuartelEventHandler(unCasillero, botonMapa));
                } else{
                    botonMapa.setId("botonSuelo");
                }

                vistaMapa.add(botonMapa, x, y);
            }
        }
        raiz.setCenter(vistaMapa);
        Scene escenaJuego = new Scene(raiz);
        escenaJuego.getStylesheets().add("/vista/styleJuego.css");

        this.escenario.setScene(escenaJuego);
        this.escenario.setMaximized(true);
    }
}
