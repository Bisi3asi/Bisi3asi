import java.util.Scanner;

class Main{
    public int solution(int n) {
        int answer = n;
        for(int i = 1; i <= n; i++) {
            if (i == 1) {
                answer--;
                continue;
            }
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        // 실행   시간 측정
        // long beforeTime = System.currentTimeMillis();
        // 측정 코드 시작
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));
        sc.close();
        // 측정 코드 끝
        // long afterTime = System.currentTimeMillis();
        // long diffTime = afterTime-beforeTime;
        // System.out.println("실행시간(ms) " + diffTime);
    }
}