package JavaPractice;
/* Override */
class Parent{
    int id = 0;
    void method1(){
        System.out.println("parent method1");
    }
}
class Child extends Parent {
    @Override
    void method() {
        System.out.println("child method1");
    }
}

/* Functional Interface */
@FunctionalInterface
interface FItest{
    void test();
}

public class AnnotationTest {

    public static void main(String[] args) {
        Child c1 = new Child();
        c1.method();
    }
}
