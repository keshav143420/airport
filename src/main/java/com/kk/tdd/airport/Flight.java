package com.kk.tdd.airport;

import lombok.Getter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class Flight {

    Set<Passenger> passengersSet = new HashSet<>();
    @Getter
    private String id;

    public Flight(String id) {
        this.id = id;
    }

    public Set<Passenger> getPassengersSet() {
        return Collections.unmodifiableSet(passengersSet);
    }

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);

}
