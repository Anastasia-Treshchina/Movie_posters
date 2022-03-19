package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {

    private int countMovie = 10;
    private Movie[] movies = new Movie[0];

    public MovieManager(int countMovie) {
        this.countMovie = countMovie;
    }

    public MovieManager() {
    }

    public void add(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] findLastTen() {

        int resultLength = movies.length;
        if (resultLength >= countMovie) {
            resultLength = countMovie;
        } else {
            resultLength = movies.length;
        }
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public Movie[] findAll() {
        int resultLength = movies.length;
        if (resultLength >= countMovie) {
            resultLength = countMovie;
        } else {
            resultLength = movies.length;
        }
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[i];
        }
        return result;
    }


}
