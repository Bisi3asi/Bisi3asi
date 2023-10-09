package JavaPractice;

class Outer {
    int a = 10;
    static int sa = 10;

    /* 1. 정적 중첩 클래스 */
    static class StaticNested {
        void exec() {
            System.out.println("I am Static Nested Class");
        }

        // 정적 클래스이므로 외부 클래스의 정적 멤버에만 접근 가능하다.
        void printA() {
//          System.out.println(a); // 컴파일 에러 : a는 non-static이므로 접근 불가
            System.out.println(sa);
        }
    }

    /* 2. 인스턴스 내부 클래스 */
    class Instance {
        void exec() {
            System.out.println("I am Instance Inner Class");
        }

        // 외부 클래스의 멤버 변수 접근이 가능하다.
        void printA() {
            System.out.println(a);
        }
    }

    /* 3. 지역 내부 클래스 */
    // 생성 방법 : 클래스 구현부를 통한 구현(메소드, 생성자)

    // 3-1. 메소드 내부에서 생성되는 지역 내부 클래스
    // 외부 클래스 객체 생성 후 메소드 호출 시 지역 클래스가 생성, 메소드가 실행
    void createLocal() {
        class Local {
            String s = "I am Local Inner Class, created by Method";

            void exec() {
                System.out.println(s);
            }
        }
        // 메소드 내부에서 지역 클래스가 생성, 메모리 로딩된 후 메소드 종료 시 삭제된다.
        Local local = new Local();
        local.exec();
    }

    // 3-2. 생성자를 통해서 생성되는 지역 내부 클래스
    // 외부 클래스 객체 생성과 동시에 지역 클래스가 생성, 메소드가 실행
    Outer() {
        class Local {
            void exec() {
                System.out.println("I am Local Inner Class, created by Constructor");
            }
        }
        Local local = new Local();
        local.exec();
    }

    /* 4. 익명 내부 클래스 */
    // 4-2. 익명 내부 클래스를 통해 일회성으로 구현할 부모 클래스 메소드
    void exec() {
    }
}

// 4-1. 익명 내부 클래스를 통해 일회성으로 구현할 인터페이스
abstract interface abInterface {
    abstract void method();
}

public class NestedClassTest {
    public static void main(String[] args) {
        /* 1. 정적 중첩 클래스 */
        // 객체 생성 시 외부 클래스 객체 생성이 필요 없음
        // → 이미 static으로 인해 클래스 멤버로 메모리에 올라가 있기 때문
        // 생성 방법 : 외부클래스.내부클래스 참조변수 = new 외부 클래스.내부클래스();
        Outer.StaticNested sn = new Outer.StaticNested();
        sn.exec(); // out : "I am Static Nested Class"
        sn.printA(); // out : 10

        /* 2. 인스턴스 내부 클래스 */
        // 객체 생성 시 외부 클래스 객체를 먼저 생성함
        // 생성 방법 : 외부클래스.내부클래스 참조변수 = new 외부클래스.내부클래스();
        Outer outer = new Outer();
        Outer.Instance is = outer.new Instance();
        is.exec(); // out : "I am Instance Inner Class"
        is.printA(); // out : 10

        /* 3. 지역 내부 클래스 */
        // 외부 클래스 객체 생성 후 지역 내부 클래스를 생성하는 메소드, 생성자 호출 시 메모리에 로딩
        Outer outer1 = new Outer(); // I am local Inner Class, created by Constructor
        outer1.createLocal(); // I am Local Inner Class, created by Method

        /* 4. 익명 내부 클래스 */
        // 객체 생성과 동시에 메소드 정의(오버라이딩)을 통해 사용되고 제거되는 클래스

        // 4-1. 익명 클래스를 활용한 인터페이스의 메소드를 일회성으로 구현
        abInterface ano1 = new abInterface() {
            @Override
            public void method() {
                System.out.println("I am anonymous class, from Interface");
            }
        }; // 세미콜론을 붙여 익명 클래스의 선언이 끝났음을 표현
        ano1.method();

        // 4-2. 익명 클래스를 활용한 외부 클래스의 메소드 오버라이딩
        // ★ 익명 클래스는 final로 선언된 외부 변수를 참조할 수 있다.
        int finalValue = 40;
        int externalValue = 30;
        Outer outer2 = new Outer() {
            @Override
            void exec() {
                System.out.println("I am anonymous class, from Outer method");
                System.out.println("I can read external finalValue : " + finalValue);
                // 익명 클래스에서 참조한 외부 변수의 값을 변경 시 컴파일 에러
                // 사실상 해당 변수는 final로 동작됨
                // System.out.println("I can read ExternalValue : " + externalValue);
            }
        }; // 세미콜론을 붙여 익명 클래스의 선언이 끝났음을 표현
        outer2.exec();

        // 외부 변수 값의 변화로 인해 externalValue는 익명 클래스 내부에서 참조 불가
        externalValue = 31;
    }
}