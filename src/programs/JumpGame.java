package programs;

public class JumpGame {

    static boolean canJump(int[] nums) {
        int target = nums.length-1;
        for(int i=nums.length-1;i>=0;i--) {
            if(target<=i+nums[i]){
                target =i;
            }
        }
        return target == 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,1,4};
        System.out.println(canJump(arr));
    }
}
