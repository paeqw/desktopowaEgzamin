package com.example.desktopowa;

public class Music {
    private String artist;
    private String album;
    private int songsNumber;
    private int year;
    private int downloadNumber;

    public Music(String artist, String album, int songsNumber, int year, int downloadNumber) {
        this.artist = artist;
        this.album = album;
        this.songsNumber = songsNumber;
        this.year = year;
        this.downloadNumber = downloadNumber;
    }

    @Override
    public String toString() {
        return artist + "\n" + album + "\n" + songsNumber +"\n" + year +"\n" + downloadNumber + "\n";
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getSongsNumber() {
        return songsNumber;
    }

    public int getYear() {
        return year;
    }

    public int getDownloadNumber() {
        return downloadNumber;
    }

    public void incrementDownloadCounter() {
        this.downloadNumber++;
    }
}
