package programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodArray {

    public static List<Integer> getQueryResults(long N, List<List<Integer>> queries) {
        List<Integer> res = new ArrayList<>();
        int[][] arr = new int[queries.size()][3];
        List<Integer> goodArray = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int num = i;
            while (num % 2 == 0) {
                goodArray.add(num);
                num = num / 2;
            }
        }
        int index = 0;
        for (List<Integer> l : queries) {
            arr[index][0] = l.get(0);
            arr[index][1] = l.get(1);
            arr[index][2] = l.get(2);
            index++;
        }
        Collections.sort(goodArray);

        for (int i = 0; i < arr.length; i++) {
            int[] query = arr[i];
            int l = query[0];
            int r = query[1];
            int m = query[2];
            int prod = 1;
            for (int j = l - 1; j <= r - 1; j++) {
                prod = (prod * goodArray.get(j)) % m;
            }
            res.add(prod);
        }
        return res;
    }
}