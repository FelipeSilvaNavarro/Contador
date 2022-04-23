package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contador extends Application {

	// Int p/ Alteração do valor do contador
	private int contador = 0;

	// Atualizar o número do label
	private void attLabelNum(Label label) {
		label.setText(Integer.toString(contador));
		label.getStyleClass().remove("verde");
		label.getStyleClass().remove("vermelho");
		if (contador > 0) {
			label.getStyleClass().add("verde");
		} else if (contador < 0) {
			label.getStyleClass().add("vermelho");
		}
	}

	// Atualizar parOuImpar

	private int parOuImpar(Label label) {
		String getTexto = label.getText();
		int i = Integer.parseInt(getTexto);
		return i % 2;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Criação dos Labels
		Label labelTitulo = new Label("Contador");
		Label labelNum = new Label("0");
		Label labelParOuImpar = new Label("Par");
		// Criação dos botões
		Button botaoDecremento = new Button("-");
		Button botaoIncremento = new Button("+");
		Button botaoClaroEscuro = new Button("Claro");
		// Criação caixa Horizontal de botoes
		HBox boxBotoes = new HBox();
		boxBotoes.getChildren().add(botaoDecremento);
		boxBotoes.getChildren().add(botaoIncremento);
		// Criação e implementação do BOX
		HBox BoxHori = new HBox();
		VBox boxConteudo = new VBox();
		boxConteudo.getChildren().add(labelTitulo);
		boxConteudo.getChildren().add(labelNum);
		boxConteudo.getChildren().add(boxBotoes);
		boxConteudo.getChildren().add(labelParOuImpar);
		boxConteudo.getChildren().add(BoxHori);
		BoxHori.getChildren().add(botaoClaroEscuro);
		// Configuração das BOX
		boxBotoes.setAlignment(Pos.CENTER);
		boxBotoes.setSpacing(10);
		boxConteudo.setAlignment(Pos.CENTER);
		boxConteudo.setSpacing(10);
		BoxHori.setAlignment(Pos.TOP_CENTER);
		// Configuração dos BOTÕES
		botaoDecremento.setOnAction(e -> {
			contador--;
			attLabelNum(labelNum);
			// Par impar
			if (parOuImpar(labelNum) == 0) {
				labelParOuImpar.getStyleClass().remove("impar");
				labelParOuImpar.getStyleClass().remove("parimpar");
				labelParOuImpar.setText("Par");
				labelParOuImpar.getStyleClass().add("par");
			} else {
				labelParOuImpar.getStyleClass().remove("par");
				labelParOuImpar.getStyleClass().remove("parimpar");
				labelParOuImpar.setText("Impar");
				labelParOuImpar.getStyleClass().add("impar");
			}
		});
		botaoIncremento.setOnAction(e -> {
			contador++;
			attLabelNum(labelNum);
			if (parOuImpar(labelNum) == 0) {
				labelParOuImpar.getStyleClass().remove("impar");
				labelParOuImpar.getStyleClass().remove("parimpar");
				labelParOuImpar.setText("Par");
				labelParOuImpar.getStyleClass().add("par");
			} else {
				labelParOuImpar.getStyleClass().remove("parimpar");
				labelParOuImpar.getStyleClass().remove("par");
				labelParOuImpar.setText("Impar");
				labelParOuImpar.getStyleClass().add("impar");
			}
		});
		// Configuração do CSS das BOX
		boxConteudo.getStyleClass().add("conteudo");
		// Configuração do CSS das LABEL
		labelNum.getStyleClass().add("numero");
		labelTitulo.getStyleClass().add("titulo");
		labelParOuImpar.getStyleClass().add("parimpar");
		// Configuração do CSS dos BOTÕES
		botaoDecremento.getStyleClass().add("botoes");
		botaoIncremento.getStyleClass().add("botoes");
		// Chamar o CSS
		String caminhoDoCss = getClass().getResource("/basico/Contador.css").toExternalForm();
		// Chamar a cena e dizer oque ela encenar
		Scene cenaPrincipal = new Scene(boxConteudo, 400, 400);
		// Ativar o CSS no CONTADOR
		cenaPrincipal.getStylesheets().add(caminhoDoCss);
		// Configução do CSS no CONTADOR
		cenaPrincipal.getStylesheets().add("https://fonts.googleapis.com/css2?family=Oswald");
		// Setar a cena
		primaryStage.setScene(cenaPrincipal);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
