package com.example.desktopowa;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicManager {
    private List<Music> musicList;

    public MusicManager() {
        this.musicList = new ArrayList<>();
        getData();
    }

    private void getData() {
        Scanner scanner;
        List<String> values = new ArrayList<>();
        try {
            File file = new File(getClass().getResource("Data.txt").toURI());
            scanner = new Scanner(file);

            while (scanner.hasNext()) {
                values.add(scanner.nextLine());
            }
            for (int i = 0; i < values.size(); i+=6) {
                musicList.add(new Music(values.get(i),values.get(i+1), Integer.parseInt(values.get(i+2)), Integer.parseInt(values.get(i+3)),Integer.parseInt(values.get(i+4))));
            }

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Music> getMusicList() {
        return musicList;
    }
}
