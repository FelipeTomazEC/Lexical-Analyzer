package br.ufop.tomaz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(Main.class.getResource("/br/ufop/tomaz/fxml/FXMLMain.fxml"));
        Scene scene = new Scene(root, 800,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lexical Analyzer");
        primaryStage.show();
    }
}
