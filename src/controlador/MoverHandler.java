package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.espacio.Posicion;
import modelo.excepciones.*;
import modelo.juego.Juego;
import modelo.unidades.UnidadMovil;
import vista.JuegoVista;
import vista.MapaView;

public class MoverHandler extends AccionSobreCasilla  implements EventHandler<ActionEvent> {
    UnidadMovil unidad;
    Juego juego;

    public MoverHandler(UnidadMovil unaUnidad, Juego unJuego) {
        unidad = unaUnidad;
        juego = unJuego;
    }

    @Override
    public void handle(ActionEvent event){
        MapaView mapaView = MapaView.getInstancia();
        mapaView.setAccionSobreCasilla(this);
    }

    @Override
    public void realizarAccion(MapaView mapaView, Posicion posicion){
        try {
            unidad.realizarMovimiento(mapaView.getMapa(), posicion.getPosX(), posicion.getPosY(), juego.getJugadorActual());
        } catch (CasilleroOcupado e) {
            alertar("¡Casillero ocupado!");
        } catch (ContenibleNoPropia e) {
            alertar("¡No te pertence!");
        } catch (ExcedeLimiteDelMapa e) {
            alertar("¡Límite del mapa alcanzado!");
        } catch (MovimientoFueraDeRango e) {
            alertar("¡Fuera de rango!");
        } catch (UnidadYaUtilizada e) {
            alertar("¡Unidad ya utilizada!");
        } catch (ArmaCargadaNoSePuedeMover e){
            alertar("El arma esta cargada y no se puede mover!");
        } catch (AldeanoOcupado e){
            alertar("Aldeano ocupado!");
        }

        JuegoVista juegoVista = JuegoVista.getInstancia();
        juegoVista.actualizar(juego);

    }

}
