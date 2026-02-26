package leet.intervals;

import java.util.LinkedList;
import java.util.List;
//57
public class InsertInterval {
    public static void main(String[] args) {
        InsertInterval ii = new InsertInterval();
        int[][] intervals = {{1,5}};
        int[] newInterval = {6,8};
        int[][] result = ii.insert(intervals,newInterval);
        for(int i=0;i< result.length;i++) {
            for(int j=0;j< result[0].length;j++) {
                System.out.println(result[i][j]);
            }
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();

        if(intervals.length == 0) {
            result.add(newInterval);
            return result.toArray(new int[result.size()][]);
        }

        int n = intervals.length;
        int i=0;

        while(i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while(i<n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        List<int[]> result = new LinkedList<>();
//        int n = intervals.length;
//        int i=0;
//
//        if(intervals.length == 0) {
//            result.add(newInterval);
//            return result.toArray(new int[result.size()][]);
//        }
//
//        while(i< intervals.length) {
//            int value = intervals[i][1];
//            if(value < newInterval[0]) {
//                result.add(intervals[i]);
//                i++;
//            }
//            else
//                break;
//        }
//
//        int[] tempInterval = new int[0];
//        if(i< intervals.length) {
//            tempInterval = intervals[i];
//            result.add(tempInterval);
//        }
//
//        while(i<= intervals.length) {
//            if((newInterval[0] >= tempInterval[0]) && (newInterval[1] >= intervals[i][0])) {
//                tempInterval[1] = Math.max(intervals[i][1], newInterval[1]);
//                i++;
//            }
//            else
//                break;
//        }
//
//        while(i<= intervals.length) {
//            result.add(intervals[i]);
//            i++;
//        }
//
//        return result.toArray(new int[result.size()][]);
//    }
}
