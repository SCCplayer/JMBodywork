package gui;

import application.ControllerMain;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.util.converter.NumberStringConverter;

public class NodeFooterBar extends GridPane {
	private Label lblZeitAktiv = new Label("Dauer Aktiv");
	private TextField tfZeitAktiv = new TextField("10");
	private Label lblSek1 = new Label("Sekunden");
	private Label lblZeitPause = new Label("Dauer Pause");
	private TextField tfZeitPause = new TextField("10");
	private Label lblSek2 = new Label("Sekunden");

	private Button btnStart = new Button("Start");
	private Button btnStop = new Button("Stop");


	public NodeFooterBar(ControllerMain cm) {

		tfZeitAktiv.textProperty().bindBidirectional(cm.getIntProbAktivStartwert(), new NumberStringConverter());
		tfZeitPause.textProperty().bindBidirectional(cm.getIntProbPauseStartwert(), new NumberStringConverter());

		// TODO Auto-generated constructor stub
		this.add(lblZeitAktiv, 0, 0);
		this.add(tfZeitAktiv, 1, 0);
		this.add(lblSek1, 2, 0);
		tfZeitAktiv.getStyleClass().add("standardTextbox");
		this.add(lblZeitPause, 0, 1);
		this.add(tfZeitPause, 1, 1);
		this.add(lblSek2, 2, 1);
		this.add(btnStop, 3, 1);
		this.add(btnStart, 4, 1);
		tfZeitPause.getStyleClass().add("standardTextbox");
		lblSek1.getStyleClass().add("standardLabel");
		lblSek2.getStyleClass().add("standardLabel");
		btnStart.getStyleClass().add("standardButton");
		btnStop.getStyleClass().add("standardButton");

		this.getStyleClass().add("barFooter");
		lblZeitAktiv.getStyleClass().add("standardLabel");
		lblZeitPause.getStyleClass().add("standardLabel");
		//gpCenter.add(plAktivView, 0, 0);
		//gpCenter.add(plPauseView, 1, 0);
		
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
			System.out.println(cm.getIntProbAktivStartwert().getValue());
		});


	}

}
