package JavaPractice;
import java.io.*;
import java.net.*;

public class ClientTest {
    public static void main(String[] args) {
        // 연결 요청, 데이터 송수신 담당 일반 소켓 : Socket 객체 변수 생성 */
        Socket socket = null; /* try 블록에서 생성된 변수는 외부 블록에서 사용 불가능하므로 외부에서 선언 */
        try{
            // [클라이언트 : 연결을 요청할 IP와 포트 번호를 가지고 소켓을 생성]
            socket = new Socket("127.0.0.1", 5050); /* Socket 생성자 (String IP, int port) */

            // [Socket의 입력 스트림 가져오기] :: 서버가 보낸 데이터를 읽어오는 기능
            /* 처리 순서 : 1. socket.getInputStream(): 소켓의 입력 스트림(바이트) 불러옴 -> 2. InputStreamReader: 입력된 바이트
                스트림을 문자 스트림으로 바꿈 -> 3. BufferedReader : 행 단위로 읽어옴  */
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // [Socket의 출력 스트림을 가져오기]
            /* 처리 순서 : 1. socket.getOutputStream(): 소켓의 출력 스트림(문자) 불러옴 -> 2. PrintWriter: 출력할 문자 스트림을
                바이트 스트림으로 변환 */
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            // [writer를 통해 데이터 전송]
            writer.println("Client is On");
            // writer.flush() 버퍼에 있는 데이터를 스트림으로 출력
            writer.flush(); /* writer는 버퍼 내 데이터가 다 차야 보내기 때문에 flush() 메소드를 통해 강제로 보냄 */

            // [reader를 통해 읽어온 문자열을 행 단위 출력]
            System.out.println(reader.readLine());

        }catch (Exception e){
            System.out.println(e);
        }finally {
            try{
                socket.close(); /* 소켓 닫기 */
            }catch(Exception e){}
        }
    }
}
