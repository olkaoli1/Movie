package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    @Test
    public void shouldAddMovies() {
        MovieManager manager = new MovieManager();

        Movie movie1 = new Movie("Бладшот");
        Movie movie2 = new Movie("Вперёд");

        manager.add(movie1);
        manager.add(movie2);

        Movie[] expected = {movie1, movie2};
        Movie[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMoviesWithDefaultLimit() {
        MovieManager manager = new MovieManager();

        manager.add(new Movie("Бладшот"));
        manager.add(new Movie("Вперёд"));
        manager.add(new Movie("Отель Белград"));
        manager.add(new Movie("Джентльмены"));
        manager.add(new Movie("Человек-невидимка"));
        manager.add(new Movie("Тролли"));

        Movie[] expected = {
                new Movie("Тролли"),
                new Movie("Человек-невидимка"),
                new Movie("Джентльмены"),
                new Movie("Отель Белград"),
                new Movie("Вперёд")
        };
        Movie[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMoviesWithCustomLimit() {
        MovieManager manager = new MovieManager(3);

        manager.add(new Movie("Бладшот"));
        manager.add(new Movie("Вперёд"));
        manager.add(new Movie("Отель Белград"));
        manager.add(new Movie("Джентльмены"));

        Movie[] expected = {
                new Movie("Джентльмены"),
                new Movie("Отель Белград"),
                new Movie("Вперёд")
        };
        Movie[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }
}