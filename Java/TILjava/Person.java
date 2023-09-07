package JavaPractice;

class Person {
    String name;
    int weight;
//생성자 정의, 메소드 오버로딩
    Person(String name, int weight){
        this.name = name;
        this.weight = weight;
    }
    Person(String name) {
        this.name = name;
    }
    Person(){}
// 메소드 정의
    void eat(){
        System.out.println(this.name + " eats / + 1 weight");
        this.weight += 1;
    }
    void sleep(){
        System.out.println(this.name + " sleeps / - 1 weight");
        this.weight -= 1;
    }
    void showWeight(){
        System.out.println("Name / Weight : " + this.name + " / " + this.weight);
    }
}
