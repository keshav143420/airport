package com.kk.tdd.airport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AirportTest {

    @DisplayName("Given there is an economy flight")
    @Nested
    class EconomyFlightTest {

        private Flight economyFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            mike  = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {

            @Test
            @DisplayName("Then you can add and remove him from an economy flight")
            public void testEconomyFlightUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertTrue(economyFlight.addPassenger(mike)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("Mike", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertTrue(economyFlight.removePassenger(mike)),
                        () -> assertEquals(0, economyFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then you can add him but cannot remove him from an economy flight")
            public void testEconomyFlightVipPassenger() {
                assertAll("Verify all conditions for a VIP passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertTrue(economyFlight.addPassenger(john)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("John", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertFalse(economyFlight.removePassenger(john)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size())
                );

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
            @DisplayName("Then you cannot add or remove him from a business flight")
            public void testBusinessFlightUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and a business flight",
                        () -> assertFalse(businessFlight.addPassenger(mike)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size()),
                        () -> assertFalse(businessFlight.removePassenger(mike)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {

            @Test
            @DisplayName("Then you can add him but cannot remove him from a business flight")
            public void testBusinessFlightVipPassenger() {
                assertAll("Verify all conditions for a VIP passenger and a business flight",
                        () -> assertTrue(businessFlight.addPassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size()),
                        () -> assertFalse(businessFlight.removePassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size())
                );
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
            @DisplayName("Then you cannot add or remove him from a premium flight")
            public void testPremiumFlightUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and a premium flight",
                        () -> assertFalse(premiumFlight.addPassenger(mike)),
                        () -> assertEquals(0, premiumFlight.getPassengersList().size()),
                        () -> assertFalse(premiumFlight.removePassenger(mike)),
                        () -> assertEquals(0, premiumFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {

            @Test
            @DisplayName("Then you can add and remove him from a premium flight")
            public void testPremiumFlightVipPassenger() {
                assertAll("Verify all conditions for a VIP passenger and a premium flight",
                        () -> assertTrue(premiumFlight.addPassenger(john)),
                        () -> assertEquals(1, premiumFlight.getPassengersList().size()),
                        () -> assertTrue(premiumFlight.removePassenger(john)),
                        () -> assertEquals(0, premiumFlight.getPassengersList().size())
                );
            }
        }
    }
}
