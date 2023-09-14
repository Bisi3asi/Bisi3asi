package JavaPractice;
import java.util.*;

class SharedMemory extends Thread{
    static int x = 5;
    static boolean isQuit = false;
}

class PlusThread extends SharedMemory{
    public void run(){
        try{
            while(!SharedMemory.isQuit){
                System.out.println("x = " + SharedMemory.x);
                Thread.sleep(300);
                SharedMemory.x++;
            }
        } catch(Exception e){
            System.out.println(e);
    }
    }
}

class MinusThread extends Thread{
    public void run(){
        Scanner sc = new Scanner(System.in);
        while(SharedMemory.x!=0){
            sc.nextLine();
            System.out.println("[System] Enter가 입력되었습니다.");
            SharedMemory.x--;
        }
        SharedMemory.isQuit = true;
        System.out.println("[System] x값이 0입니다. 당신이 이겼습니다!");
    }
}
public class SharedMemoryTest {
    public static void main(String[] args) {

        PlusThread pt = new PlusThread();
        MinusThread mt = new MinusThread();

        System.out.println("[System] x가 0이 될때까지 Enter키를 누르세요.");
        pt.start();
        mt.start();
    }
}
