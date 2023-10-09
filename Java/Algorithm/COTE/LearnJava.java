import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LearnJava {
    public static void main(String[] args) {

    Stream<String> stream1 = Stream.iterate(("hello"), str -> str + "o").limit(5);
    stream1.forEach(System.out::println);
    // out : hello \n helloo \n hellooo \n helloooo \n hellooooo
    IntStream stream2 = IntStream.iterate((0), val -> val + 3).limit(3);
    stream2.forEach(System.out::println);

    // out : 0 \n 3 \n 6

// filter 메소드
//        List<String> list = Arrays.asList("One", "One", "Two", "Three", "Four");
//        list.stream()
//            .filter(t ->t.contains("o"))
//            .forEach(System.out::println);
//        // out : "Two" "Four"
//
//        list.stream()
//            .filter(t -> t.equals("One"))
//            .forEach(System.out::println);
//        // out : "One" "One"
//
//        list.stream()
//            .filter(c -> c.endsWith("e"))
//            .forEach(System.out::println);
//        // out : "One" "One" "Three"
//
//        list.stream()
//            .filter(t -> t.length() >= 5)
//            .forEach(System.out::println);
//        // out : "Three"
//
//        // distinct
//        list.stream()
//            .distinct()
//            .forEach(System.out::println);
//        // out : "One" "Two" "Three" "Four"
//
//        // sort
//        list.stream()
//            .sorted()
//            .forEach(System.out::println);
//        // out : "Four" "One" "One" "Three" "Two"
//
//        list.stream()
//            .map(t -> t+"ayo")
//            .forEach(System.out::println);
//
//        String[] str = stream1.map(String::valueOf).toArray(String[]::new);

    }

}
