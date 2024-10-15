package programs;

import java.util.ArrayList;
import java.util.List;

public class JumpGame3 {

    List<Integer> l = new ArrayList<>();

    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length || l.size() == arr.length)
            return false;
        if (arr[start] == 0)
            return true;
        else if (l.contains(start) == false) {
            l.add(start);
            if (arr[start] == 1 && arr[arr.length - 1] == 0)
                return true;
            return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
        } else
            return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 1, 4};
        //System.out.println(canJump(arr));
    }
}
