package programs;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0) {
                product = product * nums[i - 1];
            }
            result[i] = product;
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + 1 < nums.length) {
                product = product * nums[i + 1];
            }
            result[i] = result[i] * product;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        for(int n: productExceptSelf(nums)) {
            System.out.print(n + " ");
        }
    }
}
