package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

public class MovieManager {

    private MovieRepository repository;
    private int countMovie = 10;

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }

    public void add(Movie movie) { repository.add(movie);}

    public Movie[] findLastTen() {
        Movie[] movies = repository.findAll();
        int resultLength = movies.length;
        if (resultLength > countMovie) {
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

}
