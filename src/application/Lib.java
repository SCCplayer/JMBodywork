package application;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class Lib {

	public static List<File> readMusicFilesFromDirectory(File directory) {
		File[] musicFiles = directory.listFiles();

		FileFilter ff = new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				if (pathname.toURI().toString().toLowerCase().endsWith(".wav") == true) {
					return true;
				} else if (pathname.toURI().toString().toLowerCase().endsWith(".m4a") == true) {
					return true;
				} else if (pathname.toURI().toString().toLowerCase().endsWith(".mp3") == true) {
					return true;
				}
				return false;
			}
		};
		musicFiles = directory.listFiles(ff);
		System.out.println("Anzahl Files: " + musicFiles.length);
		List<File> listImageFiles = arrayToList(musicFiles);

		return listImageFiles;
	}

	public static List<File> arrayToList(File[] fileArray) {
		List<File> listTemp = new ArrayList<File>();
		for (int i = 0; i < fileArray.length; i++) {
			listTemp.add(fileArray[i]);
		}
		return listTemp;
	}
}
