package pl.devtommy.testing.homework;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;


class UnitTest {
    @Test
    void unitShouldNotMoveFarThanAmountOfFuel() {

        //given
        Coordinates startCoordinates = new Coordinates(10, 10);
        Unit unit = new Unit(startCoordinates, 30, 40);

        //when then
        assertThrows(IllegalStateException.class, () -> unit.move(16,16));
    }

    @Test
    void fuelShouldBeUpdatedAfterMove() {

        //given
        Coordinates startCoordinates = new Coordinates(10, 10);
        Unit unit = new Unit(startCoordinates, 30, 40);

        //when
        unit.move(5, 5);

        //then
        assertThat(unit.getFuel(), equalTo(20) );
    }

    @RepeatedTest(10)
    void tankUpShouldNotBeMoreThanMaxFuel() {

        //given
        int maxFuel = 30;
        Coordinates startCoordinates = new Coordinates(10, 10);
        Unit unit = new Unit(startCoordinates, maxFuel, 40);

        //when
        unit.tankUp();

        //then
        assertThat(unit.getFuel(), lessThanOrEqualTo(maxFuel) );
    }

    @Test
    void cargoShouldNotWeightMoreThanUnitMaxCargoWeight() {

        //given
        Coordinates startCoordinates = new Coordinates(10, 10);
        Unit unit = new Unit(startCoordinates, 30, 40);
        Cargo wood = new Cargo("wood", 41);

        //when then
        assertThrows(IllegalStateException.class, () -> unit.loadCargo(wood));
    }

    @Test
    void amountOfCargoShouldIncreaseAfterLoadCargo() {

        //given
        Coordinates startCoordinates = new Coordinates(10, 10);
        Unit unit = new Unit(startCoordinates, 30, 40);
        Cargo wood = new Cargo("wood", 25);
        int previousAmountOfCargo = unit.getLoad();

        //when
        unit.loadCargo(wood);

        //then
        assertThat(unit.getLoad(), greaterThan(previousAmountOfCargo) );
    }

    @Test
    void sumOfTheLoadShouldBeUpdatedAfterLoadCargo() {

        //given
        Coordinates startCoordinates = new Coordinates(10, 10);
        Unit unit = new Unit(startCoordinates, 30, 40);
        int cargoWeight = 23;
        Cargo wood = new Cargo("wood", cargoWeight);
        int previousAmountOfCargo = unit.getLoad();

        //when
        unit.loadCargo(wood);

        //then
        assertThat(unit.getLoad(), equalTo(previousAmountOfCargo + cargoWeight) );
    }

    @Test
    void sumOfTheLoadShouldBeUpdatedAfterUnloadCargo() {

        //given
        Coordinates startCoordinates = new Coordinates(10, 10);
        Unit unit = new Unit(startCoordinates, 30, 40);
        Cargo wood = new Cargo("wood", 23);
        unit.loadCargo(wood);

        //when
        unit.unloadCargo(wood);

        //then
        assertThat(unit.getLoad(), equalTo(0) );
    }

    @Test
    void loadShouldBeEmptyAfterUnloadAllCargo() {

        //given
        Coordinates startCoordinates = new Coordinates(10, 10);
        Unit unit = new Unit(startCoordinates, 30, 40);
        Cargo wood = new Cargo("wood", 10);
        Cargo scrap = new Cargo("wood", 30);
        unit.loadCargo(wood);
        unit.loadCargo(scrap);

        //when
        unit.unloadAllCargo();

        //then
        assertThat(unit.getLoad(), equalTo(0) );
    }
}