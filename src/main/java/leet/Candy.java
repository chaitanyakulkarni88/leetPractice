package leet;
//135
public class Candy {
    public static void main(String[] args) {
        Candy c = new Candy();
        int[] ratings = {1,2,6,5,4,3,1};
        System.out.println(c.candy(ratings));
    }

    public int candy(int[] ratings) {
        int[] candiesFromLeft = new int[ratings.length];
        candiesFromLeft[0] = 1;
        for(int i=1;i<ratings.length;i++) {
            if(ratings[i] > ratings[i-1]) {
                int value = candiesFromLeft[i - 1];
                candiesFromLeft[i] =value+1;
            }
            else
                candiesFromLeft[i] = 1;
        }

        int[] candiesFromRight = new int[ratings.length];

        candiesFromRight[candiesFromRight.length-1] = 1;
        for(int i =ratings.length - 2;i>=0;i--) {
            if(ratings[i] > ratings[i+1]) {
                int value = candiesFromRight[i + 1];
                candiesFromRight[i] = value+1;
            }
            else
                candiesFromRight[i] = 1;
        }

        //int[] maxOfBothCandies = new int[ratings.length];
        int sum = 0;
        for(int i=0;i< candiesFromLeft.length;i++) {
            sum += Math.max(candiesFromLeft[i],candiesFromRight[i]);
        }
        return sum;
    }
}
