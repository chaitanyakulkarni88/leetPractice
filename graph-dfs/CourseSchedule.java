/**
 * LeetCode Problem: 207. Course Schedule
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 *
 * Core Idea:
 * 1. Build directed graph.
 * 2. Track indegree of each node.
 * 3. Use Kahn's Algorithm (BFS Topological Sort).
 * 4. If all nodes processed → no cycle.
 */
import java.util.*;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses <= 0) {
            return true;
        }

        List<List<Integer>> graph = new ArrayList<>(numCourses);
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int dependency = prereq[1];

            graph.get(dependency).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        // Add nodes with indegree 0
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processed = 0;

        while (!queue.isEmpty()) {

            int curr = queue.poll();
            processed++;

            for (int neighbor : graph.get(curr)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return processed == numCourses;
    }
}