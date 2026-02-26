package leet.arrayorstring;

public class ZigzagConversion {
    public static void main(String[] args) {
        ZigzagConversion zc = new ZigzagConversion();
        String input = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(zc.convert(input,numRows));
    }
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];

        for(int i=0;i<numRows;i++) {
            sb[i] = new StringBuilder();
        }
        int num = s.length();
        int i=0;
        while(i<num) {
            for(int index = 0;index<numRows&&i<num;index++) {
                sb[index].append(s.charAt(i));
                i++;
            }
            for(int index = numRows-2;index>0&&i<num;index--) {
                sb[index].append(s.charAt(i));
                i++;
            }
        }

        StringBuilder result = new StringBuilder();
        for(int index = 0;index<numRows;index++) {
            result.append(sb[index]);
        }

        return result.toString();
    }
}
