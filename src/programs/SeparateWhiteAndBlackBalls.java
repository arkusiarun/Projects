package programs;

public class SeparateWhiteAndBlackBalls {

    public static void separateBalls(int[] balls) {
        int left = 0;                 // Start pointer
        int right = balls.length - 1;  // End pointer

        while (left < right) {
            // Move left pointer to the right until we find a black ball (1)
            while (left < right && balls[left] == 0) {
                left++;
            }
            // Move right pointer to the left until we find a white ball (0)
            while (left < right && balls[right] == 1) {
                right--;
            }
            // Swap the balls at left and right pointers
            if (left < right) {
                int temp = balls[left];
                balls[left] = balls[right];
                balls[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] balls = {0, 1, 0, 1, 1, 0, 0, 1, 0};

        System.out.println("Before separation:");
        for (int ball : balls) {
            System.out.print(ball + " ");
        }

        separateBalls(balls);

        System.out.println("\nAfter separation:");
        for (int ball : balls) {
            System.out.print(ball + " ");
        }
    }
}
