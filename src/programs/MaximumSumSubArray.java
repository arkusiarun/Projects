package programs;

public class MaximumSumSubArray {

    static int maxSubArray(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int n: arr) {
            sum = sum + n;
            if(sum>max) {
                max = sum;
            }
            if(sum<0) {
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Sum :" + maxSubArray(arr));
    }
}
