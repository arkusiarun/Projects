package programs;

public class FindMissingNumberAP {
    static int findMissing(int[] arr, int n) {
        int a, l, s, i, sum = 0, missingNumber;
        a = arr[0];
        l = arr[n - 1];

        if ((a + l) % 2 == 0) {
            s = (a + l) / 2;
            s = s * (n + 1);
        } else {
            s = (n + 1) / 2;
            s = (a + l) * s;
        }

        for (i = 0; i <= n - 1; i++) {
            sum = sum + arr[i];
        }

        missingNumber = s - sum;

        return missingNumber;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 8, 10, 12, 14};
        int n = arr.length;
        System.out.println("The missing element is " + findMissing(arr, n));
    }
}
