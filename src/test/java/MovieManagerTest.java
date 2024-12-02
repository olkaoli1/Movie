import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {

    @Test
    public void shouldReturnAllMovies() {
        MovieManager manager = new MovieManager();
        manager.add(new Movie("Movie1"));
        manager.add(new Movie("Movie2"));

        Movie[] expected = {new Movie("Movie1"), new Movie("Movie2")};
        Movie[] actual = manager.findAll();

        assertArrayEquals(expected, actual, "Expected movies do not match actual movies");
    }

    @Test
    public void shouldReturnLastMoviesWhenLessThanLimit() {
        MovieManager manager = new MovieManager(5);
        manager.add(new Movie("Movie1"));
        manager.add(new Movie("Movie2"));

        Movie[] expected = {new Movie("Movie2"), new Movie("Movie1")};
        Movie[] actual = manager.findLast();

        assertArrayEquals(expected, actual, "Expected last movies do not match actual movies");
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

        assertArrayEquals(expected, actual, "Expected last movies do not match actual movies");
    }

    @Test
    public void shouldReturnLastMoviesWhenEqualToLimit() {
        MovieManager manager = new MovieManager(2);
        manager.add(new Movie("Movie1"));
        manager.add(new Movie("Movie2"));

        Movie[] expected = {new Movie("Movie2"), new Movie("Movie1")};
        Movie[] actual = manager.findLast();

        assertArrayEquals(expected, actual, "Expected last movies do not match actual movies");
    }
}
