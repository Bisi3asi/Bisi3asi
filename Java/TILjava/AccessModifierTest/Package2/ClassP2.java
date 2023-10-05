package JavaPractice.AccessModifierTest.Package2;

/** 동일 패키지의 클래스를 상속받는 자식 클래스 **/
class ClassP2Son extends ClassP2 { }

/** 일반 동일 패키지의 클래스 **/
public class ClassP2 {
    public void publicMethod() {
        System.out.println("I am public");
    }

    protected void protectedMethod() {
        System.out.println("i am protected");
    }

    void defaultMethod() {
        System.out.println("i am default");
    }

    private void privateMethod() {
        System.out.println("i am private");
    }

    public static void main(String[] args) {

        ClassP2 instance1 = new ClassP2();
        instance1.publicMethod();
        instance1.protectedMethod();
        instance1.defaultMethod();
        instance1.privateMethod();

        ClassP2Son instance2 = new ClassP2Son();
        instance2.publicMethod();
        instance2.protectedMethod();
        instance2.defaultMethod();
        // instance2.privateMethod(); // 컴파일 에러 : 같은 클래스의 멤버가 아님

        DefaultClass defaultClass = new DefaultClass();
        // System.out.println(defaultClass.privateString); // 컴파일 에러 : public을 통한 private의 접근이 아님
        System.out.println(defaultClass.getPrivateString()); // public을 통한 접근
    }
}
/** private 멤버를 가지고 있는 클래스가 default로 선언된 경우 **/
class DefaultClass {
    private String privateString = "i am private in default class";

    public String getPrivateString() {
        return this.privateString;
    }
}

// public class Hello { // 컴파일 에러 : 한 개의 자바 파일에 두개의 public class는 불가능
//    private int h;
//}
class A {
    protected int a;
    private void p(){}
}
// public class B{} // 컴파일 에러 : public class가 java 파일 내 두개 존재
// protected, private으로 클래스 선언 불가능
// protected class C{} // 컴파일 에러
// private class D{} // 컴파일 에러
