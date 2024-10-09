package programs;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        map.put(arr[0], 0);
        for (int i = 1; i < arr.length; i++) {
            int n = target - arr[i];
            if(map.containsKey(n)) {
                result[0] = map.get(n);
                result[1] = i;
                break;
            }
            map.put(arr[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,4};
        int target = 6;
        int[] result = twoSum(arr, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
