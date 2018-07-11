package application;
	
import gui.viewMain;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			final Stage stageRef = primaryStage;
			Font.loadFont(getClass().getResource("/resources/fontawesome-webfont.ttf").toExternalForm(), 20);
			System.out.println(getClass().getResource("/resources/LeiderGeil.mp3").toExternalForm());
			viewMain root = new viewMain(stageRef);

			Scene scene = new Scene(root, 800, 800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());			

			stageRef.setScene(scene);
			stageRef.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
