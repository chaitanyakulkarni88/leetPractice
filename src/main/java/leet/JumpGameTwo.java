package leet;

public class JumpGameTwo {
    public static void main(String[] args) {
        JumpGameTwo jg = new JumpGameTwo();
        int[] nums = {2,3,1,1,4};
        //int[] nums = {1,2};
        System.out.println(jg.jump(nums));
    }
//    public int jump(int[] nums) {
//        int n = nums.length-1;
//        int jump = nums[0];
//        int minJumps = 0;
//
//        if(nums.length<=2)
//            return nums.length-1;
//
//
//        for(int i=1;i< nums.length;i++) {
//            if(i>jump)
//                break;
//            jump = Math.max(jump,i+nums[i]);
//            if(jump >= n){
//                minJumps = i+1;
//                break;
//            }
//
//        }
//        return minJumps;
//    }
int jump(int[] nums) {

    int totalJumps = 0;

    // destination is last index
    int destination = nums.length - 1;

    int coverage = 0, lastJumpIdx = 0;

    // Base case
    if (nums.length == 1) return 0;

    // Greedy strategy: extend coverage as long as possible
    for (int i = 0; i < nums.length; i++) {

        coverage = Math.max(coverage, i + nums[i]);

        if (i == lastJumpIdx) {
            lastJumpIdx = coverage;
            totalJumps++;

            // check if we reached destination already
            if (coverage >= destination) {
                return totalJumps;
            }
        }
    }

    return totalJumps;
}

}
