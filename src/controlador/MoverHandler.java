

package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.espacio.Posicion;
import modelo.unidades.Aldeano;
import modelo.unidades.UnidadMovil;
import vista.JuegoVista;
import vista.MapaView;
import javafx.scene.input.MouseEvent;

public class MoverHandler implements EventHandler<ActionEvent> {
    UnidadMovil unidad;

    public MoverHandler(UnidadMovil unaUnidad) {
        unidad = unaUnidad;
    }

    @Override
    public void handle(ActionEvent event){
        MapaView mapaView = MapaView.getInstancia();


        mapaView.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                mover(mapaView);
                mapaView.setOnMouseClicked(null);
            }
        });
    }

    public void mover(MapaView mapaView){
        Posicion destino = mapaView.getDestino();
        System.out.println(destino.getPosX());
        unidad.realizarMovimiento(mapaView.getMapa(),destino.getPosX(),destino.getPosY(),unidad.propietario);
        mapaView = mapaView.iniciar(mapaView.getMapa());
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView);

    }




}
