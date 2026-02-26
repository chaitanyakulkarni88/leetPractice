package leet.arrayorstring;
//42
public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        int[] height = {4,2,0,3,2,5};
        System.out.println(trw.trap(height));
    }
    public int trap(int[] height) {
        int[] maxFromLeft = new int[height.length];
        int[] maxFromRight = new int[height.length];

        int max = height[0];
        maxFromLeft[0] = height[0];
        for(int i=1;i< height.length;i++) {
           max = Math.max(height[i], max);
           maxFromLeft[i] = max;
        }

        max = height[height.length-1];;
        maxFromRight[height.length-1] = height[height.length-1];
        for(int i= height.length-2;i>=0;i--) {
            max = Math.max(height[i], max);
            maxFromRight[i] = max;
        }

        int sum = 0;
        int[] answer = new int[height.length];
        for(int i=0;i< answer.length;i++) {
            int min = Math.min(maxFromLeft[i],maxFromRight[i]);
            answer[i] = min;
            sum+=(answer[i]-height[i]);
        }

        return sum;
    }
}
