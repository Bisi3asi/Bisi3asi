package JavaPractice;

final class fClass {
    final int fInt;
    fClass(int fInt){this.fInt = fInt;} /* 최초 입력값을 fInt로 지정하는 생성자*/
}
//class ffClass extends fClass {} * 오류 : final로 선언된 class는 상속받을 수 없음

class sClass {
    static int sInt = 3;
    sClass(){}
    sClass(int x){
        sInt = x; /* static 변수는 this가 필요없음, 객체가 아닌 클래스로 직접 접근 */
    }
}

class pClass { /* 싱글톤 패턴 시 유용하게 사용하는 private */
    private pClass() {} /* 생성자를 private으로 선언 시 new 활용 생성 제한 */
    private static pClass one;
    public static pClass getInstance() { /* 클래스 내부 메소드를 통해서만 인스턴스 생성이 가능하다. */
        if (one == null) { /* 정적 변수 one을 통해 1개의 인스턴스만 생성 가능하게끔 제한 */
            one = new pClass();
        }
        return one;
    }
}

public class StaticFinalPrivate {
// static final
    static final int sfInt = 42; /* 영구불변의 상수 활용 시 static final */

    public static void main(String[] args) {
// final
        fClass f1 = new fClass(3);
        System.out.println(f1.fInt);
//      f1.fInt = 4;  /* 오류 : final로 선언된 변수는 최초 초기화값에서 수정 불가 */
        final int fint2; /* final 변수 선언 후 초기화 안한 상태 */
        fint2 = 1; /* 변수값 최초 초기화 완료 */
//      fint2 = 2; /* 오류 : 변수값 초기화 한 후 값 변경은 제한 */

        sClass s1 = new sClass();
        sClass s2 = new sClass();
        System.out.println(sClass.sInt); /* 인스턴스가 아닌 클래스로 호출 */
        System.out.println(s1.sInt); /* 권장되지 않음 : static 선언 변수가 인스턴스를 통해 참조 */
        sClass.sInt = 4; /* 클래스의 static 변수 값 변화 3 → 4 */
        System.out.println(s1.sInt); /* 객체의 변수 값 또한 변화한다. */
        System.out.println(s2.sInt);
        s1.sInt = 2; /* 인스턴스에서의 static 변수로 접근, 변수 값 변화 4 → 2 */
        System.out.println(s1.sInt);
        System.out.println(s2.sInt);

//      pClass p1 = new pClass(); *오류 : private으로 선언된 생성자는 new로 인스턴스 생성 불가
        pClass p1 = pClass.getInstance(); /* getInstance 메소드를 통해 객체 최초 1회만 생성 가능 */
    }
}