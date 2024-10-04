package programs;

public class RemoveDuplicates2 {
    public static int removeDuplicates(int[] nums) {
        int count =0;
        for (int num : nums){
            if(count < 2 || num > nums[count-2] ){
                nums[count++] = num;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ch1 = new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates(ch1));
    }
}
