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
import modelo.estructuras.Castillo;
import modelo.estructuras.Cimiento;
import modelo.estructuras.Cuartel;
import modelo.estructuras.PlazaCentral;

public class MostrarInformacionCimientoHandler implements EventHandler<ActionEvent> {
    private Cimiento unCimiento;
    private Text tipo_elemento = new Text("Tipo de estructura: Cimiento");
    private Text correspondiente = new Text();
    private Text propietario = new Text();
    private Text turnos_restantes = new Text();

    public MostrarInformacionCimientoHandler(Cimiento cimiento) {
        this.unCimiento = cimiento;

        tipo_elemento.setFont(Font.font ("Verdana", 15));
        tipo_elemento.setFill(Color.WHITE);

        correspondiente.setFont(Font.font ("Verdana", 15));
        correspondiente.setFill(Color.WHITE);

        propietario.setFont(Font.font ("Verdana", 15));
        propietario.setFill(Color.WHITE);

        turnos_restantes.setFont(Font.font ("Verdana", 15));
        turnos_restantes.setFill(Color.WHITE);
    }

    @Override
    public void handle(ActionEvent event) {
        if(unCimiento.getFuturaEstructura() instanceof PlazaCentral){
            correspondiente.setText("Corresponde a: Plaza Central");
        }
        else if(unCimiento.getFuturaEstructura() instanceof Cuartel){
            correspondiente.setText("Corresponde a: Cuartel");
        }

        propietario.setText(String.format("Pertenece a: %s",unCimiento.getPropietario().getNombre()));
        turnos_restantes.setText(String.format("Turnos bastantes: %d",unCimiento.getTurnosRestantes()));

        BorderPane borderPane = new BorderPane();
        VBox lista = new VBox();
        lista.getChildren().addAll(tipo_elemento,correspondiente,propietario,turnos_restantes);

        borderPane.setCenter(lista);

        borderPane.setId("informacion");
        Scene scene = new Scene(borderPane);

        scene.getStylesheets().addAll("file:src/vista/styleInformacion.css");

        Stage newWindow = new Stage();
        newWindow.setTitle("Infomacion de Cimiento");
        newWindow.setScene(scene);

        newWindow.show();

    }
}
