package application;

import java.io.File;
import java.util.Random;

import gui.NodeTimeView;
import gui.StageTimeView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class ControllerMain {
	private final SimpleIntegerProperty startwertDelay = new SimpleIntegerProperty(5);
	private final SimpleIntegerProperty startwertAktiv = new SimpleIntegerProperty(10);
	private final SimpleIntegerProperty startwertPause = new SimpleIntegerProperty(10);
	private final SimpleIntegerProperty anzahlStation = new SimpleIntegerProperty(14);
	private final SimpleIntegerProperty anzahlRunden = new SimpleIntegerProperty(14);
	private final SimpleIntegerProperty rundenPause = new SimpleIntegerProperty(5);
	private int counterTime = 0;

	private Random random = new Random();

	private Timeline timelineActiv;

	private NodeTimeView nodeZeitAnzeige;
	private StageTimeView stv;

	private MediaPlayer playerActive;
	private MediaPlayer playerPause;
	private MediaPlayer playerWechselSignal;
	private MediaPlayer playerStartSignal;
	private MediaPlayer playerStopSignal;

	private ObservableList<File> listMusicAktiv;
	private ObservableList<File> listMusicPause;

	public ControllerMain(ObservableList<File> listMusicFilesAktiv, ObservableList<File> listMusicFilesPause) {
		this.listMusicAktiv = listMusicFilesAktiv;
		this.listMusicPause = listMusicFilesPause;

		playerStartSignal = new MediaPlayer(
				new Media(getClass().getResource("/resources/Startsignal.mp3").toExternalForm()));
		playerStopSignal = new MediaPlayer(
				new Media(getClass().getResource("/resources/LeiderGeil.mp3").toExternalForm()));
		playerWechselSignal = new MediaPlayer(
				new Media(getClass().getResource("/resources/Wechselsignal.mp3").toExternalForm()));
	}

	public void startWorkout() {
		nodeZeitAnzeige = new NodeTimeView(this);
		stv = new StageTimeView(nodeZeitAnzeige, this);
		counterTime = startwertDelay.intValue();
		Timeline timerStartDelay = new Timeline(new KeyFrame(Duration.millis(1000), ae -> {
			counterTime = counterTime - 1;
			nodeZeitAnzeige.getLblZeitanzeige().setText(String.valueOf(counterTime));
			if (counterTime == -1) {
				counterTime = startwertAktiv.intValue();
				startAktiv();
			}

		}));
		timerStartDelay.setCycleCount(startwertDelay.intValue() + 1);
		playerStartSignal.play();
		// timelineActiv = timerStartDelay;
		timerStartDelay.play();

	}

	private void startAktiv() {
		playAktivSong();
		nodeZeitAnzeige.getLblZeitanzeige().setText(String.valueOf(counterTime));
		nodeZeitAnzeige.getLblTop().setText("Aktive Phase");
		playerWechselSignal.stop();
		Timeline timerAktiv = new Timeline(new KeyFrame(Duration.millis(1000), ae -> {
			counterTime = counterTime - 1;
			nodeZeitAnzeige.getLblZeitanzeige().setText(String.valueOf(counterTime));
			if (counterTime == startwertAktiv.intValue() / 2) {
				// playerWechselSignal.stop();
				// playerWechselSignal.play();
				// System.out.println(playerActive.getVolume());
				// playerActive.setVolume(0.2);
				// playerVolumeFadeMax(playerActive);
			} else if (counterTime == 1) {
				playerVolumeFadeOut(playerActive);
			} else if (counterTime == 0) {
				playerWechselSignal.play();
			} else if (counterTime == -1) {
				counterTime = startwertPause.intValue();
				playerActive.stop();
				startPause();
			}
		}));
		timerAktiv.setCycleCount(counterTime + 1);
		timelineActiv = timerAktiv;
		timerAktiv.play();

	}

	private void startPause() {
		playerStartSignal.stop();
		nodeZeitAnzeige.getLblTop().setText("Pause Phase");
		playPauseSong();
		nodeZeitAnzeige.getLblZeitanzeige().setText(String.valueOf(counterTime));
		Timeline timerPause = new Timeline(new KeyFrame(Duration.millis(1000), ae -> {
			counterTime = counterTime - 1;
			nodeZeitAnzeige.getLblZeitanzeige().setText(String.valueOf(counterTime));
			if (counterTime == 5) {
				playerStartSignal.play();
			} else if (counterTime == -1) {
				counterTime = startwertAktiv.intValue();
				playerPause.stop();
				startAktiv();
			}
		}));
		timerPause.setCycleCount(counterTime + 1);
		timelineActiv = timerPause;
		timerPause.play();
	}

	private void playAktivSong() {
		int z = 0;
		z = (int) (random.nextDouble() * listMusicAktiv.size());
		playerActive = new MediaPlayer(new Media(listMusicAktiv.get(z).toURI().toString()));
		playerActive.play();
		// playerActive.setOnStopped(new Runnable() {
		//
		// @Override
		// public void run() {
		// playerActive.dispose();
		// playerActive = null;
		// System.out.println(playerActive);
		// System.out.println("Player Disposed");
		// }
		// });
		System.out.println(z);
	}

	private void playPauseSong() {
		int z = 0;
		z = (int) (random.nextDouble() * listMusicPause.size());
		playerPause = new MediaPlayer(new Media(listMusicPause.get(z).toURI().toString()));
		playerPause.play();
		System.out.println(z);
	}

	private void playerVolumeFadeMax(MediaPlayer mp) {
		Timeline timerFadeInMax = new Timeline(new KeyFrame(Duration.millis(10), ae -> {
			mp.setVolume(mp.getVolume() + 0.8 / 100);
			System.out.println(mp.getVolume());

		}));
		timerFadeInMax.setCycleCount(100);
		timerFadeInMax.play();
		timerFadeInMax.statusProperty().addListener((ov, oldValue, newValue) -> {
			System.out.println(newValue.toString() + " " + oldValue.toString());
		});
		// timerFadeInMax.statusProperty().addListener(listener);
	}

	private void playerVolumeFadeOut(MediaPlayer mp) {
		Timeline timerFadeInMax = new Timeline(new KeyFrame(Duration.millis(10), ae -> {
			mp.setVolume(mp.getVolume() - 0.8 / 100);
			System.out.println(mp.getVolume());
		}));
		timerFadeInMax.setCycleCount(100);
		timerFadeInMax.play();
	}

	public SimpleIntegerProperty getIntProbAktivStartwert() {
		return startwertAktiv;
	}

	public SimpleIntegerProperty getIntProbPauseStartwert() {
		return startwertPause;
	}

	public SimpleIntegerProperty getIntProbAnzahlStation() {
		return anzahlStation;
	}

	public File getNextSong() {
		return listMusicAktiv.get(1);
	}

	public void stopAll() {
		System.out.println("Player Stoppen");
		playerActive.stop();
		playerPause.stop();
		playerWechselSignal.stop();
		playerStartSignal.stop();
		playerStopSignal.stop();
		timelineActiv.stop();
	}
}
