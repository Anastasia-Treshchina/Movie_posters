package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

public class MovieManager {

    private MovieRepository repository;
    private int defaultCountMovie = 10;
    private int customCountMovie;

    public MovieManager(MovieRepository repository, int customCountMovie) {
        this.repository = repository;
        this.customCountMovie = customCountMovie;
    }

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }

    public void setCustomCountMovie (int customCountMovie) {
        this.customCountMovie = customCountMovie;
    }

    public void add(Movie movie) { repository.add(movie);}

    public Movie[] findLastTen() {
        Movie[] movies = repository.findAll();
        int resultLength = movies.length;
        if (customCountMovie <= 0) {
            if (defaultCountMovie < resultLength) {
                resultLength = defaultCountMovie;
            }
        } else {
            if (customCountMovie < resultLength) {
                resultLength = customCountMovie;
            }

        }
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public Movie[] showAll() {
        return repository.findAll();
    }

}
