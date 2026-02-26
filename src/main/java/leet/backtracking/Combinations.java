package leet.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int n,
                                  int k,
                                  int start,
                                  List<Integer> current,
                                  List<List<Integer>> result) {

        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(n, k, i + 1, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {

        int n = 4;
        int k = 2;

        List<List<Integer>> combinations = combine(n, k);

        System.out.println("Combinations:");
        System.out.println(combinations);
    }
}
