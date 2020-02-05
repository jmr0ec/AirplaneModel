package org.jmr0ec.model;

public class Passenger {

    private int assignedSeat;
    private int seatTaken;

    public Passenger(int seatAssignment){
        assignedSeat = seatAssignment;
    }

    public int getAssignedSeat(){
        return assignedSeat;
    }

    public int getTakenSeat(){
        return seatTaken;
    }

    public void takeSeat(int seatNumber){
        seatTaken = seatNumber;
    }
}
