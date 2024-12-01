import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    @Test
    public void shouldReturnAllMovies() {
        MovieManager manager = new MovieManager();
        manager.add(new Movie("Movie1"));
        manager.add(new Movie("Movie2"));

        Movie[] expected = {new Movie("Movie1"), new Movie("Movie2")};
        Movie[] actual = manager.findAll();

        assertArrayEquals(Arrays.stream(expected).map(Movie::getName).toArray(),
                Arrays.stream(actual).map(Movie::getName).toArray());
    }

    @Test
    public void shouldReturnLastMoviesWhenLessThanLimit() {
        MovieManager manager = new MovieManager(5);
        manager.add(new Movie("Movie1"));
        manager.add(new Movie("Movie2"));

        Movie[] expected = {new Movie("Movie2"), new Movie("Movie1")};
        Movie[] actual = manager.findLast();

        assertArrayEquals(Arrays.stream(expected).map(Movie::getName).toArray(),
                Arrays.stream(actual).map(Movie::getName).toArray());
    }

    @Test
    public void shouldReturnLastMoviesWhenMoreThanLimit() {
        MovieManager manager = new MovieManager(3);
        manager.add(new Movie("Movie1"));
        manager.add(new Movie("Movie2"));
        manager.add(new Movie("Movie3"));
        manager.add(new Movie("Movie4"));

        Movie[] expected = {new Movie("Movie4"), new Movie("Movie3"), new Movie("Movie2")};
        Movie[] actual = manager.findLast();

        assertArrayEquals(Arrays.stream(expected).map(Movie::getName).toArray(),
                Arrays.stream(actual).map(Movie::getName).toArray());
    }

    @Test
    public void shouldReturnLastMoviesWhenEqualToLimit() {
        MovieManager manager = new MovieManager(2);
        manager.add(new Movie("Movie1"));
        manager.add(new Movie("Movie2"));

        Movie[] expected = {new Movie("Movie2"), new Movie("Movie1")};
        Movie[] actual = manager.findLast();

        assertArrayEquals(Arrays.stream(expected).map(Movie::getName).toArray(),
                Arrays.stream(actual).map(Movie::getName).toArray());
    }
}
