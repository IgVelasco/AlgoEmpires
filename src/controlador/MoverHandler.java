package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.espacio.Posicion;
import modelo.unidades.UnidadMovil;
import vista.JuegoVista;
import vista.MapaView;

public class MoverHandler implements EventHandler<ActionEvent>, AccionSobreCasilla {
    UnidadMovil unidad;

    public MoverHandler(UnidadMovil unaUnidad) {
        unidad = unaUnidad;
    }

    @Override
    public void handle(ActionEvent event){
        MapaView mapaView = MapaView.getInstancia();
        mapaView.setAccionSobreCasilla(this);
    }

    @Override
    public void realizarAccion(MapaView mapaView){
        Posicion destino = mapaView.getDestino();
        System.out.println(destino.getPosX());
        unidad.realizarMovimiento(mapaView.getMapa(),destino.getPosX(),destino.getPosY(),unidad.propietario);
        mapaView = mapaView.iniciar(mapaView.getMapa());
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView);

    }




}
