package practise.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Runner {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.stream().distinct().collect(Collectors.toList());
        Map<Boolean, List<Integer>> result = list.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        Map<Integer, Long> result2 = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }
}
