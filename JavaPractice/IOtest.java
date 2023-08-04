package JavaPractice;
import java.io.*;
import java.util.Scanner;

public class IOtest {
    public static void main(String[] args) {
        /* 스캐너 클래스 메소드 test */
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.nextLine();
//        int i1 = sc.nextInt();
        System.out.println(s1);
        System.out.println(s2);
//        System.out.println(i1);
        sc.close();

        /* FileWriter/Reader, try/catch 구문 test */
        try{ /*오류가 발생할 수도 있을 것이라 예상되는 코드 */
            FileWriter fw = new FileWriter("Hello World.txt"); /* 디렉토리에 txt 저장 */
            fw.write("Hello Java");
            fw.close();
        }
        catch (IOException e) { /* 해당 오류 발생 시 어떻게 대처할 것인가에 대한 코드 */
            System.out.println(e);
        }
//      finally {} 오류 발생 여부와는 상관없이 실행되어야 하는 코드
        try {
            FileReader fr = new FileReader("Hello World.txt");
            int i;
            while((i = fr.read())!= -1){ /* read 메소드 : 더 이상 읽을 글자 없을 시 -1 리턴 */
                char c = (char) i;
                System.out.printf("%c", c);
            }
            fr.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
//      finally {} 오류 발생 여부와는 상관없이 실행되어야 하는 코드
    }
}
