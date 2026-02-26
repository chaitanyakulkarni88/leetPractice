package leet.matrix.hashmap;

import java.util.HashSet;
import java.util.Set;

//202
public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber mn = new HappyNumber();
        int n = 2;
        System.out.println(mn.isHappy(n));
    }
    public boolean isHappy(int n) {
        Set<Integer> valuesOfSum = new HashSet<>();
        int sum=0;
        while(true) {
            while(n!=0) {
                sum+= (int) Math.pow(n%10,2);
                n=n/10;
            }
            if(sum == 1)
                return true;

            if(valuesOfSum.contains(sum))
                return false;

            valuesOfSum.add(sum);
            n=sum;
            sum=0;
        }
    }
}
