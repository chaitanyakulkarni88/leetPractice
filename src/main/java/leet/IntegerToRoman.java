package leet;
//12
public class IntegerToRoman {
    public static void main(String[] args) {
        IntegerToRoman itr = new IntegerToRoman();
        int num = 3749;
        System.out.println(itr.intToRoman(num));
    }
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int[] intCodes = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for(int i=0;i<intCodes.length;i++) {
            while(num >= intCodes[i]) {
                num-=intCodes[i];
                result.append(symbols[i]);
            }
        }
        return result.toString();
    }
}
