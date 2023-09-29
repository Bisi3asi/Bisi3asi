package JavaPractice.Package2;

public class ClassP2 {
    public void publicMethod(){
        System.out.println("I am public");
    }
    protected void protectedMethod(){
        System.out.println("i am protected");
    }
    void defaultMethod(){
        System.out.println("i am default");
    }
    private void privateMethod(){
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
        instance2.privateMethod(); // 컴파일 에러 : 같은 클래스의 멤버 X

    }
}

class ClassP2Son extends ClassP2{
}