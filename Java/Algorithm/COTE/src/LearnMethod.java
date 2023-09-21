import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LearnMethod {
    public static void main(String[] args) {
        // IntStream, LongStream
        IntStream.range(1, 10).forEach(System.out::println);
        // out : 1 ~ 9
        IntStream.rangeClosed(1, 10).forEach(System.out::println);
        // LongStream.range(1, 10000000).forEach(System.out::println); //
        // out : 1 ~ 9999999 (DO NOT TRY THIS AT HOME)

        // 오토박싱 : primitive 타입의 경우 오토박싱 처리 할 시 오버헤드 성능저하 우려
        // 제너릭을 이용한 클래스로 사용하려면 박싱을 해서 사용해야한다.
        Stream<Integer> stream1 = IntStream.range(1, 10).boxed(); // 박싱 적용
        IntStream stream2 = IntStream.range(1, 10); // 언박싱

        // filter 메소드
        List<String> list = Arrays.asList("One", "One", "Two", "Three", "Four");
        list.stream()
            .filter(t ->t.contains("o"))
            .forEach(System.out::println);
        // out : "Two" "Four"

        list.stream()
            .filter(t -> t.equals("One"))
            .forEach(System.out::println);
        // out : "One" "One"

        list.stream()
            .filter(c -> c.endsWith("e"))
            .forEach(System.out::println);
        // out : "One" "One" "Three"

        list.stream()
            .filter(t -> t.length() >= 5)
            .forEach(System.out::println);
        // out : "Three"

        // distinct
        list.stream()
            .distinct()
            .forEach(System.out::println);
        // out : "One" "Two" "Three" "Four"

        // sort
        list.stream()
            .sorted()
            .forEach(System.out::println);
        // out : "Four" "One" "One" "Three" "Two"

        list.stream()
            .map(t -> t+"ayo")
            .forEach(System.out::println);

        String[] str = stream1.map(String::valueOf).toArray(String[]::new);

    }

}
