import java.util.Scanner;

class Main {
    public int solution(int s, int e) {
        int pos = s, answer = 0;
        while (pos != e) {
            if (pos < e) {
                pos = (Math.abs(pos + 5 - e) < Math.abs(pos + 1 - e)) ? pos + 5 : pos + 1;
                answer++;
            }
            else {
                pos --;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // 실행 시간 측정
        // 측정 코드 시작
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(T.solution(s, e));
        sc.close();
        // 측정 코드 끝
        // long afterTime = System.currentTimeMillis();
        // long diffTime = afterTime-beforeTime;
        // System.out.println("실행시간(ms) " + diffTime);
    }
}