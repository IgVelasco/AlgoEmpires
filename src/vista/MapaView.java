package vista;

import controlador.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import modelo.espacio.Casillero;
import modelo.espacio.Contenible;
import modelo.espacio.Mapa;
import modelo.espacio.Posicion;
import modelo.estructuras.Castillo;
import modelo.estructuras.Cimiento;
import modelo.estructuras.Cuartel;
import modelo.estructuras.PlazaCentral;
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
    private AccionSobreCasilla accionSobreCasilla;


    public MapaView(Mapa mapa){
        this.setAlignment(Pos.CENTER);
        INSTANCIA = this;
        this.casilleroSeleccionada = null;
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
                    botonMapa.setId("botonAldeano");
                    botonMapa.setOnAction(new BotonAldeanoEventHandler(unCasillero, botonMapa));

                } else if (elContenido instanceof Castillo) {
                    botonMapa.setId("botonCastillo");
                    botonMapa.setOnAction(new BotonCastilloEventHandler(unCasillero, botonMapa));
                } else if (elContenido instanceof PlazaCentral) {
                    botonMapa.setId("botonPlazaCentral");
                    botonMapa.setOnAction(new BotonPlazaCentralEventHandler(unCasillero, botonMapa));

                } else if (elContenido instanceof ArmaDeAsedio){
                    botonMapa.setId("botonArmaDeAsedio");
                    botonMapa.setOnAction(new BotonArmaDeAsedioEventHandler(unCasillero, botonMapa));

                }else if (elContenido instanceof Espadachin){
                    botonMapa.setId("botonAldeano");
                    botonMapa.setOnAction(new BotonEspadachinEventHandler(unCasillero, botonMapa));

                } else if(elContenido instanceof Arquero){
                    botonMapa.setId("botonArquero");
                    botonMapa.setOnAction(new BotonArqueroEventHandler(unCasillero, botonMapa));

                } else if(elContenido instanceof Cimiento){
                    botonMapa.setId("botonCimiento");
                    botonMapa.setOnAction(new BotonCimientoEventHandler(unCasillero, botonMapa));

                } else if(elContenido instanceof Cuartel){
                    botonMapa.setId("botonCuartel");
                    botonMapa.setOnAction(new BotonCuartelEventHandler(unCasillero, botonMapa));
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

    public Posicion getDestino() {
     //   if( casilleroSeleccionada == null)
       //     throw new CasilleroNoSeleccionadoException();
        System.out.println(casilleroSeleccionada);
        return casilleroSeleccionada;
    }

    public void seleccionarCasillero(Posicion posicion) {
        casilleroSeleccionada = posicion;
        if (accionSobreCasilla != null) {
            accionSobreCasilla.realizarAccion(this);
        }
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setAccionSobreCasilla(AccionSobreCasilla accion) {
        this.accionSobreCasilla = accion;
    }
}
