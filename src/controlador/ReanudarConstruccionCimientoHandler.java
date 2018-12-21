package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import modelo.espacio.Contenible;
import modelo.espacio.Posicion;
import modelo.estructuras.Cimiento;
import modelo.juego.Juego;
import modelo.unidades.Aldeano;
import vista.JuegoVista;
import vista.MapaView;

public class ReanudarConstruccionCimientoHandler extends AccionSobreCasilla implements EventHandler<ActionEvent> {

    Cimiento cimiento;
    Juego unJuego;

    public ReanudarConstruccionCimientoHandler(Cimiento cimiento, Juego juego){
        this.cimiento = cimiento;
        this.unJuego = juego;

    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        mapaView.setAccionSobreCasilla(this);
    }

    public void realizarAccion(MapaView mapaView, Posicion posicion) {
        Contenible unContenible = mapaView.getMapa().getContenido(posicion.getPosX(), posicion.getPosY());

        unJuego.getJugadorActual().reanudarCimiento(this.cimiento, (Aldeano) unContenible);

        String rutaSonido = "/vista/sonidos/reparar.mp3";
        AudioClip sonidoReparar = new AudioClip(
                BotonEventHandler.class.getResource(rutaSonido).toExternalForm()
        );

        sonidoReparar.play();

        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(mapaView.getJuego());
    }
}
