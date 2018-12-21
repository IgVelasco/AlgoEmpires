package vista;

import controlador.*;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import modelo.espacio.Casillero;
import modelo.espacio.Contenible;
import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.estructuras.Castillo;
import modelo.estructuras.Cimiento;
import modelo.estructuras.Cuartel;
import modelo.estructuras.PlazaCentral;
import modelo.excepciones.PartidaTerminada;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.unidades.Aldeano;
import modelo.unidades.ArmaDeAsedio;
import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;

public class MapaView extends GridPane {
    private static MapaView INSTANCIA;
    private Posicion casilleroSeleccionada;
    private static final int ANCHO = 20;
    private static final int ALTO = 15;
    private Mapa mapa;
    private Jugador[] listaJugadores;
    private AccionSobreCasilla accionSobreCasilla;
    public Juego juego;
    private AlgoEmpires aplicacion;


    public MapaView(Mapa mapa, Jugador[] jugadores, Juego unJuego, AlgoEmpires aplicacion){
        this.aplicacion = aplicacion;
        this.setAlignment(Pos.CENTER);
        INSTANCIA = this;
        this.casilleroSeleccionada = null;
        this.listaJugadores = jugadores;
        juego = unJuego;
        this.iniciar(mapa);
    }

    public MapaView iniciar(Mapa unMapa) {
        for (int x = 0; x < ANCHO; x++) {
            for (int y = 0; y < ALTO; y++) {
                Button botonMapa = new Button();

                Casillero unCasillero = unMapa.getCasillero(new Posicion(x, y));
                mapa = unMapa;
                Contenible elContenido = unCasillero.getContenido();

                if (elContenido instanceof Aldeano) {
                    if (((Aldeano) elContenido).getPropietario() == this.listaJugadores[1]){
                        botonMapa.setId("botonAldeanoAzul");
                    }
                    else{botonMapa.setId("botonAldeanoRojo");}
                    botonMapa.setOnAction(new BotonAldeanoEventHandler(unCasillero, botonMapa, juego));

                } else if (elContenido instanceof Castillo) {
                    if (((Castillo) elContenido).getPropietario() == this.listaJugadores[1]){
                        botonMapa.setId("botonCastilloAzul");
                    }
                    else{botonMapa.setId("botonCastilloRojo");}
                    botonMapa.setOnAction(new BotonCastilloEventHandler(unCasillero, botonMapa, juego));

                } else if (elContenido instanceof PlazaCentral) {
                    if (((PlazaCentral) elContenido).getPropietario() == this.listaJugadores[1]){
                        botonMapa.setId("botonPlazaCentralAzul");
                    }
                    else{botonMapa.setId("botonPlazaCentralRoja");}
                    botonMapa.setOnAction(new BotonPlazaCentralEventHandler(unCasillero, botonMapa, juego));

                } else if (elContenido instanceof ArmaDeAsedio){
                    if (((ArmaDeAsedio) elContenido).getPropietario() == this.listaJugadores[1]){
                        botonMapa.setId("botonArmaDeAsedioAzul");
                    }
                    else{botonMapa.setId("botonArmaDeAsedioRoja");}
                    botonMapa.setOnAction(new BotonArmaDeAsedioEventHandler(unCasillero, botonMapa, juego));

                }else if (elContenido instanceof Espadachin){
                    if (((Espadachin) elContenido).getPropietario() == this.listaJugadores[1]){
                        botonMapa.setId("botonEspadachinAzul");
                    }
                    else{botonMapa.setId("botonEspadachinRojo");}
                    botonMapa.setOnAction(new BotonEspadachinEventHandler(unCasillero, botonMapa, juego));

                } else if(elContenido instanceof Arquero){
                    if (((Arquero) elContenido).getPropietario() == this.listaJugadores[1]){
                        botonMapa.setId("botonArqueroAzul");
                    }
                    else{botonMapa.setId("botonArqueroRojo");}
                    botonMapa.setOnAction(new BotonArqueroEventHandler(unCasillero, botonMapa, juego));

                } else if(elContenido instanceof Cimiento){
                    botonMapa.setId("botonCimiento");
                    botonMapa.setOnAction(new BotonCimientoEventHandler(unCasillero, botonMapa, juego));

                } else if(elContenido instanceof Cuartel){
                    if (((Cuartel) elContenido).getPropietario() == this.listaJugadores[1]){
                        botonMapa.setId("botonCuartelAzul");
                    }
                    else{botonMapa.setId("botonCuartelRojo");}
                    botonMapa.setOnAction(new BotonCuartelEventHandler(unCasillero, botonMapa, juego));
                } else{
                    botonMapa.setId("botonSuelo");
                    botonMapa.setOnAction(new BotonCasilleroEventHandler(unCasillero, botonMapa));
                }

                this.add(botonMapa, x, y);
            }
        }
        INSTANCIA = this;
        return this;
    }


    public static MapaView getInstancia() {
        return INSTANCIA;
    }

    public void seleccionarCasillero(Posicion posicion) {
        casilleroSeleccionada = posicion;
        if (accionSobreCasilla != null) {
            try {
                accionSobreCasilla.realizarAccion(this, casilleroSeleccionada );
            } catch (PartidaTerminada e){

                String rutaSonido = "/vista/sonidos/reparar.mp3";
                AudioClip sonidoVictoria = new AudioClip(
                        BotonEventHandler.class.getResource(rutaSonido).toExternalForm()
                );

                sonidoVictoria.play();

                JuegoVista juegoVista = JuegoVista.getInstancia();
                juegoVista.actualizar(juego);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("El jugador "+ e.getJugador().getNombre() + " gano la partida!");
                alert.showAndWait();

                this.aplicacion.restart();
            }
        }
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setAccionSobreCasilla(AccionSobreCasilla accion) {
        this.accionSobreCasilla = accion;
    }

    public Juego getJuego() {
        return this.juego;
    }
    
}
