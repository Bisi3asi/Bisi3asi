package JavaPractice;

import java.util.function.*;

public class FunctionTest {
    public static void main(String[] args) {
        /* 1. Consumer : 입력 매개변수 값을 소비하는 추상 메소드 accept 구현 */
        // Consumer<T> : 타입 T의 객체 t를 받아 소비
        Consumer<String> cs1 = t -> System.out.println(t + " World!");
        cs1.accept("Hello");
        // out : "Hello World!"

        // BiConsumer<T, U) : 타입 T의 객체 t,타입 U의 객체 u를 받아 소비
        BiConsumer<String, String> cs2 = (t, u) -> System.out.println(t + " " + u);
        cs2.accept("Hello", "World!");
        // out : "Hello World!"

        // intConsumer : int value 값을 받아 소비
        IntConsumer cs3 = i -> System.out.println(i + i + i);
        cs3.accept(3);
        // out : 9

        // ObjIntConsumer : 타입 T의 객체 t와 int i를 받아 소비
        // accept 연산 과정에서 입력 매개변수 타입이 분간이 됩니다
        ObjIntConsumer<String> cs4 = (t, i) -> System.out.println(t + " " + i);
        cs4.accept("Java", 8);
        // out : Java 8

        /* 2. Supplier : 매개 값이 없고 리턴 값이 있는 추상 메소드 get 구현 */
        // Supplier<T>, get : 타입 T의 객체 t를 리턴
        Supplier<String> sp1 = () -> "Hello World!";
        System.out.println(sp1.get());
            // out : "Hello World!"

        // IntSupplier getAsInt : int 값을 리턴
        IntSupplier sp2 = () -> 12345;
        System.out.println(sp2.getAsInt());
            // out : 12345

        /* 3. Function : 매개 값을 특정 리턴값으로 매핑하는 apply 메소드 구현 */
        // Function<T, R> : 타입 T의 객체 t를 R로 매핑
        Function<Integer, String> fu1 = i -> i.toString().repeat(i);
        System.out.println(fu1.apply(10));
            // out : 10101010101010101010

        // Function<T, U, R> : 타입 T의 객체 t, 타입 U의 객체 u를 R로 매핑
        BiFunction<Integer, Integer, String> fu2 = (i1, i2) -> i1.toString().concat(i2.toString());
        System.out.println(fu2.apply(12, 34));
            // out : 1234

        // ToIntFunction<T> : 타입 T의 객체 t를 int로 매핑
        ToIntFunction<String> fu3 = String::length;
        System.out.println(fu3.applyAsInt("Hello World!"));
            // out : 12

        /* 4. Operator : 매개 변수 간의 연산 후 매개변수와 동일한 리턴 값을 제공하는 추상메소드 apply 구현 */
        // BinaryOperator : 동일 타입인 T 매개변수 두개 연산 후 T로 리턴
        BinaryOperator<Integer> op1 = (i1, i2) -> i1 * 10 + i2;
        System.out.println(op1.apply(1,4));
            // out : 14

        // UnaryOperator : 동일 타입인 T 매개변수 한개 연산 후 T로 리턴
        UnaryOperator<String> op2 = s -> "wa! " + s;
        System.out.println(op2.apply("Sans!"));
            // out : "wa! Sans!"

        // IntBinaryOperator : int 매개변수 두개 연산 후 int로 리턴
        // op1 예제와 동일한 기능임
        IntBinaryOperator op3 = op1::apply;
        System.out.println(op3.applyAsInt(1,4));
            // out : 14

        /* 5. Predicate : 매개 변수 간의 연산 후 boolean 리턴 값을 제공하는 추상메소드 test 구현 */
        // Predicate<T> : 타입 T 객체 t를 조사해 boolean 리턴
        Predicate<String> pr1 = s -> s.length() < 4;
        System.out.println(pr1.test("String"));
            // out : false

        // BiPredicate<T, U> 타입 T 객체 t와 타입 U 객체 u를 조사해 boolean 리턴
        BiPredicate<String, Character> pr2 = (s, c) -> s.charAt(0) == c;
        System.out.println(pr2.test("java", 'j'));
            // out : true


    }
}