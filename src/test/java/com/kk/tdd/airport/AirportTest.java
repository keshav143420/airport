package com.kk.tdd.airport;

import org.junit.jupiter.api.*;

class AirportTest {

    @DisplayName("Given there is a economy flight")
    @Nested
    class EconomyFlightTest {

        Flight economyFlight;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
        }

        @Test
        void testEconomyFlightUsualPassenger() {
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
            Passenger john = new Passenger("John", true);

            Assertions.assertEquals("1", economyFlight.getId());
            Assertions.assertTrue(economyFlight.addPassenger(john));
            Assertions.assertEquals(1, economyFlight.getPassengersList().size());
            Assertions.assertEquals("John", economyFlight.getPassengersList().get(0).getName());

            Assertions.assertFalse(economyFlight.removePassenger(john));
            Assertions.assertEquals(1, economyFlight.getPassengersList().size());
        }
    }

    @DisplayName("Given there is a business flight")
    @Nested
    class BusinessFlightTest {

        Flight businessFlight;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
        }

        @Test
        void testBusinessFlightUsualPassenger() {
            Passenger mike = new Passenger("Mike", false);

            Assertions.assertFalse(businessFlight.addPassenger(mike));
            Assertions.assertEquals(0, businessFlight.getPassengersList().size());
            Assertions.assertFalse(businessFlight.removePassenger(mike));
            Assertions.assertEquals(0, businessFlight.getPassengersList().size());
        }

        @Test
        void testBusinessFlightVipPassenger() {
            Passenger john = new Passenger("John", true);

            Assertions.assertTrue(businessFlight.addPassenger(john));
            Assertions.assertEquals(1, businessFlight.getPassengersList().size());
            Assertions.assertFalse(businessFlight.removePassenger(john));
            Assertions.assertEquals(1, businessFlight.getPassengersList().size());
        }
    }

    @DisplayName("Given there is a premium flight")
    @Nested
    class PremiumFlightTest {

        private Flight premiumFlight;
        private Passenger mike;
        private Passenger john;


        @BeforeEach
        void setUp() {
            premiumFlight = new PremiumFlight("3");
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Test
        void testPremiumFlightUsualPassenger() {
            Assertions.assertFalse(premiumFlight.addPassenger(mike));
            Assertions.assertEquals(0, premiumFlight.getPassengersList().size());
            Assertions.assertFalse(premiumFlight.removePassenger(mike));
            Assertions.assertEquals(0, premiumFlight.getPassengersList().size());
        }

        @Test
        void testPremiumFlightVipPassenger() {
            Assertions.assertTrue(premiumFlight.addPassenger(john));
            Assertions.assertEquals(1, premiumFlight.getPassengersList().size());
            Assertions.assertTrue(premiumFlight.removePassenger(john));
            Assertions.assertEquals(0, premiumFlight.getPassengersList().size());
        }
    }

}