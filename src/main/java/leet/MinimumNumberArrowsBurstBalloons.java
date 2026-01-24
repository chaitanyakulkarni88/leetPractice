package leet;

import java.util.Arrays;
import java.util.Comparator;

//452
public class MinimumNumberArrowsBurstBalloons {
    public static void main(String[] args) {
        MinimumNumberArrowsBurstBalloons mn = new MinimumNumberArrowsBurstBalloons();
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        //int[][] points = {{0,9},{1,8},{7,8},{1,6},{9,16},{7,13},{7,10},{6,11},{6,9},{9,13}};
        System.out.println(mn.findMinArrowShots(points));
    }
    public int findMinArrowShots(int[][] points) {
        int arrows = 1;
        Arrays.sort(points, Comparator.comparingInt(i->i[1]));
        int end = points[0][1];
        int i=1;

        while(i< points.length) {
            if(points[i][0] <= end)
                i++;
            else {
                arrows++;
                end = points[i][1];
                i++;
            }

        }

        return arrows;
    }
}
