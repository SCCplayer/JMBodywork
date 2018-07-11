package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class NodeMenuBar extends FlowPane {
	public NodeMenuBar(Stage stageRef) {
		// TODO Auto-generated constructor stub
		this.setAlignment(Pos.CENTER_RIGHT);
		Label labelExpand = new Label("\uf065");
		labelExpand.getStyleClass().add("menuBar");
		this.getChildren().add(labelExpand);
		stageRef.fullScreenProperty().addListener((ov, oldValue, newValue) -> {
			if (newValue == true) {
				labelExpand.setText("\uf066");
			} else if (newValue == false) {
				labelExpand.setText("\uf065");
			}
		});

		labelExpand.setOnMouseClicked(c -> {
			if (stageRef.isFullScreen() == false) {
				stageRef.setFullScreen(true);
			} else if (stageRef.isFullScreen() == true) {
				stageRef.setFullScreen(false);
			}
		});
	}

}
