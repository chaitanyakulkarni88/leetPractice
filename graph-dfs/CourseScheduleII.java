/**
 * LeetCode Problem: 210. Course Schedule II
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 *
 * Core Idea:
 * 1. Build directed graph.
 * 2. Compute indegree of each course.
 * 3. Use Kahn's Algorithm (BFS Topological Sort).
 * 4. If all courses processed → return order.
 * 5. Otherwise → cycle exists → return empty array.
 */
import java.util.*;

public class CourseScheduleII {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses <= 0) {
            return new int[0];
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

        // Start with courses having no prerequisites
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {

            int curr = queue.poll();
            order[index++] = curr;

            for (int neighbor : graph.get(curr)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return (index == numCourses) ? order : new int[0];
    }
}