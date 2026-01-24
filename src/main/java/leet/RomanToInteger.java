package leet;

import java.util.HashMap;
import java.util.Map;
//13
public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger rti = new RomanToInteger();
        String s = "MCMXCIV";
        System.out.println(rti.romanToInt(s));
    }
    public int romanToInt(String s) {
        Map<Character,Integer> romanInteger = new HashMap<>();
        romanInteger.put('I',1);
        romanInteger.put('V',5);
        romanInteger.put('X',10);
        romanInteger.put('L',50);
        romanInteger.put('C',100);
        romanInteger.put('D',500);
        romanInteger.put('M',1000);

        int sum = romanInteger.get(s.charAt(s.length()-1));
        for(int i=s.length()-2;i>=0;i--) {
            if(romanInteger.get(s.charAt(i))<romanInteger.get(s.charAt(i+1)))
                sum-=romanInteger.get(s.charAt(i));
            else
                sum+=romanInteger.get(s.charAt(i));
        }

    return sum;
    }
}
