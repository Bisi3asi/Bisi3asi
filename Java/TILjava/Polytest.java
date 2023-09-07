package JavaPractice;

public class Polytest {
    public static void main(String[] args) {
        Person p1 = new Student("Choi", 43, 21); /* 서브 클래스의 객체는 슈퍼 클래스의 객체가 될 수 있다. */
//      Student p2 = new Person(); * 오류 : 슈퍼 클래스의 객체는 서브 클래스의 객체가 될 수 없다.
        Student s1 = (Student) p1; /* 슈퍼 클래스의 객체타입을 다시 서브 클래스 타입으로 형변환 */
        p1.eat(); /* 오버라이딩된 메소드의 경우는 인스턴스의 메소드가 호출  */
        p1.sleep(); /* 오버라이딩된 메소드의 경우는 인스턴스의 메소드가 호출  */
//      p1.study(); /* 오류 : Student 타입에서는 가지고 있으나, 오버라이딩된 메소드가 아닌 경우는 호출 불가 */
        Person people[] = {new Student(), new Workman()}; /* 위와 같이 배열로 슈퍼 클래스가 서브 클래스 객체 참조 가능 */
    }
}
