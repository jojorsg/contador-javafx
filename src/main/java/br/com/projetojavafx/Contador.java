package br.com.projetojavafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contador extends Application {

    private int contador = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label labelTitulo = new Label("Contador");
        Label labelNumero = new Label("0");

        Button botaoDecremento = new Button("-");
        botaoDecremento.setOnAction(e -> {
            contador--;
            labelNumero.setText(Integer.toString(contador));
        });
        Button botaoIncremento = new Button("+");
        botaoIncremento.setOnAction(e -> {
            contador++;
            labelNumero.setText(Integer.toString(contador));
        });

        HBox boxBotoes = new HBox();
        boxBotoes.setAlignment(Pos.CENTER);
        boxBotoes.setSpacing(10);
        boxBotoes.getChildren().add(botaoDecremento);
        boxBotoes.getChildren().add(botaoIncremento);

        VBox boxConteudo = new VBox();
        boxConteudo.getStyleClass().add("conteudo");
        boxConteudo.setAlignment(Pos.CENTER);
        boxConteudo.setSpacing(10);
        boxConteudo.getChildren().add(labelTitulo);
        boxConteudo.getChildren().add(labelNumero);
        boxConteudo.getChildren().add(boxBotoes);

        String caminhoCss = getClass()
                .getResource("/src/main/java/br/com/projetojavafx/Contador.css").toExternalForm();

        Scene cenaPrincipal = new Scene(boxConteudo, 400, 400);
        cenaPrincipal.getStylesheets().add(caminhoCss);

        primaryStage.setScene(cenaPrincipal);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
