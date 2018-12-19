package vista;

import controlador.BotonTurnosEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import modelo.juego.Juego;
import modelo.juego.Jugador;


public class UtilidadView extends BorderPane {
    private Juego juego;
    private static UtilidadView INSTANCIA;
    private Button botonTurnos = new Button("Finalizar Turno");
    private Text informacionUsuario = new Text("Aca va la informacion del usuario");

    public UtilidadView(Juego unJuego, JuegoVista vistaJuego){
        juego = unJuego;
        Jugador jugadores[] = unJuego.getJugadores();




        this.botonTurnos.setOnAction(new BotonTurnosEventHandler(this.juego, vistaJuego));
        if(jugadores[0] == unJuego.getJugadorActual())
            botonTurnos.setStyle("-fx-background-color: #ff0b0c");
        else
            botonTurnos.setStyle("-fx-background-color: #0c21ff");


        String oro = Integer.toString(unJuego.getJugadorActual().getOro());
        String nombreUsuario = unJuego.getJugadorActual().getNombre();



        String output = String.format("Turno del jugador: %s" ,nombreUsuario);

        informacionUsuario.setText(output);
        this.setStyle("-fx-background-color: rgba(49,0,49,0.53)");
        this.setCenter(this.botonTurnos);
        this.setBottom(this.informacionUsuario);
    }
}
