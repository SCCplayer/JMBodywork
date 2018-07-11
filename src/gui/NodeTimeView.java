package gui;

import java.io.File;
import java.util.Random;

import application.ControllerMain;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class NodeTimeView extends BorderPane {
	private Label lblZeitAnzeige;
	private Label lblTop = new Label("Startverzögerung");

	private BorderPane bpTop = new BorderPane();

	private int zeitAktiv = 0;
	private int zeitAktivStartwert = 0;
	private int zeitPause = 0;
	private int zeitPauseStartwert = 0;
	private int startDelay = 5;
	private Label lblHeader;


//	private ObservableList<File> listMusicAktiv = null;
//	private ObservableList<File> listMusicPause = null;

	public NodeTimeView(ControllerMain cm) {
		// TODO Auto-generated constructor stub
		this.zeitAktivStartwert = zeitAktiv;
		this.zeitPauseStartwert = zeitPause;
		this.zeitAktiv = zeitAktivStartwert;
		this.zeitPause = zeitPauseStartwert;
//		this.listMusicAktiv = listMusicAktiv;
//		this.listMusicPause = listMusicPause;

		lblTop.getStyleClass().add("lblTop");
		bpTop.setCenter(lblTop);
		this.setTop(bpTop);
		lblZeitAnzeige = new Label(String.valueOf(startDelay));
		lblZeitAnzeige.getStyleClass().add("labelZeitanzeige");
		this.getStyleClass().add("bpZeitanzeige");
		this.setCenter(lblZeitAnzeige);

	}
	
	public Label getLblZeitanzeige() {
		return lblZeitAnzeige;
	}
	
	public Label getLblTop() {
		return lblTop;
	}
}
