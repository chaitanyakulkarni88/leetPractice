package leet.twopointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater cw = new ContainerWithMostWater();
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(cw.maxArea(height));
    }
    public int maxArea(int[] height) {
        int maxArea = 0;
        int startPointer = 0;
        int endPointer = height.length-1;

        while(startPointer<endPointer) {
            if(height[startPointer] < height[endPointer]) {
                maxArea = Math.max(maxArea, height[startPointer] * (endPointer-startPointer));
                startPointer++;
            }
            else {
                maxArea = Math.max(maxArea, height[endPointer] * (endPointer-startPointer));
                endPointer--;
            }
        }
        return maxArea;
    }
}
