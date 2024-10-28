package programs;

import java.util.Arrays;

public class HIndex {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int index = 0;
        int len = citations.length;
        for(int i=0;i<len;i++) {
            if(citations[len-1-i] > i) {
                index ++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println(hIndex(citations));
    }
}
