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
    private Text informacionOro = new Text();
    private Text informacionPoblacion = new Text();
    private Text informacionCastillo = new Text();

    public UtilidadView(Juego unJuego, JuegoVista vistaJuego){
        juego = unJuego;
        Jugador jugadores[] = unJuego.getJugadores();

        Image fondo = new Image("/vista/imagenes/fondo_madera.jpg");
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);

        this.setBackground(new Background(new BackgroundImage(fondo,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                bSize)));

        this.botonTurnos.setOnAction(new BotonTurnosEventHandler(this.juego, vistaJuego));
        if(jugadores[0] == unJuego.getJugadorActual())
            botonTurnos.setStyle("-fx-background-color: rgb(255,19,37)");
        else
            botonTurnos.setStyle("-fx-background-color: rgb(14,71,255)");
        botonTurnos.setFont(Font.font ("Verdana", 15));
        botonTurnos.setTextFill(Color.WHITE);

        String oro = Integer.toString(unJuego.getJugadorActual().getOro());
        String nombreUsuario = unJuego.getJugadorActual().getNombre();
        String poblacion = Integer.toString(unJuego.getJugadorActual().getPoblacionActual());
        String vida_castillo = Integer.toString(unJuego.getJugadorActual().getCastillo().getVida());



        String output = String.format("Turno del jugador: %s" ,nombreUsuario);
        String output_oro = String.format("Oro disponible: %s" , oro);
        String output_poblacion = String.format("Poblacion: %s" , poblacion);
        String output_vida_castillo = String.format("Vida de Castillo: %s" , vida_castillo);

        informacionUsuario.setText(output);
        informacionUsuario.setFont(Font.font ("Verdana", 15));
        informacionUsuario.setFill(Color.WHITE);

        informacionOro.setText(output_oro);
        informacionOro.setFont(Font.font ("Verdana", 15));
        informacionOro.setFill(Color.WHITE);

        informacionPoblacion.setText(output_poblacion);
        informacionPoblacion.setFont(Font.font ("Verdana", 15));
        informacionPoblacion.setFill(Color.WHITE);

        informacionCastillo.setText(output_vida_castillo);
        informacionCastillo.setFont(Font.font ("Verdana", 15));
        informacionCastillo.setFill(Color.WHITE);

        VBox textos = new VBox();
        textos.getChildren().addAll(informacionUsuario,informacionOro,informacionPoblacion,informacionCastillo);

        this.setCenter(this.botonTurnos);
        this.setBottom(textos);
    }
}
