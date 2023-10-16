import java.util.Scanner;
import java.util.Stack;

class Pipe {
    public int solution(String s) {
        int cnt = 0, answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                cnt++;
            }
            else {
                cnt--;
                stack.pop();
                if (s.charAt(i-1) == '(') answer += cnt;
                else answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // 실행  시간 측정
        // 측정 코드 시작
        Pipe T = new Pipe();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(T.solution(s));
        sc.close();
        // 측정 코드 끝
        // long afterTime = System.currentTimeMillis();
        // long diffTime = afterTime-beforeTime;
        // System.out.println("실행시간(ms) " + diffTime);
    }
}
