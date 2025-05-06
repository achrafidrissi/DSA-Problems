package HackerRankProbs;

import java.util.List;

public class CircularGasStationTour {

    public int truckTour(List<List<Integer>> petrolpumps){
        int totalPetrol = 0;
        int currentPetrol = 0;
        int startIndex = 0;

        for(int i = 0; i<petrolpumps.size(); i++){
            int petrol = petrolpumps.get(i).get(0);
            int distance = petrolpumps.get(i).get(1);
            totalPetrol += petrol - distance;
            currentPetrol += petrol - distance;
            if(currentPetrol<0){
                startIndex = i+1;
                currentPetrol = 0;
            }
        }
        return startIndex;
    }
}
