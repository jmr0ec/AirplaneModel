package org.jmr0ec;

import org.jmr0ec.model.Airplane;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        int number_of_runs = 1000;
        int airplaneSize = 150;

        int failed = 0;
        int success = 0;

        int maxThreads = Runtime.getRuntime().availableProcessors());

        for(int count = 0; count < number_of_runs; count++){
            Boolean result = false;
            Airplane airplane = new Airplane(airplaneSize);

            Integer[] seatList = new Integer[airplaneSize];
            for (int x = 0; x < seatList.length; x++) {
                seatList[x] = x;
            }
            Collections.shuffle(Arrays.asList(seatList));
            //System.out.println(Arrays.toString(seatList));

            int randomSeatNumber = (int) (Math.random() * (airplaneSize));

            airplane.takeSeat(randomSeatNumber);

            int gotCorrectSeat = 0;
            int gotRandomSeat = 1;

            for(int i = 1; i < airplaneSize; i++){
                int seatNumber = seatList[i];

                if(airplane.isSeatTaken(seatNumber)){
                    int newSeatNumber = (int) (Math.random() * airplaneSize);
                    while(airplane.isSeatTaken(newSeatNumber)){
                        newSeatNumber = (int) (Math.random() * airplaneSize);
                    }
                    airplane.takeSeat(newSeatNumber);
                    result = false;
                    gotRandomSeat++;
                }else{
                    airplane.takeSeat(seatNumber);
                    result = true;
                    gotCorrectSeat++;
                }
            }

            if(result){
                success++;
            }else{
                failed++;
            }
        }
        System.out.println("Successes: " + success);
        System.out.println("Failures: " + failed);
    }
}
