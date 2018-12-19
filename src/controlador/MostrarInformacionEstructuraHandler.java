package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.estados.aldeano.Construyendo;
import modelo.estados.aldeano.GenerandoOro;
import modelo.estructuras.Castillo;
import modelo.estructuras.Cuartel;
import modelo.estructuras.Estructura;
import modelo.estructuras.PlazaCentral;
import modelo.unidades.*;

public class MostrarInformacionEstructuraHandler implements EventHandler<ActionEvent> {
    private Estructura estructura;
    private Text tipo_estructura = new Text();
    private Text vida_actual = new Text();
    private Text propietario = new Text();
    private Text queCrea = new Text();

    public MostrarInformacionEstructuraHandler(Estructura estructura) {
        this.estructura = estructura;

        tipo_estructura.setFont(Font.font ("Verdana", 15));
        tipo_estructura.setFill(Color.WHITE);

        vida_actual.setFont(Font.font ("Verdana", 15));
        vida_actual.setFill(Color.WHITE);

        queCrea.setFont(Font.font ("Verdana", 15));
        queCrea.setFill(Color.WHITE);

        propietario.setFont(Font.font ("Verdana", 15));
        propietario.setFill(Color.WHITE);

    }

    @Override
    public void handle(ActionEvent event) {
        if(estructura instanceof Castillo){
            tipo_estructura.setText("Tipo de estructura: Castillo\n");
            vida_actual.setText(String.format("Vida actual: %d\n",((Castillo) estructura).getVida()));
            queCrea.setText("Puede crear: Arma de Asedio\n");
        }
        else if(estructura instanceof PlazaCentral){
            tipo_estructura.setText("Tipo de unidad: Plaza Central\n");
            vida_actual.setText(String.format("Vida actual: %d\n",((PlazaCentral) estructura).getVida()));
            queCrea.setText("Puede crear: Aldeano\n");
        }
        else if(estructura instanceof Cuartel){
            tipo_estructura.setText("Tipo de unidad: Cuartel\n");
            vida_actual.setText(String.format("Vida actual: %d\n",((Cuartel) estructura).getVida()));
            queCrea.setText("Puede crear: Espadachin, Arquero\n");
        }

        propietario.setText(String.format("Pertenece a: %s\n",estructura.getPropietario().getNombre()));

        BorderPane borderPane = new BorderPane();
        VBox lista = new VBox();
        lista.getChildren().addAll(tipo_estructura,vida_actual,propietario,queCrea);

        borderPane.setCenter(lista);

        borderPane.setId("informacion");
        Scene scene = new Scene(borderPane);

        scene.getStylesheets().addAll("file:src/vista/styleInformacion.css");

        Stage newWindow = new Stage();
        newWindow.setTitle("Infomacion de Estructura");
        newWindow.setScene(scene);

        newWindow.show();
    }
}
