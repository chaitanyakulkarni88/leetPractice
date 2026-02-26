package leet.arrayorstring;
//134
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasTotal = 0;
        int costTotal = 0;
        int station = 0;
        int remainingFuel = 0;

        for(int i=0;i<gas.length;i++) {
            gasTotal += gas[i];
            costTotal += cost[i];
        }
        if(gasTotal<costTotal)
            return -1;

        for(int i=0;i<gas.length;i++) {
              remainingFuel += gas[i] - cost[i];
               if(remainingFuel < 0) {
                   station = i+1;
                   remainingFuel = 0;
               }
        }


        return station;

    }

    public static void main(String[] args) {
        GasStation gs = new GasStation();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(gs.canCompleteCircuit(gas,cost));
    }
}
