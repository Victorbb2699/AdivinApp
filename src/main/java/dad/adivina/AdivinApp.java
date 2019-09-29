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
		boolean Adivinado = false;
		int numIntroducido;
		numIntroducido = Integer.parseInt(texto.getText());
		while (Adivinado != true) {
			if (numIntroducido < 1 || numIntroducido > 100) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("Error");
				alert.setContentText("El número introducido no es válido");
				alert.showAndWait();
				Adivinado = true;
			} else if (numIntroducido == numAdivinar) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has ganado!");
				alert.setContentText("Solo has necesitado " + numIntentos);
				alert.showAndWait();

				Adivinado = true;
			} else if (numIntroducido != numAdivinar) {
				numIntentos++;
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has fallado!");

				if (numIntroducido > numAdivinar) {
					alert.setContentText("El numero a adivinar es menor que " + numIntroducido);
				} else {
					alert.setContentText("El numero a adivinar es mayor que " + numIntroducido);
				}
				alert.showAndWait();
			}

		}

	}

	public static void main(String[] args) {
		launch(args);

	}

}
