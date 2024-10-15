package programs;

public class ContainerWithMostWater {

    public static int maxArea(int[] A) {
        int l = 0;
        int r = A.length - 1;
        int area = 0;
        while (l < r) {
            area = Math.max(area, Math.min(A[l], A[r]) * (r - l));
            if (A[l] < A[r])
                l++;
            else
                r--;
        }
        return area;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(A));
    }
}
