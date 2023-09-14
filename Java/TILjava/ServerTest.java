package JavaPractice;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class ServerTest {
    public static void main(String[] args) {
        // try 블록에서 생성된 변수는 외부 블록에서 사용 불가능하므로 외부에서 선언
        ServerSocket serverSocket = null; /* (연결 담당 서버 소켓) : ServerSocket 객체 변수 생성 */
        Socket socket = null; /* (연결 요청, 데이터 송수신 담당 일반 소켓) : Socket 객체 변수 생성 */

        try { /* Socket 생성 시 오류 발생 가능성 있으므로 try-catch 구문으로 감싸준다. */

            // [서버 소켓 : 연결을 입력받을 현 프로그램의 포트 번호를 선정]
            serverSocket = new ServerSocket(5050); /* 변수에 포트 번호를 5050으로 설정한 객체 생성해 값 초기화 */
            System.out.println("ready to connect");

            // [클라이언트로부터 연결 요청 대기, 요청 오면 연결 후 생성된 소켓 객체 저장]
            socket = serverSocket.accept(); /* 클라이언트로부터 연결 요청 대기, 요청 오면 연결 후 생성된 소켓 객체 저장 */
            System.out.println("Connected");

            // [Socket의 입력 스트림 가져오기] :: 클라이언트가 보낸 데이터를 읽어오는 기능
            /* 처리 순서 : 1. socket.getInputStream(): 소켓의 입력 스트림(바이트) 불러옴 -> 2. InputStreamReader: 입력된 바이트
                스트림을 문자 스트림으로 바꿈 -> 3. BufferedReader : 행 단위로 읽어옴  */
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // [Socket의 출력 스트림을 가져오기]
            /* 처리 순서 : 1. socket.getOutputStream(): 소켓의 출력 스트림(문자) 불러옴 -> 2. PrintWriter: 출력할 문자 스트림을
                바이트 스트림으로 변환 */
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            // [reader를 통해 읽어온 문자열을 행 단위 출력]
            System.out.println(reader.readLine());

            // [writer를 통해 데이터 전송]
            writer.println("Server is On");
            // writer.flush() 버퍼에 있는 데이터를 스트림으로 출력
            writer.flush(); /* writer는 버퍼 내 데이터가 다 차야 보내기 때문에 flush() 메소드를 통해 강제로 보냄 */

        }catch (Exception e){
            System.out.println(e);
        }finally {
            try{
            socket.close(); /* 소켓 닫기 */
            }catch (Exception e){}
            try{
                serverSocket.close(); /* 서버 소켓 닫기 */
            }catch (Exception e){}
        }
    }
}
