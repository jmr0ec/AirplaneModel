package org.jmr0ec.model;

import java.util.ArrayList;
import java.util.List;

public class Airplane {

    private List<Seat> seats = new ArrayList<Seat>();

    public Airplane(int numberOfSeats){

        for(int i = 0; i < numberOfSeats; i++){
            Seat seat = new Seat();
            seats.add(seat);
        }
    }

    public Boolean isSeatTaken(int seatNumber){
        Seat seat = seats.get(seatNumber);

        return seat.isSeatTaken();
    }

    public void takeSeat(int seatNumber){
        //System.out.println("Taking seat #" + seatNumber);
        Seat seat = seats.get(seatNumber);

        seat.takeSeat();
    }
}
