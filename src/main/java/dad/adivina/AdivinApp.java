package dad.adivina;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {

	private Label adivina;
	private Button adivinaButton;
	private TextField texto;
	private int numAdivinar = (int) (Math.random() * 100) + 1;
	private int numIntentos = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(numAdivinar);
		texto = new TextField();
		texto.setPromptText("Texto");
		texto.setMaxWidth(150);

		adivinaButton = new Button("Comprobar");
		adivinaButton.setDefaultButton(true);
		adivinaButton.setOnAction(e -> onadivinaButtonAction(e));

		adivina = new Label("Introduce un número del 1 al 100");

		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(adivina, texto, adivinaButton);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void onadivinaButtonAction(ActionEvent e) {

		try {
			int numIntroducido;
			numIntroducido = Integer.parseInt(texto.getText());

			Alert alertW = new Alert(AlertType.WARNING);

			if (numIntroducido < 1 || numIntroducido > 100) {

				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("Error");
				alert.setContentText("El número introducido no es válido");
				alert.showAndWait();
			}
			if (numIntroducido == numAdivinar) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has ganado!");
				alert.setContentText("Solo has necesitado " + numIntentos + " intentos.\n" + "Vuelve a jugar y hazlo mejor.");
				alert.setContentText("Vuelve a jugar y hazlo mejor.");
				alert.showAndWait();

			} else if (numIntroducido != numAdivinar) {

				alertW.setTitle("AdivinApp");
				alertW.setHeaderText("¡Has fallado!");

				if (numAdivinar >= 50) {
					numIntentos++;
					Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText("¡Has fallado!");
					alert.setContentText("El número a adivinar es mayor a 50");
					alert.showAndWait();
				} else {
					numIntentos++;
					Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText("¡Has fallado!");
					alert.setContentText("El número a adivinar es menor a 50");
					alert.showAndWait();
				}

				numIntentos++;
			}
		} catch (Exception x) {
			x.printStackTrace();

		}

	}

	public static void main(String[] args) {
		launch(args);

	}

}
