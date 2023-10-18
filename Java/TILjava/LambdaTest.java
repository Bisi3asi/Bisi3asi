package JavaPractice;

public class LambdaTest {
    /**
     * 인자 값이 없는 함수형 인터페이스
     * 결과 값은 void로 출력하는 메소드를 구현한다
     */
    @FunctionalInterface
    public interface Par0 {
        void print();
    }

    /**
     * 입력 인자 값이 int 1개인 함수형 인터페이스
     * 결과 값을 int로 리턴한다
     */
    @FunctionalInterface
    public interface Par1 {
        int exec(int x);
    }

    /**
     * 입력 인자 값이 int 2개인 함수형 인터페이스
     * 결과 값을 int로 리턴한다
     */
    @FunctionalInterface
    public interface Par2 {
        int exec(int x, int y);
    }

    /**
     * 입력 인자 값이 1개, 제네릭 타입 T를 가진 함수형 인터페이스
     * 결과 값은 void로 출력하는 메소드를 구현한다
     */
    @FunctionalInterface
    public interface Gen1<T> {
        void print(T x);
    }

    /**
     * 람다식을 인자값으로 받을 메소드
     * 연산은 메인에서 구현하며, 매개변수로 int값 두 개, int값을 연산할 함수형 인터페이스를 받는다
     */
    static void method(int x, int y, Par2 p){
        System.out.println(p.exec(x, y));
    }

    public static void main(String[] args) {
        /* 0. 람다식의 소개 예제 */
            // 인터페이스의 메소드를 일회적으로 구현한 익명 클래스
            // 십의 자리 수 x, 일의 자리 수 y로 이루어진 두자리수를 만든다.
            Par2 ex1 = new Par2() {
                @Override
                public int exec(int x, int y) {
                    return x * 10 + y;
                }
            };
            // 위 익명 클래스 내용을 동일하게 람다식으로 구현한 것
            // 함수형 인터페이스 변수 = 람다식; 형태로 구현한다.
            Par2 ex2 = (x, y) -> x * 10 + y;

            // 호출 및 실행 결과
            int a = 5, b = 3;
            System.out.println(ex1.exec(5, 3)); // 익명 클래스
            // out : 53
            System.out.println(ex2.exec(5, 3)); // 람다식
            // out : 53

        /* 람다식의 소개 예제 끝 */

        /* 1. 람다식의 기본 문법 */
            // 람다식은 매개변수 리스트 (), 애로우 토큰 ->, 바디 { } 3요소로 구성
            Par1 ex3 = (int x) -> {return x + 10;};

            // 바디가 한 문장인 경우는 중괄호 { } 생략 가능
            // 바디가 두 문장 이상인 경우는 return 문과 중괄호 모두 사용해야 한다
            Par1 ex4 = (int x) -> x + 10;

            // return 문이 있으면 반드시 중괄호로 감싸야 한다
            // Par1 ex5 = (int x) -> return x + 10; // error

            // 인자값 타입이 추론 가능한 경우 생략 가능하다
            Par1 ex6 = (x) -> x + 10;
            // 단, 두 개 이상의 인자값을 받는 람다식의 경우 특정 매개변수 타입만 생략은 불가능하다
            // Par2 ex7 = (int x, y) -> x + y; // error : y도 int로 선언하던지 둘다 생략하던지 해야 함

            // 인자값이 한개일 때 괄호의 생략이 가능하다
            Par1 ex8 = x -> x + 10;

            // 매개변수가 없는 람다식
            Par0 ex9 = () -> {
                System.out.println("LambdaTest.main");
                System.out.println("LambdaLambdaLambda");
            };
            ex9.print();

            // 제네릭 타입의 람다식
            Gen1<String> ex10 = x -> System.out.println(x);
            ex10.print("hello");
                // out : hello
            Gen1<Integer> ex11 = x -> System.out.println(x);
            ex11.print(12345);
                // out : 12345

            // 람다식의 형변환
            // 람다식은 익명 객체이므로 타입이 없다 (함수형 인터페이스로 람다식을 참조할 뿐)
            Par1 ex12 = (abc) -> abc + 1;
            // 명시적 형변환(모든 인터페이스 타입 변수에 람다식 할당 행위는 캐스팅 연산자가 생략되어 있음)
            Par1 ex13 = (Par1)(abc) -> abc + 1;
            // 이런 특징을 활용해 최상위 클래스인 Object로 업캐스팅이 가능하다
            // 그 과정에서 함수형 인터페이스로 반드시 변환해야 한다
            Object ex14 = (Object)(Par1) abc -> abc + 1;




            // 람다식으로 구현한 함수형 인터페이스를 매개변수로 전달
            // 람다식을 매개변수로 전달 할 수 있는 것은 메소드를 메소드의 매개변수로 넣을 수 있음을 의미.
            // 즉 함수에 함수를 걸 수 있음 (이는 후술할 스트림 연산에서 람다식이 중간 연산으로 사용되는 이유이기도 함)
            method(100, 200, (x, y) -> x + y);
                // out : 300
            method(100, 200, (x, y) -> x * y);
                // out : 20000

            // 람다의 메소드 참조
            Par1 ex15 = Math::abs; // Math.abs(int a) 를 간략화
            System.out.println(ex15.exec(-13));
                // out: -13
            Par2 ex16 = Integer::max; // Integer.max(int a, int b)를 간략화
            System.out.println(ex16.exec(13,15));
                // out: 15
            Gen1<String> ex17 = System.out::println; // Sysout(String)을 간략화
            ex17.print("Hello!");
                // out: "Hello!"

        /* 람다식의 기본 문법 끝 */
    }
}
