package JavaPractice.AccessModifierTest.Package1;
import JavaPractice.AccessModifierTest.Package2.ClassP2;

public class ClassP1 extends ClassP2{ // ClassP2 : 외부 패키지의 클래스
    public static void main(String[] args) {
        ClassP2 instance1 = new ClassP2(); // ClassP1 : 외부 패키지의 클래스를 상속받은 자식 클래스
        instance1.publicMethod();
        // instance1.protectedMethod(); // 컴파일 에러 : protected는 외부 패키지에서의 접근 불가
        // instance1.defaultMethod(); // 컴파일 에러 : default는 외부 패키지에서의 접근 불가
        // instance1.privateMethod(); // 컴파일 에러 : private은 해당 클래스에서만 접근 가능

        ClassP1 instance2 = new ClassP1();
        instance2.publicMethod();
        instance2.protectedMethod();
        // instance2.defaultMethod(); // 컴파일 에러 : default는 외부 패키지에서의 접근 불가
        // instance2.privateMethod(); // 컴파일 에러 : private은 해당 클래스에서만 접근 가능

        ClassP2SonOuter instance3 = new ClassP2SonOuter();
        // instance3.protectedMethod(); // 컴파일 에러 :
        /* [ClassP2SonOuter는 protected 접근이 안되고 ClassP1은 되는 이유]
        * 공통점 : ClassP2와 외부 패키지이고 둘다 자식클래스이다.
        * 차이점 : 선언된 접근제어자가 default, public으로 다르다
        * 결론 :
            1. public으로 선언된 ClassP1은 외부 패키지(Package1)에서
            protected 멤버가 있는 패키지(Package2)로 접근 가능
            2. default로 선언된 ClassP2SonOuter는 외부 패키지(Package1)에서
            protected 멤버가 있는 패키지(Package2)로 접근 불가 : 외부 패키지이므로ㅜ
            */
    }
}
class ClassP2SonOuter extends ClassP2{}
// ClassP2SonOuter : 외부 패키지의 클래스를 상속 받은 자식 클래스(default)
// 하지만 default로 선언되었기 때문에 접근 불가
// default 멤버는 default 멤버 -> 외부 패키지, 외부 패키지 -> default 멤버로 접근 불가