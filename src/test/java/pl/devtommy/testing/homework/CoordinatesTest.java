package pl.devtommy.testing.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoordinatesTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 50, 99})
    void positionXShouldNotBeLessThan0(int x) {
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(-1 , 0));
        assertThat(x, equalTo(new Coordinates(x, 0).getX()));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 50, 99})
    void positionYShouldNotBeLessThan0(int y) {
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(0 , -1));
        assertThat(y, equalTo(new Coordinates(0, y).getY()));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 50, 99})
    void positionXShouldNotBeMoreThan100(int x) {
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(101 , 0));
        assertThat(x, equalTo(new Coordinates(x, 0).getX()));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 50, 99})
    void positionYShouldNotBeMoreThan100(int y) {
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(0 , 101));
        assertThat(y, equalTo(new Coordinates(0, y).getY()));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 10",
            "50, 15",
            "8, 7"
    })
    void copiedCoordinatesShouldBeMoved(int x, int y) {
        //given
        Coordinates coordinatesToCopy = new Coordinates(x, y);
        Coordinates copiedCoordinates = Coordinates.copy(coordinatesToCopy, x, y);
        //when then
        assertThat(copiedCoordinates.getX(), equalTo(coordinatesToCopy.getX() + x));
        assertThat(copiedCoordinates.getY(), equalTo(coordinatesToCopy.getY() + y));
    }
}