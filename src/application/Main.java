package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
			primaryStage.setTitle("CXL/TPT Adapter Command Utlity");
			Image im = new Image("bulb.PNG");
			primaryStage.getIcons().add(im);
			Scene scene = new Scene(root);
			scene.getStylesheets().add("application.css");
			primaryStage.setScene(scene);
			primaryStage.setMaximized(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
