package JavaPractice;

class Person { /* 클래스 정의 */
    String name;
    int age;
    int weight;

    Person(String name, int age, int weight){ /* 생성자 : 객체 생성시 초기값 설정하는 메소드 */
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    Person(String name, int age){ /* 생성자 메소드 오버로딩 1 */
        this.name = name;
        this.age = age;
    }
    Person(String name){ /* 생성자 메소드 오버로딩 2 */
        this.name = name;
    }
    Person(){} /* 생성자 메소드 오버로딩 3 :: default 생성자 */

    void sleep(){
        this.weight -= 1;
        System.out.println(this.name + " Now sleeps");
    }

    void eat(){
        this.weight += 2;
        System.out.println(this.name + " Eats deliciously!");
    }
}

public class Constructor {
    public static void main(String[] args) {
//    JavaPractice.Person personNo1 = new JavaPractice.Person(); 직접 작성한 생성자가 있는 경우 디폴트 생성자 없으므로 객체 선언 시 오류
        Person personNo1 = new Person("Lee", 45, 98); /* 생성자 활용 객체를 선언한다 */
        System.out.println(personNo1.name);
        System.out.println(personNo1.age);
        System.out.println(personNo1.weight);
        personNo1.sleep();
        personNo1.eat();
        System.out.println(personNo1.weight);
    }
}