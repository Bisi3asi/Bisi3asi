package JavaPractice;
import java.io.*;

public class DeSerialTest {
    public static void main(String[] args) {
        try{
            FileInputStream fis = new FileInputStream("SerialTest.dat");
            // 객체를 역직렬화해 읽는 스트림 클래스의 객체를 변수 in에 저장
            ObjectInputStream in = new ObjectInputStream(fis);
            SerialInfo s;
            // in.readObject를 통해 읽어온 역직렬화해 읽어온 값을 SerialInfo형으로 변환해 저장한 s 변수가
            // null이 아닐때까지 반복 while문
            while((s=(SerialInfo)in.readObject())!=null) s.printInfo();
            fis.close();
            in.close();

        }catch (EOFException e){ /* 파일의 끝이라고 알려주는 End of File e 변수 */
            System.out.println("더는 읽을 데이터가 없습니다");
        }catch(Exception e){ /* 모든 에러타입에 대한 e 변수 */
            System.out.println(e);
        }
    }
}
