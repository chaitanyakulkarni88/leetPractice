package leet;

public class JumpGame {
    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        //int[] nums = {2,3,1,1,4};
        int[] nums = {0,1};
        System.out.println(jg.canJump(nums));
    }
    public boolean canJump(int[] nums) {
        int maxJump = nums[0];

        for(int i=1;i< nums.length;i++) {
            if(i>maxJump)
                return false;
            maxJump = Math.max(maxJump,i+nums[i]);
        }
        return true;
    }
}
