package org.jmr0ec;

import org.jmr0ec.model.Airplane;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        int number_of_runs = 1;
        int airplaneSize = 100;

        int failed = 0;
        int success = 0;

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

            for(int i = 1; i < airplaneSize; i++){
                int seatNumber = seatList[i];

                if(airplane.isSeatTaken(seatNumber)){
                    int newSeatNumber = (int) (Math.random() * airplaneSize);
                    while(airplane.isSeatTaken(newSeatNumber)){
                        newSeatNumber = (int) (Math.random() * airplaneSize);
                    }
                    airplane.takeSeat(newSeatNumber);
                    result = false;
                }else{
                    airplane.takeSeat(seatNumber);
                    result = true;
                }
            }

            if(result){
                success++;
            }else{
                failed++;
            }
            if(count % 100000 == 0 && count != 0){
                System.out.println("Count: " + count);
            }
        }
        System.out.println("Successes: " + success);
        System.out.println("Failures: " + failed);
    }
}
