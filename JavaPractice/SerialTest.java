package JavaPractice;
import java.io.*;

// 직렬화 클래스 만드는 법
class SerialInfo implements java.io.Serializable{ /* Serializable 인터페이스 이식 */
    @Serial /* 직렬화를 하면 별도 serialVersionUID 선언 안할 시 java가 고유로 자동 생성하고 관리함 */
    // 직접 UID를 선언 시 클래스가 변경되더라도 UID 변동 없어 관리가 용이, 역직렬화 가능
    private static final long serialVersionUID = 1L;
    // 필드 : 직렬화 대상(O)
    String name;
    int i;
    private transient int password; /* 보안 등 기타 사유로 직렬화에서 제외하고 싶으면 transient를 붙임 */
    // 메소드 : 직렬화 대상(X)
    SerialInfo(String name, int i){
        this.name = name;
        this.i = i;
    }
    void printInfo(){
        System.out.println("name : "+name);
        System.out.println("i : "+i);
    }
}

public class SerialTest {
    public static void main(String[] args) {
        try{
            ObjectOutputStream out = /* 객체를 직렬화하여 쓰는 스트림 클래스에 객체를 담는 변수 out */
                    // 직렬화 객체를 쓸 수 있게 a.dat 파일을 쓰는 객체를 새로 생성하고 저장
                    new ObjectOutputStream(new FileOutputStream("SerialTest.dat"));
                    SerialInfo s1 = new SerialInfo("Jin", 1);
                    SerialInfo s2 = new SerialInfo("Tonic", 2);
                    // out 내 writeObject 변수 호출하여 객체를 직렬화하여 쓴다
                    out.writeObject(s1);
                    out.writeObject(s2);
                    // 파일을 닫고 저장
                    out.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
