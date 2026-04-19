package stack; /**
 * LeetCode Problem: 71. Simplify Path
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Split path by "/".
 * 2. Ignore empty strings and ".".
 * 3. For "..", pop from stack if possible.
 * 4. Push valid directory names.
 * 5. Build final path from stack.
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {

    public static void main(String[] args) {
        SimplifyPath solution = new SimplifyPath();

        String path1 = "/home/user/Documents/../Pictures";
        System.out.println(solution.simplifyPath(path1));

        String path2 = "/.../a/../b/c/../d/./";
        System.out.println(solution.simplifyPath(path2));
    }

    public String simplifyPath(String path) {
        validateInput(path);

        Deque<String> stack = new ArrayDeque<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            if (part.isEmpty() || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.pop());
        }

        return result.toString();
    }

    private void validateInput(String path) {
        if (path == null) {
            throw new IllegalArgumentException("Path must not be null.");
        }
    }
}