package GreedyAlgorithm;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost){
        int tank = 0;
        int start = 0;
        int totalGas = 0;

        for(int i = 0; i < gas.length; i++){
            int gain = gas[i] - cost[i];
            tank += gain;
            totalGas += gain;

            if(tank < 0 ){
                tank = 0;
                start = i+1;
            }
        }
        return (totalGas>=0) ? start : -1;
    }
}
