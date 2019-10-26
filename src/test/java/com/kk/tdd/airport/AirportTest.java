package com.kk.tdd.airport;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

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
                assertEquals("1", economyFlight.getId());
                assertTrue(economyFlight.addPassenger(mike));
                assertEquals(1, economyFlight.getPassengersList().size());
                assertEquals("Mike", economyFlight.getPassengersList().get(0).getName());
                assertTrue(economyFlight.removePassenger(mike));
                assertEquals(0, economyFlight.getPassengersList().size());
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            void testEconomyFlightVipPassenger() {
                assertEquals("1", economyFlight.getId());
                assertTrue(economyFlight.addPassenger(john));
                assertEquals(1, economyFlight.getPassengersList().size());
                assertEquals("John", economyFlight.getPassengersList().get(0).getName());

                assertFalse(economyFlight.removePassenger(john));
                assertEquals(1, economyFlight.getPassengersList().size());
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

                assertFalse(businessFlight.addPassenger(mike));
                assertEquals(0, businessFlight.getPassengersList().size());
                assertFalse(businessFlight.removePassenger(mike));
                assertEquals(0, businessFlight.getPassengersList().size());
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            void testBusinessFlightVipPassenger() {
                Passenger john = new Passenger("John", true);

                assertTrue(businessFlight.addPassenger(john));
                assertEquals(1, businessFlight.getPassengersList().size());
                assertFalse(businessFlight.removePassenger(john));
                assertEquals(1, businessFlight.getPassengersList().size());
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
                assertFalse(premiumFlight.addPassenger(mike));
                assertEquals(0, premiumFlight.getPassengersList().size());
                assertFalse(premiumFlight.removePassenger(mike));
                assertEquals(0, premiumFlight.getPassengersList().size());
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            void testPremiumFlightVipPassenger() {
                assertTrue(premiumFlight.addPassenger(john));
                assertEquals(1, premiumFlight.getPassengersList().size());
                assertTrue(premiumFlight.removePassenger(john));
                assertEquals(0, premiumFlight.getPassengersList().size());
            }
        }
    }
}