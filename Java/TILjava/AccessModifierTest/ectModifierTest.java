package JavaPractice.AccessModifierTest;

/**
 * static :: 외부 클래스는 선언 불가능
 **/
//static class A { // 컴파일 에러 : 외부 클래스로는 static 선언 불가능
//}

public class ectModifierTest {
    /**
     * 정적 전역 변수 : 다른 클래스에서도 호출 가능
     **/
    static int global1;
    static int global2;

    static { // 정적 변수 초기화 블록
        global1 = 3; // == static int global1 = 3;
        global2 = 2; // == static int global2 = 2;
    }

    /**
     * 정적 클래스
     **/
    static class B {
        static int value = 1; // static 변수
        int nonStatic = 0;

        static void printValue() { // static 메소드
            System.out.println(value);
        }
        // static void printnonStatic(){
        /** static 메소드는 non-static 변수를 참조할 수 없음 **/
        // 이유 : 메모리가 할당되는 시점이 다르기 때문
        // static 메소드 : 객체의 생성 없이 접근
        // non - static 변수 : new 연산 생성을 통해 메모리 영역에 접근하므로
        // System.out.println(nonStatic); // 컴파일 에러
        //  // non-static variable this cannot be referenced from a static context
        // }
    }

    /**
     * static main에서는 non-static 클래스를 생성할 수 없다
     **/
    // 이유 : non-static 클래스 생성자 또한 non-static이므로
    // class C {
    //    int nonStatic = 0;
    // }

    public static void main(String[] args) {
        B b1 = new B();
        B b2 = new B();
        b1.printValue(); // out : 1
        b1.value = 2; // 객체를 통한 static 변수 접근 및 값 변경(권장하지 않는 방법)
        b2.printValue(); // out : 2
        b2.value = 3; // 객체를 통한 static 변수 접근 및 값 변경(권장하지 않는 방법)
        B.printValue(); // out : 3 
        B.value = 4; // 클래스를 통한 static 변수 접근 및 값 변경
        B.printValue(); // out : 4

        /*참고 : non-static 클래스의 객체를 static 메소드에서 생성하는 법*/
        // ectModifierTest outerObj = new ectModifierTest(); // 외부 클래스의 객체 생성
        // C c1 = outerObj.new C(); // 외부 클래스 객체를 통한 클래스 C의 객체 생성

        /* non-static 클래스를 static main에서 생성 시 컴파일 에러 */
        // C c1 = new C(); // 컴파일 에러
        // non-static variable this cannot be referenced from a static context

        /* 정적 메소드는 오버라이딩이 불가능하다. */
        Person person = new Person();
        Human human = person;
        person.breathe(); // out : 나는 독특하게 숨을 쉽니다
        human.breathe(); // out : 나는 독특하게 숨을 쉽니다

        /* final 제어자 테스트 */
        F f = new F();
        // final로 초기화된 변수는 상수, 값 변경 불가능
        // f.fInt = 4; // 컴파일 에러

        /* abstract 클래스와 abstract의 자식 클래스 구현 */
        // Eatable eatable = new Eatable(); // 컴파일 에러
        // abstract 클래스는 객체 생성이 불가능
        Burger burger = new Burger();
        burger.eat(); // out : "버거를 먹습니다"
        burger.smell(); // out : "버거 냄새가 좋습니다"
    }
}

/**
 * static과 non-static을 활용한 개발 방법(예제)
 * static : 클래스의 공통적인 특성, 주로 유틸리티 클래스 혹은 상수 값의 클래스
 * 따라서 static은 다형성을 지원하지 않으므로 메소드 오버라이딩이 불가능
 * non-static : 객체 고유의 특성, 객체 상태나 인스턴스 변수를 사용하는 작업
 */
class Human {
    static String species = "H.SAPIENS"; // 공통적인 특성 : 인류의 종족명

    static void breathe() { // 공통적인 행위 : 숨쉬기
        System.out.println("사람은 숨을 쉽니다");
    }
    String name;
    int age;
    int height;
    int weight;
    int bloodType;
}

class Person extends Human {
    //  @Override
    static void breathe() { // 오버라이딩 X, static hiding으로 새로 추가, 별개의 메소드
        System.out.println("나는 독특하게 숨을 쉽니다");
    }
}

/**
 * final : 변경할 수 없음
 * final 클래스 : 상속 불가
 * final 메소드 : 오버라이딩을 통한 재정의 불가
 * final 변수 : 값을 변경할 수 없는 상수
 */
final class F {
    final int fInt = 0;
    final void finalMethod() {
        System.out.println("i am final method");
    }
    // 인자값 final로 선언하여 메소드 내부에서 인자값 변경 방지
    public int sum(final int a, final int b){
        // a = 3; // 컴파일 에러
        return a + b;
    }
}

/**
 * final 클래스는 상속 불가
 **/
// final class FSon extends F{} // 컴파일 에러

/**
 * 먹을 수 있는 것을 정의하는 abstract 클래스
 */
abstract class Eatable{
    abstract void eat(); // abstract 메소드 : 구현부 없음
    abstract void smell(); // abstract 메소드 : 구현부 없음
}

/**
 * abstract 클래스를 상속받은 클래스는 abstract 메소드를 모두 오버라이딩하여 구현해야 한다
 */
class Burger extends Eatable {
    @Override
    public void eat(){
        System.out.println("버거를 먹습니다");
    }
    public void smell(){
        System.out.println("버거 냄새가 좋습니다");
    }
}