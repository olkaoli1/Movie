package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int limit;

    public MovieManager() {
        this.limit = 5; // Лимит по умолчанию
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public void add(Movie movie) {
        Movie[] tmp = new Movie[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie[] findLast() {
        int resultLength = Math.min(movies.length, limit);
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}