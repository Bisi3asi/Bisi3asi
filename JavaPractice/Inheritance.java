package JavaPractice;

class Student extends Person{
    int stuno;
    Student(String name, int weight, int stuno){ /* super class의 생성자를 활용한 sub class 생성자 정의 */
        super(name, weight); /* Person(String name, int weight) {this.name = name; this.weight = weight;} */
        this.stuno = stuno;
    }
    Student(){}
    @Override
    void eat() { /* 메소드 오버라이딩 : 서브 클래스에서 슈퍼 클래스의 메소드를 재정의, 서브 클래스의 메소드가 우선 */
        super.eat();
        System.out.println("student eats more! / + 1 weight");
        this.weight += 1;
    }
    void study(){
        System.out.println(this.name + " studies hard / - 1 weight");
        this.weight -= 1;
    }
}
class Workman extends Person{
    int workno;
    Workman(String name, int weight, int workno){ /* 상속 클래스에서 super을 활용한 생성자 정의 */
        super(name, weight);
        this.workno = workno;
    }
    Workman(){}
    @Override
    void sleep() {
        super.sleep();
        System.out.println("workman is extremely tired.. / -1 weight");
        this.weight -= 1;
    }
}
public class Inheritance {
    public static void main(String[] args) {
        Person Kim = new Person("Kim", 58);
        Kim.showWeight();
        Kim.sleep();
        Kim.showWeight();

        Student Lee = new Student("Lee", 73, 201702490);
        Lee.showWeight();
        Lee.eat();
        Lee.study();
        Lee.showWeight();

        Workman Park = new Workman("Park", 92, 2019);
        Park.showWeight();
        Park.sleep();
        Park.showWeight();
    }
}
