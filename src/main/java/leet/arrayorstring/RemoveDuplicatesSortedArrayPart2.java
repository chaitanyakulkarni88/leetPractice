package leet.arrayorstring;

//80
public class RemoveDuplicatesSortedArrayPart2 {
    public static void main(String[] args) {
        RemoveDuplicatesSortedArrayPart2 rdsa = new RemoveDuplicatesSortedArrayPart2();
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(rdsa.removeDuplicates(nums));
    }
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for(int i=0;i<nums.length;i++) {
            if(index == 0 || index == 1 || nums[index - 2] != nums[i]) {
                nums[index] = nums[i];
                index ++;
            }
        }
        return index;
    }
}
