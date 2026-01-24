package leet;

import java.util.*;
//56
public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        int[][] intervals = {{1,3},{2,6},{8,10},{8,9},{9,11},{15,18},{2,4},{16,17}};
        int[][] result = m.merge(intervals);
        for(int i=0;i< result.length;i++) {
            for(int j=0;j< result[0].length;j++) {
                System.out.println(result[i][j]);
            }
        }
    }
    int[][] merge(int[][] intervals) {

        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));

        int[] newInterval = intervals[0];

        List<int[]> result = new LinkedList<>();
        result.add(newInterval);

        for(int[] interval:intervals) {
            if(interval[0] <= newInterval[1])
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            else {
                newInterval=interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

}

