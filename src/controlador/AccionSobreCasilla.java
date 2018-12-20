package controlador;

import modelo.espacio.Posicion;
import vista.MapaView;

public interface AccionSobreCasilla {
    void realizarAccion(MapaView mapaView, Posicion posicion);
}
