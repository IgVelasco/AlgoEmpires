package vista;

import controlador.BotonTurnosEventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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

        Image fondo = new Image("/vista/imagenes/fondo_madera.JPG");
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);

        this.setBackground(new Background(new BackgroundImage(fondo,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                bSize)));

        this.botonTurnos.setOnAction(new BotonTurnosEventHandler(this.juego, vistaJuego));
        if(jugadores[0] == unJuego.getJugadorActual())
            botonTurnos.setStyle("-fx-background-color: #ff0b0c");
        else
            botonTurnos.setStyle("-fx-background-color: rgb(14,71,255)");
        botonTurnos.setFont(Font.font ("Verdana", 15));
        botonTurnos.setTextFill(Color.WHITE);


        String oro = Integer.toString(unJuego.getJugadorActual().getOro());
        String nombreUsuario = unJuego.getJugadorActual().getNombre();



        String output = String.format("Turno del jugador: %s" ,nombreUsuario);

        informacionUsuario.setText(output);
        informacionUsuario.setFont(Font.font ("Verdana", 20));
        informacionUsuario.setFill(Color.WHITE);
        //this.setStyle("-fx-background-color: rgba(162,56,22,0.87)");
        this.setCenter(this.botonTurnos);
        this.setBottom(this.informacionUsuario);
    }
}
