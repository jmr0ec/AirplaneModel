package org.jmr0ec.model;

public class Seat {

    private Boolean seatTaken = false;

    public Boolean isSeatTaken(){
        return seatTaken;
    }

    public void takeSeat(){
        seatTaken = true;
    }
}
