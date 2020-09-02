package com.android.pnyjt3.model;

public class Movie {

    private int id;
    private String movieName;
    private String imageUrl;
    private String movieRatting;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMovieRatting() {
        return movieRatting;
    }

    public void setMovieRatting(String movieRatting) {
        this.movieRatting = movieRatting;
    }
}
