package com.example.desktopowa;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable{

    @FXML
    private Label countLabel;

    @FXML
    private Label bandLabel;

    @FXML
    private Button downloadButton;

    @FXML
    private Label downloadCountLabel;

    @FXML
    private Button leftButton;

    @FXML
    private Button rightButton;

    @FXML
    private Label titleLabel;

    @FXML
    private Label yearLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        BackgroundImage left = new BackgroundImage(new Image(getClass().getResourceAsStream("obraz3.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        BackgroundImage right = new BackgroundImage(new Image(getClass().getResourceAsStream("obraz2.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        Background bgleft = new Background(left);
        Background bgright = new Background(right);

        rightButton.setBackground(bgright);
        leftButton.setBackground(bgleft);

        final int[] position = {0};

        MusicManager musicManager = new MusicManager();
        List<Music> musicList = musicManager.getMusicList();

        Music music = musicList.get(position[0]);
        Music[] currentMusic = {music};

        bandLabel.setText(music.getArtist());
        titleLabel.setText(music.getAlbum());
        yearLabel.setText(String.valueOf(music.getYear()));
        countLabel.setText(music.getSongsNumber() + " utworów");
        downloadCountLabel.setText(String.valueOf(music.getDownloadNumber()));

        leftButton.onActionProperty().set(actionEvent -> {
            if (position[0] ==  0) {
                position[0] = musicList.size()-1;
            } else position[0]--;

            Music a = musicList.get(position[0]);

            currentMusic[0] = a;

            bandLabel.setText(a.getArtist());
            titleLabel.setText(a.getAlbum());
            yearLabel.setText(String.valueOf(a.getYear()));
            countLabel.setText(a.getSongsNumber() + " utworów");
            downloadCountLabel.setText(String.valueOf(a.getDownloadNumber()));

        });

        rightButton.onActionProperty().set(actionEvent -> {
            if (position[0] ==  musicList.size()-1) {
                position[0] = 0;
            } else position[0]++;

            Music b = musicList.get(position[0]);

            currentMusic[0] = b;

            bandLabel.setText(b.getArtist());
            titleLabel.setText(b.getAlbum());
            yearLabel.setText(String.valueOf(b.getYear()));
            countLabel.setText(b.getSongsNumber() + " utworów");
            downloadCountLabel.setText(String.valueOf(b.getDownloadNumber()));

        });

        downloadButton.onActionProperty().set(actionEvent ->  {
              currentMusic[0].incrementDownloadCounter();
              downloadCountLabel.setText(String.valueOf(currentMusic[0].getDownloadNumber()));
        });

    }
}
