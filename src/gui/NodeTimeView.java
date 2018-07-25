package gui;

import application.ControllerMain;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class NodeTimeView extends BorderPane {
	private Label lblZeitAnzeige;
	private Label lblRunde = new Label("Runde");
	private Label lblRundeAktuell = new Label("1");
	private Label lblRundeVon = new Label("von");
	private Label lblRundenMax = new Label("3");
	private Label lblStation = new Label("Station");
	private Label lblStationAktuell = new Label("1");
	private Label lblStationVon = new Label("von");
	private Label lblStationMax = new Label("14");
	private Label lblTop = new Label("Startverzögerung");

	private BorderPane bpTop = new BorderPane();
	private BorderPane bpBottom = new BorderPane();
	private FlowPane fpLeft = new FlowPane();
	private FlowPane fpRight = new FlowPane();

	public NodeTimeView(ControllerMain cm) {
		// TODO Auto-generated constructor stub
		lblZeitAnzeige = new Label(String.valueOf(cm.getIntProbStartDelay().intValue()));
		lblRundenMax.setText(String.valueOf(cm.getIntProbAnzahlRunden().intValue()));
		lblStationMax.setText(String.valueOf(cm.getIntProbAnzahlStation().intValue()));
		lblTop.getStyleClass().add("lblTop");
		bpTop.setCenter(lblTop);

		lblZeitAnzeige.getStyleClass().add("labelZeitanzeige");
		lblRunde.getStyleClass().add("lblBottom");
		lblRundeAktuell.getStyleClass().add("lblBottom");
		lblRundenMax.getStyleClass().add("lblBottom");
		lblRundeVon.getStyleClass().add("lblBottom");
		lblStation.getStyleClass().add("lblBottom");
		lblStationAktuell.getStyleClass().add("lblBottom");
		lblStationMax.getStyleClass().add("lblBottom");
		lblStationVon.getStyleClass().add("lblBottom");

		fpLeft.getChildren().addAll(lblRunde, lblRundeAktuell, lblRundeVon, lblRundenMax);
		fpRight.getChildren().addAll(lblStation, lblStationAktuell, lblStationVon, lblStationMax);

		fpRight.getStyleClass().add("fpRight");
		fpLeft.getStyleClass().add("fpLeft");

		bpBottom.setLeft(fpLeft);
		bpBottom.setRight(fpRight);

		this.getStyleClass().add("bpZeitanzeige");
		this.setTop(bpTop);
		this.setCenter(lblZeitAnzeige);
		this.setBottom(bpBottom);

	}

	public Label getLblZeitanzeige() {
		return lblZeitAnzeige;
	}

	public Label getLblTop() {
		return lblTop;
	}

	public Label getLblStationAktuell() {
		return lblStationAktuell;
	}

	public Label getLblStationMax() {
		return lblStationMax;
	}

	public Label getLblRundeAktuell() {
		return lblRundeAktuell;
	}

	public Label getLblRundeMax() {
		return lblRundenMax;
	}

}
