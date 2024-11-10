package programs;

public class JumpGameMinJumps {

    static int minJumps(int[] arr) {
        int jumpTill = 0;
        int jumps = 0;
        int currentEnd = 0;
        int maxJumpAllowed = arr.length - 1;
        for (int i = 0; i < arr.length -1; i++) {
            jumpTill = Math.max(jumpTill, i + arr[i]);
            if(arr[i]==0 && currentEnd == i) {;
                return -1;
            }
            if (i == currentEnd) {
                jumps++;
                currentEnd = jumpTill;
                if (jumpTill >= maxJumpAllowed) {
                    break;
                }
            }
        }
        return jumps;
    }


    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{2, 3, 1, 1, 4}));
        System.out.println(minJumps(new int[]{1, 0, 1, 1, 4}));
        System.out.println(minJumps(new int[]{2, 0, 1, 1, 4}));
    }
}