package vista;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import modelo.juego.Juego;


public class UtilidadView extends BorderPane {
    private Juego juego;
    private static UtilidadView INSTANCIA;
    private Button botonTurnos = new Button("Finalizar Turno");
    private Text informacionUsuario = new Text("Aca va la informacion del usuario");

    public UtilidadView(Juego unJuego){
        juego = unJuego;

        this.setCenter(this.botonTurnos);
        this.setBottom(this.informacionUsuario);

    }
}
