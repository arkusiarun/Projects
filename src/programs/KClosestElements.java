package programs;

import java.util.ArrayList;
import java.util.List;

public class KClosestElements {

    static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = arr.length-1;
        while(end-start>=k) {
            if(Math.abs(arr[start]-x) > Math.abs(arr[end] -x)) {
                start++;
            } else {
                end--;
            }
        }
        for(int i=start;i<=end;i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int k = 4;
        int x = 3;
        for(Integer i: findClosestElements(arr, k, x)) {
            System.out.println(i);
        }
    }
}
