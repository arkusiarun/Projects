package programs;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int surplus = 0, totalSurplus = 0, start = 0;
        for (int i=0;i<gas.length;i++) {
            totalSurplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if(surplus<0) {
                surplus = 0;
                start = i+1;
            }
        }
        return (totalSurplus<0)?-1:start;
    }
}
