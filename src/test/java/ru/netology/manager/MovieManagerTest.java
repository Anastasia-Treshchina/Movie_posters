package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.netology.domain.Movie;
import ru.netology.manager.MovieManager;
import ru.netology.repository.MovieRepository;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

class MovieManagerTest<expected> {
    @Mock
    private MovieRepository repository;
    @InjectMocks
    private MovieManager manager = new MovieManager(repository);

    private Movie movie1 = new Movie(1, "Бладшот", "боевик", false);
    private Movie movie2 = new Movie(2, "Вперёд", "мультфильм", false);
    private Movie movie3 = new Movie(3, "Отель 'Белград'", "комедия", false);
    private Movie movie4 = new Movie(4, "Джентельмены", "боевик", false);
    private Movie movie5 = new Movie(5, "Человек-невидимка", "ужасы", false);
    private Movie movie6 = new Movie(6, "Тролли. Мировой тур", "мультфильм", true);
    private Movie movie7 = new Movie(7, "Номер один", "комедия", true);
    private Movie movie8 = new Movie(8, "Человек-невидимка", "ужасы", false);
    private Movie movie9 = new Movie(9, "Тролли. Мировой тур", "мультфильм", true);
    private Movie movie10 = new Movie(10, "Номер один", "комедия", true);
    private Movie movie11 = new Movie(11, "Номер один", "комедия", true);

    Movie[] expected = {movie10, movie9, movie8, movie7, movie6,
           movie5, movie4, movie3, movie2, movie1};

    @BeforeEach
    void add() {
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);
        manager.add(movie8);
        manager.add(movie9);
        manager.add(movie10);
    }

    @Test
    public void shouldAddMovie() {
        Movie[] returned = new Movie[]{movie1, movie2, movie3, movie4};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).add(movie5);

        manager.add(movie5);

        Movie[] expected = {movie5, movie4, movie3, movie2, movie1};
        Movie[] actual = manager.findLastTen();

        assertArrayEquals(expected, actual);
    }

}