package JavaPractice.Package1;
import JavaPractice.Package2.ClassP2;

public class ClassP1 extends ClassP2 {
    public static void main(String[] args) {
        ClassP2 instance1 = new ClassP2();
        instance1.publicMethod();
        instance1.protectedMethod(); // 컴파일 에러
        instance1.defaultMethod(); // 컴파일 에러
        instance1.privateMethod(); // 컴파일 에러

        ClassP1 instance2 = new ClassP1();
        instance2.publicMethod();
        instance2.protectedMethod();
        instance2.defaultMethod(); // 컴파일 에러
        instance2.privateMethod(); // 컴파일 에러
    }
}