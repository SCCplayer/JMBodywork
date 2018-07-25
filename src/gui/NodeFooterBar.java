package gui;

import application.ControllerMain;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.converter.NumberStringConverter;

public class NodeFooterBar extends BorderPane {

	private GridPane gp = new GridPane();
	private StackPane sp = new StackPane();

	private Label lblZeitAktiv = new Label("Dauer Aktiv");
	private TextFieldDistrictiveTwoDigits tfZeitAktiv = new TextFieldDistrictiveTwoDigits();
	private Label lblSek1 = new Label("Sekunden");
	private Label lblZeitPause = new Label("Dauer Pause");
	private TextFieldDistrictiveTwoDigits tfZeitPause = new TextFieldDistrictiveTwoDigits();
	private Label lblSek2 = new Label("Sekunden");

	private Label lblStartDelay = new Label("Startverzögerung");
	private TextFieldDistrictiveTwoDigits tfStartDelay = new TextFieldDistrictiveTwoDigits();
	private Label lblSek3 = new Label("Sekunden");

	private Label lblAnzahlStationen = new Label("Anzahl Stationen");
	private TextFieldDistrictiveTwoDigits tfAnzahlStationen = new TextFieldDistrictiveTwoDigits();
	private Label lblAnzahlRunden = new Label("Anzahl Runden");
	private TextFieldDistrictiveTwoDigits tfAnzahlRunden = new TextFieldDistrictiveTwoDigits();

	private Label lblRundenPause = new Label("Rundenpause");
	private TextFieldDistrictiveTwoDigits tfRundenPause = new TextFieldDistrictiveTwoDigits();
	private Label lblMin = new Label("Minuten");

	private Button btnStart = new Button("Start");
	private Button btnStop = new Button("Stop");

	public NodeFooterBar(ControllerMain cm) {

		tfZeitAktiv.textProperty().bindBidirectional(cm.getIntProbAktivStartwert(), new NumberStringConverter());
		tfZeitPause.textProperty().bindBidirectional(cm.getIntProbPauseStartwert(), new NumberStringConverter());
		tfStartDelay.textProperty().bindBidirectional(cm.getIntProbStartDelay(), new NumberStringConverter());
		tfAnzahlStationen.textProperty().bindBidirectional(cm.getIntProbAnzahlStation(), new NumberStringConverter());
		tfAnzahlRunden.textProperty().bindBidirectional(cm.getIntProbAnzahlRunden(), new NumberStringConverter());
		tfRundenPause.textProperty().bindBidirectional(cm.getIntProbRundenPause(), new NumberStringConverter());

		// TODO Auto-generated constructor stub
		gp.add(lblStartDelay, 0, 0);
		gp.add(tfStartDelay, 1, 0);
		gp.add(lblSek3, 2, 0);
		gp.add(lblZeitAktiv, 0, 1);
		gp.add(tfZeitAktiv, 1, 1);
		gp.add(lblSek1, 2, 1);

		gp.add(lblZeitPause, 0, 2);
		gp.add(tfZeitPause, 1, 2);
		gp.add(lblSek2, 2, 2);
		gp.add(lblAnzahlStationen, 4, 0);
		gp.add(tfAnzahlStationen, 5, 0);
		gp.add(lblAnzahlRunden, 4, 1);
		gp.add(tfAnzahlRunden, 5, 1);

		gp.add(lblRundenPause, 4, 2);
		gp.add(tfRundenPause, 5, 2);
		gp.add(lblMin, 6, 2);

		btnStop.setVisible(false);

		sp.getChildren().add(btnStop);
		sp.getChildren().add(btnStart);

		sp.setMargin(btnStart, new Insets(20, 20, 20, 0));
		sp.setAlignment(Pos.CENTER_RIGHT);

		this.setBottom(sp);
		this.setCenter(gp);

		tfStartDelay.getStyleClass().add("standardTextbox");
		tfRundenPause.getStyleClass().add("standardTextbox");
		tfZeitAktiv.getStyleClass().add("standardTextbox");
		tfAnzahlStationen.getStyleClass().add("standardTextbox");
		tfAnzahlRunden.getStyleClass().add("standardTextbox");
		tfZeitPause.getStyleClass().add("standardTextbox");
		lblSek1.getStyleClass().add("standardLabel");
		lblSek2.getStyleClass().add("standardLabel");
		lblSek3.getStyleClass().add("standardLabel");
		lblMin.getStyleClass().add("standardLabel");
		lblRundenPause.getStyleClass().add("standardLabel");
		btnStart.getStyleClass().add("standardButton");
		btnStop.getStyleClass().add("standardButton");

		gp.getStyleClass().add("barFooter");
		lblZeitAktiv.getStyleClass().add("standardLabel");
		lblZeitPause.getStyleClass().add("standardLabel");
		lblAnzahlStationen.getStyleClass().add("standardLabel");
		lblAnzahlRunden.getStyleClass().add("standardLabel");
		lblStartDelay.getStyleClass().add("standardLabel");
		// gpCenter.add(plAktivView, 0, 0);
		// gpCenter.add(plPauseView, 1, 0);

		btnStart.setOnAction(a -> {
			System.out.println("btnStart wurde gedrückt");
			btnStart.setVisible(false);
			btnStop.setVisible(true);
			cm.startWorkout();
		});

		btnStop.setOnAction(a -> {
			System.out.println("btnStop wurde gedrückt");
			btnStop.setVisible(false);
			btnStart.setVisible(true);
			cm.stopAll();
			System.out.println(cm.getIntProbAktivStartwert().getValue());
		});

	}

	public void setBtnStopVisible() {
		btnStop.setVisible(true);
	}

	public void setBtnStartVisible() {
		btnStart.setVisible(true);
	}
}
