package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import modelo.espacio.Contenible;
import modelo.espacio.Posicion;
import modelo.excepciones.ContenibleDelMismoJugador;
import modelo.excepciones.ContenibleFueraDeRango;
import modelo.excepciones.ContenibleNoPropia;
import modelo.excepciones.UnidadYaAtaco;
import modelo.juego.Juego;
import modelo.unidades.Arquero;
import modelo.unidades.Atacante;
import modelo.unidades.Infanteria;
import vista.JuegoVista;
import vista.MapaView;

public class AtacarHandler extends AccionSobreCasilla implements EventHandler<ActionEvent>{
    Atacante atacante;
    Juego juego;

    public AtacarHandler(Atacante unAtacante, Juego unJuego) {
        atacante = unAtacante;
        juego = unJuego;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();
        mapaView.setAccionSobreCasilla(this);
    }

    @Override
    public void realizarAccion(MapaView mapaView, Posicion posicion) {
        Contenible unContenible = mapaView.getMapa().getContenido(posicion.getPosX(), posicion.getPosY());
        try {
            atacante.atacar(unContenible, juego.getJugadorActual());
        } catch (ContenibleNoPropia e) {
            alertar("¡No te pertence!");
        } catch (UnidadYaAtaco e) {
            alertar("¡Ya atacó!");
        } catch (ContenibleFueraDeRango e) {
            alertar("¡Fuera de rango!");
        } catch (ContenibleDelMismoJugador e) {
            alertar("¡Unidad propia!");
        }
        
        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(juego);
    }
}
