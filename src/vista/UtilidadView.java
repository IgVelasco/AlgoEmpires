package vista;

import controlador.BotonTurnosEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import modelo.juego.Juego;


public class UtilidadView extends BorderPane {
    private Juego juego;
    private static UtilidadView INSTANCIA;
    private Button botonTurnos = new Button("Finalizar Turno");
    private Text informacionUsuario = new Text("Aca va la informacion del usuario");

    public UtilidadView(Juego unJuego, JuegoVista vistaJuego){
        juego = unJuego;


        this.botonTurnos.setOnAction(new BotonTurnosEventHandler(this.juego, vistaJuego));

        String oro = Integer.toString(unJuego.getJugadorActual().getOro());
        String nombreUsuario = unJuego.getJugadorActual().getNombre();

        String output = String.format("Turno del jugador: %s" ,nombreUsuario);

        informacionUsuario.setText(output);

        this.setCenter(this.botonTurnos);
        this.setBottom(this.informacionUsuario);

    }
}
