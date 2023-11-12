package JavaPractice;

import java.util.ArrayList;
import java.lang.annotation.*;

public class AnnotationTest {
    static class Parent {
        @Deprecated
        void method() {
            System.out.println("parent method1");
        }

        @SuppressWarnings("unused") // 미사용 코드 경고 억제
        int unused; // 미사용 필드 unused
    }

    @SuppressWarnings("deprecation")
    static class Child extends Parent {
        @Override
        void method() {
            System.out.println("child method1");
        }
    }

    /**
     * Functional Interface 예제
     */
    @FunctionalInterface
    interface FItest {
        void absMethod1();

        // void absMethod2(); // error : 함수형 인터페이스에서 2개 이상의 추상 메소드 사용 불가
        static void sttMethod() {
            System.out.println("static method");
        }

        default void dftMethod() {
            System.out.println("default method");
        }
    }

    /**
     * Target Annnotation test Target : 적용 가능 범위를 지정하는 어노테이션
     */
    static class testTargetAnnotation {
        int local;

        void method() {
        }
    }

    /**
     * 1. Repeatable을 적용해 어노테이션 중복 적용 테스트 2. 컨테이너 어노테이션 : 묶고자 하는 어노테이션을 배열로 멤버로 만든다 * 컨테이너 어노테이션의 메타 어노테이션 제한은 묶을 어노테이션과
     * 동일해야 함
     */
    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CustomAnnotationContainer {
        CustomAnnotation[] value(); // 묶고자 하는 CustomAnnotation을 배열로 멤버 선언
    }

    /**
     * 1. Documented을 적용한 사용자 정의 어노테이션 2. Repeatable을 적용하기 위해 위에서 만든 컨테이너.class를 반복한다고 @Repeatable 명시한다.
     */
    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(CustomAnnotationContainer.class)
    public @interface CustomAnnotation {
        String value() default "";
    }

    /**
     * Document 적용 여부에 따른 JavaDoc 차이를 확인한다.
     */
    @CustomAnnotation("document test")
    public static void testDocument() {
    }

    /**
     * Repeatable을 통한 어노테이션 중복 사용 확인
     */
    @CustomAnnotation("Hi")
    @CustomAnnotation("Hello")
    @CustomAnnotation("How are you")
    public static void testRepeatable() {
    }

    public static void main(String[] args) {
        Child c1 = new Child();
        c1.method();
        @SuppressWarnings("rawtypes") // 제너릭을 사용하는 클래스 타입 불특정 경고 억제
        ArrayList list = new ArrayList();
        testDocument();
        testRepeatable();
    }
}
