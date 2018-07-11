package gui;

import java.io.File;
import java.util.ArrayList;

import application.Lib;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

public class NodeDragMusicfolder extends StackPane {

	private Label lblHeaderName;

	private BorderPane bpDragMusicFolder = new BorderPane();
	private BorderPane bpMusicListView = new BorderPane();

	private ObservableList<File> listMusicFiles = FXCollections.observableArrayList(new ArrayList<File>());

	private ListView<File> listViewMusicFiles = new ListView<File>(listMusicFiles);

	public NodeDragMusicfolder(String header) {
		// TODO Auto-generated constructor stub
		lblHeaderName = new Label(header);
		initbpDragMusicFolder();
		initDragAndDrop(listViewMusicFiles);
		GridPane.setHgrow(this, Priority.ALWAYS);
		GridPane.setVgrow(this, Priority.ALWAYS);
	}

	public void initDragAndDrop(Node node) {
		node.setOnDragOver(event -> {
			Dragboard dragBoard = event.getDragboard();
			if (dragBoard.hasFiles()) {
				event.acceptTransferModes(TransferMode.ANY);
			}
			// event.consume();
		});

		node.setOnDragDropped(event -> {
			Dragboard dragBoard = event.getDragboard();

			if (dragBoard.hasFiles()) {
				if (dragBoard.getFiles().size() == 1) {
					if (dragBoard.getFiles().get(0).isDirectory()) {
						for (File file : dragBoard.getFiles()) {
							System.out.println(file.isDirectory());
							addSongsToList(FXCollections
									.observableList((Lib.readMusicFilesFromDirectory(dragBoard.getFiles().get(0)))));
						}
					} else if (dragBoard.getFiles().get(0).isFile()) {
						addSongsToList(FXCollections.observableList(dragBoard.getFiles()));
					}
				} else {
					addSongsToList(FXCollections.observableList(dragBoard.getFiles()));
				}

				System.out.println("List of files incoming");
			}
			if (listMusicFiles != null) {
				/*
				 * TODO first picture should be shown
				 */
				// listViewMusicFiles = new ListView<File>(listMusicFiles);
				// bpDragMusicFolder.setCenter(listViewMusicFiles);
			}
			event.setDropCompleted(listMusicFiles != null);
			event.consume();
		});

	}

	private void initbpDragMusicFolder() {
		lblHeaderName.getStyleClass().add("lblHeader");
		Label labelCenter = new Label("\uf03e");
		labelCenter.getStyleClass().add("lblCenter");
		BorderPane bpCenter = new BorderPane(listViewMusicFiles);
		bpCenter.getStyleClass().add("bpLabel");
		bpDragMusicFolder.setCenter(bpCenter);
		bpDragMusicFolder.setTop(lblHeaderName);
		bpDragMusicFolder.getStyleClass().add("dragBP");
		this.getChildren().add(bpDragMusicFolder);
	}

	private void addSongsToList(ObservableList<File> newSongs) {
		for (File f : newSongs) {
			listMusicFiles.add(f);
		}
	}

	public ObservableList<File> getListMusicFiles() {
		return listMusicFiles;
	}

	public void setListMusicFiles(ObservableList<File> listMusicFiles) {
		this.listMusicFiles = listMusicFiles;
	}
}
