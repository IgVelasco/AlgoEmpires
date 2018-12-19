package vista;

import controlador.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
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
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;
import modelo.unidades.ArmaDeAsedio;
import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;

public class JuegoVista {
    private static JuegoVista INSTANCIA;
    private static final int ANCHO = 20;
    private static final int ALTO = 15;
    private final Stage escenario;

    public JuegoVista(Stage escenario) {
        this.escenario = escenario;
    }

    public static JuegoVista getInstancia() {
        return INSTANCIA;
    }

    public void iniciar(TextField nombre_jug_1, TextField nombre_jug_2) {

        BorderPane raiz = new BorderPane();
        Juego nuevoJuego = new Juego(ANCHO, ALTO);
        Mapa mapa = nuevoJuego.getMapa();
        Jugador[] jugadores = nuevoJuego.getJugadores();
        jugadores[0].setNombreJugador(nombre_jug_1.getText());
        jugadores[1].setNombreJugador(nombre_jug_2.getText());


        MapaView vistaMapa = new MapaView(mapa, jugadores, nuevoJuego);
        UtilidadView utilidad = new UtilidadView(nuevoJuego, this);



        raiz.setCenter(vistaMapa);
        raiz.setRight(utilidad);
        Scene escenaJuego = new Scene(raiz);
        escenaJuego.getStylesheets().add("/vista/styleJuego.css");

        this.escenario.setScene(escenaJuego);
        //this.escenario.setMaximized(true);
        INSTANCIA = this;
    }

    public void actualizar(Juego unJuego){
        BorderPane raiz = new BorderPane();

        Mapa mapa = unJuego.getMapa();
        Jugador[] jugadores = unJuego.getJugadores();

        MapaView vistaMapa = new MapaView(mapa, jugadores, unJuego);
        UtilidadView utilidad = new UtilidadView(unJuego, this);

        raiz.setCenter(vistaMapa);
        raiz.setRight(utilidad);
        Scene escenaJuego = new Scene(raiz);
        escenaJuego.getStylesheets().add("/vista/styleJuego.css");

        this.escenario.setScene(escenaJuego);
        //this.escenario.setMaximized(true);
        INSTANCIA = this;

    }



}
