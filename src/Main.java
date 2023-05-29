import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> myList = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        CoolStream<Integer> cs = new CoolStream<>(myList);
        long cnt = cs
                .filter((x) -> x % 2 == 1)
                .map((x) -> x * x)
                .count(); // 4
        System.out.println(cnt);

        List<Integer> coolList = List.of(1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 5, 5);
        CoolStream<Integer> coolStream = new CoolStream<>(coolList);
        Optional<Integer> optionalSum = coolStream
                .distinct()
                .reduce((x, y) -> x + y);
        if (optionalSum.isPresent()) {
            System.out.println(optionalSum.get()); // 15
        }
    }
}