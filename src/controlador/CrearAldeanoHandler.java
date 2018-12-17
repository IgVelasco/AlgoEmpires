package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.espacio.Posicion;
import modelo.estructuras.PlazaCentral;
import modelo.unidades.Aldeano;
import vista.JuegoVista;
import vista.MapaView;

public class CrearAldeanoHandler implements EventHandler<ActionEvent>, AccionSobreCasilla {
    PlazaCentral plazaCentral;

    public CrearAldeanoHandler(PlazaCentral unaPlazaCentral) {
        plazaCentral = unaPlazaCentral;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        mapaView.setAccionSobreCasilla(this);
    }

    public void realizarAccion(MapaView mapaView) {
        Posicion destino = mapaView.getDestino();
        System.out.println(destino.getPosX());
        Aldeano unAldeano = plazaCentral.crearAldeano(1000);
        mapaView.getMapa().colocarUnidadEn(unAldeano, destino.getPosX(), destino.getPosY());
        mapaView = mapaView.iniciar(mapaView.getMapa());
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView);
    }

}
