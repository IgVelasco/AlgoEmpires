package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.espacio.Posicion;
import modelo.estructuras.Castillo;
import modelo.unidades.ArmaDeAsedio;
import vista.JuegoVista;
import vista.MapaView;

public class CrearArmaDeAsedioHandler implements EventHandler<ActionEvent>, AccionSobreCasilla {
    Castillo castillo;

    public CrearArmaDeAsedioHandler(Castillo unCastillo) {
        castillo = unCastillo;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        mapaView.setAccionSobreCasilla(this);
    }

    public void realizarAccion(MapaView mapaView) {
        Posicion destino = mapaView.getDestino();
        System.out.println(destino.getPosX());
        ArmaDeAsedio unArma = castillo.crearArmaDeAsedio(castillo.getPropietario().getOro());
        mapaView.getMapa().colocarUnidadEn(unArma, destino.getPosX(), destino.getPosY());
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView.getJuego());
    }
}
