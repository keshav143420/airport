package com.kk.tdd.airport;

import org.junit.jupiter.api.*;

class AirportTest {

    @DisplayName("Given there is a economy flight")
    @Nested
    class EconomyFlightTest {

        private Flight economyFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {
            @Test
            void testEconomyFlightUsualPassenger() {
                Assertions.assertEquals("1", economyFlight.getId());
                Assertions.assertTrue(economyFlight.addPassenger(mike));
                Assertions.assertEquals(1, economyFlight.getPassengersList().size());
                Assertions.assertEquals("Mike", economyFlight.getPassengersList().get(0).getName());

                Assertions.assertTrue(economyFlight.removePassenger(mike));
                Assertions.assertEquals(0, economyFlight.getPassengersList().size());
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            void testEconomyFlightVipPassenger() {
                Assertions.assertEquals("1", economyFlight.getId());
                Assertions.assertTrue(economyFlight.addPassenger(john));
                Assertions.assertEquals(1, economyFlight.getPassengersList().size());
                Assertions.assertEquals("John", economyFlight.getPassengersList().get(0).getName());

                Assertions.assertFalse(economyFlight.removePassenger(john));
                Assertions.assertEquals(1, economyFlight.getPassengersList().size());
            }
        }
    }

    @DisplayName("Given there is a business flight")
    @Nested
    class BusinessFlightTest {

        private Flight businessFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {
            @Test
            void testBusinessFlightUsualPassenger() {
                Passenger mike = new Passenger("Mike", false);

                Assertions.assertFalse(businessFlight.addPassenger(mike));
                Assertions.assertEquals(0, businessFlight.getPassengersList().size());
                Assertions.assertFalse(businessFlight.removePassenger(mike));
                Assertions.assertEquals(0, businessFlight.getPassengersList().size());
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            void testBusinessFlightVipPassenger() {
                Passenger john = new Passenger("John", true);

                Assertions.assertTrue(businessFlight.addPassenger(john));
                Assertions.assertEquals(1, businessFlight.getPassengersList().size());
                Assertions.assertFalse(businessFlight.removePassenger(john));
                Assertions.assertEquals(1, businessFlight.getPassengersList().size());
            }
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

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {
            @Test
            void testPremiumFlightUsualPassenger() {
                Assertions.assertFalse(premiumFlight.addPassenger(mike));
                Assertions.assertEquals(0, premiumFlight.getPassengersList().size());
                Assertions.assertFalse(premiumFlight.removePassenger(mike));
                Assertions.assertEquals(0, premiumFlight.getPassengersList().size());
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            void testPremiumFlightVipPassenger() {
                Assertions.assertTrue(premiumFlight.addPassenger(john));
                Assertions.assertEquals(1, premiumFlight.getPassengersList().size());
                Assertions.assertTrue(premiumFlight.removePassenger(john));
                Assertions.assertEquals(0, premiumFlight.getPassengersList().size());
            }
        }
    }
}