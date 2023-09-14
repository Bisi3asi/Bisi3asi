package JavaPractice;

class AThread extends Thread{ /* 10초 간 1초 단위로 실행 시간을 출력하는 쓰레드 */
    public void run() {
        try {
            System.out.println("AThread : The World!");
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(1000); /* Thread 클래스 안의 sleep 메소드 */
                // 1000ms = 1초간 thread를 정지한다. * 사용에 try / catch 구문 필요
                System.out.println("AThread : " + i + "초 경과");
            }
            System.out.println("[!] AThread 실행 완료");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

class BThread extends Thread{ /* 0.5초 단위로 알파벳 출력하는 쓰레드 */
    public void run() {
        try {
            System.out.println("BThread : 알파벳을 셀게요");
            for (char alp = 'A'; alp <= 'Z'; alp++) {
                Thread.sleep(500); /* Thread 클래스 안의 sleep 메소드 */
                System.out.println("BThread : " + alp);
            }
            System.out.println("[!] BThread 실행 완료");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //실행할 쓰레드 객체 생성
        AThread at = new AThread();
        BThread bt = new BThread();

        // 실행 순서 : at 쓰레드 -> main 메소드 1 -> bt 쓰레드 -> main 메소드 2
        at.start();
        System.out.println("MainMethod1 : 저는 빠르게 실행됩니다");
        System.out.println("[!] MainMethod1 실행 완료");
        bt.start();

        int sum = 0;
        for(int i = 0; i <= 100; i++) sum += i;
        System.out.println("MainMethod2 : 1 ~ 100의 sum : "+sum);
        System.out.println("[!] MainMethod2 실행 완료");
    }
}
