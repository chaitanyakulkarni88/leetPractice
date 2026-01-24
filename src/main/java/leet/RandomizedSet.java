package leet;

import java.util.*;
//380
public class RandomizedSet {

    Set<Integer> setOfNumbers;
    List<Integer> listOfNumbers;
    public RandomizedSet() {
        setOfNumbers = new HashSet<>();
        listOfNumbers = new ArrayList<>();
    }

    public boolean insert(int val) {
        return setOfNumbers.add(val);
    }

    public boolean remove(int val) {
        return setOfNumbers.remove(val);
    }

    public int getRandom() {
        Random random = new Random();
        listOfNumbers = setOfNumbers.stream().toList();
        return listOfNumbers.get(random.nextInt(listOfNumbers.size()));

    }
}
