package programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Programs {

    public static void main(String[] args) {
        getDistinctElements();
        getSegregateEvenOdd();
        getCountOfEveryElement();
        getAverage();
        reduceExample();
    }

    static void getDistinctElements() {
        int[] arr = new int[]{1,2,2,1,3,4};
        List<Integer> list = Arrays.stream(arr).distinct().mapToObj(Integer::new).collect(Collectors.toList());
        for(Integer n: list) {
            System.out.println(n);
        }
    }

    static void getSegregateEvenOdd() {
        int[] arr = new int[]{1,2,3,4,5,6};
        Map<Boolean, List<Integer>> result = Arrays.stream(arr).mapToObj(Integer::new).collect(Collectors.partitioningBy(i -> i % 2 == 0));
        for(boolean key: result.keySet()) {
            System.out.println("Key : " + key);
            System.out.print("Value : ");
            for(Integer value: result.get(key)) {
                System.out.print(value + " ");
            }
            System.out.println("");
        }
    }

    static void getCountOfEveryElement() {
        int[] arr = new int[]{1,2,1,4,5,6};
        Map<Integer, Long> result = Arrays.stream(arr).mapToObj(Integer::new).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for(Integer key: result.keySet()) {
            System.out.println("Key : " + key);
            System.out.println("Value : " + result.get(key));
        }
    }

    static void getAverage() {
        int[] arr = new int[]{1,2,1,4,5,6};
        Double result = Arrays.stream(arr).average().getAsDouble();
        System.out.println("Average :" + result);
    }

    static void reduceExample() {
        int[] arr = new int[]{12,3,4,5,10,8};
        Integer sum = IntStream.of(arr).filter(num -> num%3==1 || num%5==1)
                .reduce(0, (a,b) -> a+b);
        System.out.println("Reduce: " + sum);
    }


}