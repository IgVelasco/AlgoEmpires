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
import modelo.estados.ataque.ArmaCargada;
import modelo.unidades.*;


public class MostrarInformacionUnidadHandler implements EventHandler<ActionEvent> {
    private UnidadMovil unidad;
    private Text tipo_unidad = new Text();
    private Text vida_actual = new Text();
    private Text estado_actual = new Text("Sin estado");
    private Text propietario = new Text();



    public MostrarInformacionUnidadHandler(UnidadMovil unidadMovil) {
        this.unidad = unidadMovil;

        tipo_unidad.setFont(Font.font ("Verdana", 15));
        tipo_unidad.setFill(Color.WHITE);

        vida_actual.setFont(Font.font ("Verdana", 15));
        vida_actual.setFill(Color.WHITE);

        estado_actual.setFont(Font.font ("Verdana", 15));
        estado_actual.setFill(Color.WHITE);

        propietario.setFont(Font.font ("Verdana", 15));
        propietario.setFill(Color.WHITE);
    }

    @Override
    public void handle(ActionEvent event) {
        if(unidad instanceof Aldeano){
            tipo_unidad.setText("Tipo de unidad: Aldeano\n");
            vida_actual.setText(String.format("Vida actual: %d\n",((Aldeano) unidad).getVida()));
            if(((Aldeano) unidad).getEstado() instanceof GenerandoOro){
                estado_actual.setText("Estado actual: Generando Oro\n");
            }
            else if (((Aldeano) unidad).getEstado() instanceof Construyendo){
                estado_actual.setText("Estado actual: Construyendo\n");
            }
            else{
                estado_actual.setText("Estado actual: Reparando\n");
            }
        }
        else if(unidad instanceof Arquero){
            tipo_unidad.setText("Tipo de unidad: Arquero\n");
            vida_actual.setText(String.format("Vida actual: %d\n",((Arquero) unidad).getVida()));
        }
        else if(unidad instanceof Espadachin){
            tipo_unidad.setText("Tipo de unidad: Espadachin\n");
            vida_actual.setText(String.format("Vida actual: %d\n",((Espadachin) unidad).getVida()));
        }
        else if(unidad instanceof ArmaDeAsedio){
            tipo_unidad.setText("Tipo de unidad: Arma de Asedio\n");
            vida_actual.setText(String.format("Vida actual: %d\n",((ArmaDeAsedio) unidad).getVida()));
            if(((ArmaDeAsedio) unidad).getEstado() instanceof ArmaCargada){
                estado_actual.setText("Estado: Cargada, lista para atacar");
            }
            else{
                estado_actual.setText("Estado: Descargada, lista para moverse");
            }
        }

        propietario.setText(String.format("Pertenece a: %s\n",unidad.getPropietario().getNombre()));

        BorderPane borderPane = new BorderPane();
        VBox lista = new VBox();
        lista.getChildren().addAll(tipo_unidad,vida_actual,propietario,estado_actual);

        borderPane.setCenter(lista);

        borderPane.setId("informacion");
        Scene scene = new Scene(borderPane);

        scene.getStylesheets().addAll("file:src/vista/styleInformacion.css");

        Stage newWindow = new Stage();
        newWindow.setTitle("Infomacion de unidad");
        newWindow.setScene(scene);

        newWindow.show();

    }
}
