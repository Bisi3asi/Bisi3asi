package JavaPractice;

class Human {
    public void sleep(){
        System.out.println("사람은 잠을 잡니다");
    }
    public void eat(){
        System.out.println("사람은 밥을 먹습니다");
    }
}

class Worker extends Human {
    @Override
    public void sleep() {
        System.out.println("직장인은 잠잘 시간도 없습니다..");
    }

    @Override
    public void eat() {
        System.out.println("직장인은 밥먹을 시간도 없나 봅니다..");
    }
}

public class AnonTest {
    public static void main(String[] args) {
        Human worker = new Worker();
        worker.sleep();
        // out : 직장인은 잠잘 시간도 없습니다..
        worker.eat();
        // out : 직장인은 밥먹을 시간도 없나 봅니다..
    }
}
