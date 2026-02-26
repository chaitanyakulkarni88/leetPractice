package leet.arrayorstring;

import java.util.Arrays;

//238
public class ProductArrayExceptSelf {
//    public int[] productExceptSelf(int[] nums) {
//        int[] answer = new int[nums.length];
//        int k=0;
//        int j=0;
//        int productValue = 1;
//        for(int i=0;i< nums.length;i++) {
//            j=0;
//            productValue = 1;
//            while(j< nums.length) {
//                if(j!=i)
//                    productValue *= nums[j];
//
//                if(j== nums.length-1) {
//                    answer[k] = productValue;
//                    k++;
//                }
//                j++;
//            }
//        }
//        return answer;
//    }

    public int[] productExceptSelf(int[] nums) {

        int[] leftArray = new int[nums.length];
        int[] rightArray = new int[nums.length];
        int[] answer = new int[nums.length];

        leftArray[0] = 1;
        int index = 1;
        int i=0;

        while(index< leftArray.length) {
            leftArray[index] = leftArray[index-1]*nums[i];
            i++;
            index++;
        }

        rightArray[nums.length-1] = 1;
        index = nums.length-2;
        i= nums.length-1;
        while(index>=0) {
            rightArray[index] = rightArray[index+1]*nums[i];
            i--;
            index--;
        }

        i=0;
        for(i=0;i< answer.length;i++)
            answer[i] = leftArray[i]*rightArray[i];

        return answer;

    }

    public static void main(String[] args) {
        ProductArrayExceptSelf ps = new ProductArrayExceptSelf();
        int[] nums = {1,2,3,4};
        int[] result = ps.productExceptSelf(nums);
        Arrays.stream(result)
                .forEach(System.out::println);
    }
}
