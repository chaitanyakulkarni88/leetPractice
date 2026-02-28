/*
 * LeetCode Problem: #134 - Gas Station
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. If total gas < total cost, return -1 (impossible).
 * 2. Traverse stations and track remaining fuel.
 * 3. If remaining fuel becomes negative at index i,
 *    then any station before i cannot be a valid start.
 * 4. Reset start to i + 1 and continue.
 * 5. Return the valid starting station.
 *
 * Pattern: Greedy / Prefix Sum Reset
 */

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        if (gas == null || cost == null ||
                gas.length == 0 || gas.length != cost.length) {
            return -1;
        }

        int totalGas = 0;
        int totalCost = 0;
        int startStation = 0;
        int currentTank = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalGas < totalCost) {
            return -1;
        }

        for (int i = 0; i < gas.length; i++) {

            currentTank += gas[i] - cost[i];

            if (currentTank < 0) {
                startStation = i + 1;
                currentTank = 0;
            }
        }

        return startStation;
    }

    public static void main(String[] args) {

        GasStation solution = new GasStation();

        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println("Start Station: " +
                solution.canCompleteCircuit(gas1, cost1));

        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println("Start Station: " +
                solution.canCompleteCircuit(gas2, cost2));
    }
}