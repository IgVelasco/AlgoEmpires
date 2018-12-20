package controlador;

import javafx.scene.control.Alert;
import modelo.espacio.Posicion;
import vista.MapaView;

public abstract class AccionSobreCasilla {
    public abstract void realizarAccion(MapaView mapaView, Posicion posicion);

    void alertar(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
