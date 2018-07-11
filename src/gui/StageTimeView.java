package gui;

import java.io.File;

import application.ControllerMain;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StageTimeView extends Stage {

	public StageTimeView(NodeTimeView ntv, ControllerMain cm) {
		BorderPane root = new BorderPane();
		root.setTop(new NodeMenuBar(this));
		root.setCenter(ntv);
		Scene scene = new Scene(root, 800, 800);
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		this.setOnCloseRequest(e -> {
			cm.stopAll();
		});
		this.setFullScreen(true);
		this.setScene(scene);
		this.show();
	}

}
