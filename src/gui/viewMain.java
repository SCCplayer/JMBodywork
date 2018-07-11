package gui;

import application.ControllerMain;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class viewMain extends BorderPane {
	
	public viewMain(Stage stageRef) {
		NodeDragMusicfolder plAktivView = new NodeDragMusicfolder("Playlist Aktiv");
		NodeDragMusicfolder plPauseView = new NodeDragMusicfolder("Playlist Pause");
		
		ControllerMain cm = new ControllerMain(plAktivView.getListMusicFiles(), plPauseView.getListMusicFiles());
		
		NodeMenuBar barTop = new NodeMenuBar(stageRef);
		this.setTop(barTop);
		
		GridPane gpCenter = new GridPane();


		gpCenter.add(plAktivView, 0, 0);
		gpCenter.add(plPauseView, 1, 0);

		this.setCenter(gpCenter);
		
		NodeFooterBar barFooter = new NodeFooterBar(cm);
		this.setBottom(barFooter);
	}

}
