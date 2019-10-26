package com.kk.tdd.airport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AirportTest {

    @Test
    void testEconomyFlightUsualPassenger() {
        Flight economyFlight = new EconomyFlight("1");
        Passenger mike = new Passenger("Mike", false);

        Assertions.assertEquals("1", economyFlight.getId());
        Assertions.assertTrue(economyFlight.addPassenger(mike));
        Assertions.assertEquals(1, economyFlight.getPassengersList().size());
        Assertions.assertEquals("Mike", economyFlight.getPassengersList().get(0).getName());

        Assertions.assertTrue(economyFlight.removePassenger(mike));
        Assertions.assertEquals(0, economyFlight.getPassengersList().size());
    }

    @Test
    void testEconomyFlightVipPassenger() {
        Flight economyFlight = new EconomyFlight("1");
        Passenger john = new Passenger("John", true);

        Assertions.assertEquals("1", economyFlight.getId());
        Assertions.assertTrue(economyFlight.addPassenger(john));
        Assertions.assertEquals(1, economyFlight.getPassengersList().size());
        Assertions.assertEquals("John", economyFlight.getPassengersList().get(0).getName());

        Assertions.assertFalse(economyFlight.removePassenger(john));
        Assertions.assertEquals(1, economyFlight.getPassengersList().size());
    }

    @Test
    void testBusinessFlightUsualPassenger() {
        Flight businessFlight = new BusinessFlight("2");

        Passenger mike = new Passenger("Mike", false);

        Assertions.assertFalse(businessFlight.addPassenger(mike));
        Assertions.assertEquals(0, businessFlight.getPassengersList().size());
        Assertions.assertFalse(businessFlight.removePassenger(mike));
        Assertions.assertEquals(0, businessFlight.getPassengersList().size());

    }

    @Test
    void testBusinessFlightVipPassenger() {
        Flight businessFlight = new BusinessFlight("2");

        Passenger john = new Passenger("John", true);

        Assertions.assertTrue(businessFlight.addPassenger(john));
        Assertions.assertEquals(1, businessFlight.getPassengersList().size());
        Assertions.assertFalse(businessFlight.removePassenger(john));
        Assertions.assertEquals(1, businessFlight.getPassengersList().size());

    }
}