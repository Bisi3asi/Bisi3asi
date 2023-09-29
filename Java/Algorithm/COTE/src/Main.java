import java.util.Scanner;

class Main {
    public int solution(int n, int k, int[] arr) {
        int answer = 0, len = 0, cnt = 0, pl = 0;
        for(int i = 0; i < n; i++){
            if (arr[i] == 0) cnt++;
            while (cnt > k) {
                if (arr[pl] == 0) cnt--;
                pl++;
            }
            len = i-pl+1;
            if (answer < len) {
                answer = len;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // 실행  시간 측정
        // 측정 코드 시작
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(T.solution(n, k, arr));
        sc.close();
        // 측정 코드 끝
        // long afterTime = System.currentTimeMillis();
        // long diffTime = afterTime-beforeTime;
        // System.out.println("실행시간(ms) " + diffTime);
    }
}