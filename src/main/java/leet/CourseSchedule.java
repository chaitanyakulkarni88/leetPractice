package leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int dependency = prereq[1];

            graph.get(dependency).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completed = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            completed++;

            for (int neighbor : graph.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return completed == numCourses;
    }

    public static void main(String[] args) {

        int numCourses1 = 4;
        int[][] prereq1 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println("Can finish (Example 1): " +
                canFinish(numCourses1, prereq1)); // true

        int numCourses2 = 2;
        int[][] prereq2 = {{1, 0}, {0, 1}};
        System.out.println("Can finish (Example 2): " +
                canFinish(numCourses2, prereq2)); // false
    }
}