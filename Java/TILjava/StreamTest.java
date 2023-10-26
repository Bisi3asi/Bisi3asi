package JavaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        /* 1. 생성 */
        // Collections : stream
        // ArrayList<String> list = new ArrayList<>(List.of("Hello", "World"));
        // Stream<String> listStream = list.stream();
        Queue<String> queue = new LinkedList<>(List.of("Hello", "World"));
        Stream<String> queueStream = queue.stream();
        TreeSet<String> set = new TreeSet<>(List.of("Hello", "World"));
        Stream<String> setStream = set.stream();

        // 배열 : Arrays.stream
        String[] arr = new String[]{"Hello", "World"};
        Stream<String> arrStream = Arrays.stream(arr);

        // int, long, double : Int / Long / DoubleStream
        IntStream intStream = IntStream.range(0, 4); // 0, 1, 2, 3
        DoubleStream doubleStream = DoubleStream.of(1, 3, 5); // 1.0, 3.0, 5.0
        LongStream longStream = LongStream.rangeClosed(0, 4); // 0, 1, 2, 3, 4

        // Pattern
        Stream<String> patternStream = Pattern.compile("챔피언")
                .splitAsStream("챔피언 소리지르는 니가 챔피언 음악에 미치는 니가 챔피언 인생 즐기는 니가");
        patternStream.forEach(System.out::println); // out : !소리지르는 니가 \n 음악에 미치는 니가 \n 인생 즐기는 니가

        // iterate
        IntStream iterateStream = IntStream.iterate(3, x -> x + 3).limit(3);
        // out : 3, 6, 9

        // generate
        IntStream generateStream = IntStream.generate(() -> 10).limit(2);
        // out : 10, 10

        // concat
        // Stream<String> concatStream = Stream.concat(arrStream, queueStream);
        // concatStream.forEach(System.out::println);

        /* 2. 중간연산 */
        // filter
        // listStream.filter(s -> s.contains("H")).forEach(System.out::println);
        queueStream.filter(s -> s.length() == 5).forEach(System.out::println);

        // map
        setStream.map(String::toLowerCase).forEach(System.out::println);
        arrStream.map(s -> s + "!").forEach(System.out::println);

        // maptoInt/Long/Double
        int[] intArr = new int[]{1, 2, 3, 4, 5};
        IntStream intStream1 = Arrays.stream(intArr);
        intStream1.filter(i -> i < 4).max().stream().
                mapToDouble(v -> v + 1).forEach(System.out::println);

        String[] strArr = new String[]{"1", "3", "5", "7", "9"};
        int max = Arrays.stream(strArr).mapToInt(Integer::parseInt).max().getAsInt();
        System.out.println(max);

        // flatmap
        List<String> list1 = List.of("Alpha", "Beta");
        List<String> list2 = List.of("Charlie", "Delta");
        List<List<String>> list3 = List.of(list1, list2);
        System.out.println(list3);

        List<String> list4 = list3.stream().flatMap(Collection::stream).toList();
        System.out.println(list4);

        // sorted
        List<String> sortedList = List.of("Alpha", "Delta", "Charlie", "Beta").stream()
                .sorted().toList();
        System.out.println(sortedList); // out : Alpha, Beta, Charlie, Delta

        List<Integer> sortedIntList = IntStream.range(0, 10)
                .boxed().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sortedIntList); // out : 9, 8, 7, 6, 5, 4, 3, 2, 1, 0

        // peek
        double d = IntStream.range(0, 5)
                .filter(i -> i < 4)
                .mapToDouble(i -> i + 1)
                .peek(i -> System.out.print("중간: " + i + " "))
                .max().orElse(-1);
        System.out.println("\n최종: " + d);

        // skip
        List<String> skipList = List.of("Alpha", "Beta", "Charlie", "Delta")
                .stream().skip(2).toList();
        System.out.println(skipList); // out : Charlie, Delta

        // limit
        List<String> limitList = List.of("Alpha", "Beta", "Charlie", "Delta")
                .stream().limit(2).toList();
        System.out.println(limitList); // out : Alpha, Beta

        /* 3. 종료 연산 */
        // forEach, forEachOrdered
        List.of("눈", "누", "난", "나").parallelStream().forEach(System.out::println);
        // out : 난 \n 나 \n 눈 \n 누 (순서 보장 X)
        List.of("눈", "누", "난", "나").parallelStream().forEachOrdered(System.out::println);
        // out : 눈 \n 누 \n 난 \n 나 (순서 보장 O)

        // reduce
        int reduce1 = IntStream.rangeClosed(1, 5).reduce((a, b) -> a + b).getAsInt();
        System.out.println(reduce1); // out : 15 (1 + 2 + 3 + 4 + 5)

        int reduce2 = IntStream.rangeClosed(1, 5).reduce(3, (a, b) -> a + b);
        System.out.println(reduce2); // out : 18 (3 , 1 + 2 + 3 + 4 + 5)

        int num1 = 5, num2 = 10, num3 = 15;
        int result = Stream.of(num1, num2, num3)
                .reduce(0, (acc, value) -> acc + value, Integer::sum);
        // 초기값 : 0, 첫번째 인자 5
        // acc, value : 현재까지 누산된 결과 acc와 스트림 각 요소 value를 더함
        // Integer::sum : 누산된 결과를 더함

        // 0 + 5 = 5
        // 5 + 10 = 15
        // 15 + 15 = 30
        System.out.println(result); // out : 30

        // count, max, min, average
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        System.out.println(list.stream().count()); // out : 5
        System.out.println(list.stream().mapToInt(i -> i).max().getAsInt()); // out : 5
        System.out.println(list.stream().mapToInt(i -> i).min().getAsInt()); // out : 1
        System.out.println(list.stream().mapToDouble(i -> i).average().getAsDouble()); // out : 3.0

        // anyMatch, allMatch, noneMatch
        System.out.println(list.stream().anyMatch(i -> i < 1)); // out : false
        System.out.println(list.stream().allMatch(i -> i > 0)); // out : true
        System.out.println(list.stream().noneMatch(i -> i > 5)); // out : true


    }


}
