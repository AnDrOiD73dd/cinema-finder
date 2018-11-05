package com.ateam.zuml.cinemafinder.ui;

public final class MovieModel {

    private final int id;
    //TODO change int to string
    private final int posterPath;
    private final String title;
    private final String originalTitle;
    private final String releaseDate;
    private final String[] genres;
    private final float voteAverage;

    public MovieModel(int id, int posterPath, String title, String originalTitle, String releaseDate, String[] genres, float voteAverage) {
        this.id = id;
        this.posterPath = posterPath;
        this.title = title;
        this.originalTitle = originalTitle;
        this.releaseDate = releaseDate;
        this.genres = genres;
        this.voteAverage = voteAverage;
    }

    public int getId() {
        return id;
    }

    //TODO change int to string
    public int getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getReleaseYear() {
        return splitDate()[0];
    }

    public String getGenres() {
        return getStringFromArrayGenres();
    }

    public String getVoteAverage() {
        return String.valueOf(voteAverage);
    }

    private String[] splitDate() {
        return releaseDate.split("-");
    }

    private String getStringFromArrayGenres() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < genres.length; i++) {
            sb.append(genres[i]);
            if(genres.length == 1 || i == (genres.length - 1)) {
                break;
            }
            sb.append(", ");
        }

        return sb.toString();
    }
}
