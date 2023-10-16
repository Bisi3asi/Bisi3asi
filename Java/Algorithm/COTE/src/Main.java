import java.util.Arrays;
import java.util.Scanner;

class Main {
    public int decision(int mid, int[] arr) {
        int target = arr[arr.length - 1], count = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (target - arr[i] >= mid) {
                count++;
                target = arr[i];
            }
        }
        return count;
    }

    public int solution(int n, int c, int[] arr) {
        int lt = Integer.MAX_VALUE, rt = 0, answer = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) < lt) lt = Math.abs(arr[i] - arr[i + 1]);
        }
        rt = Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
//            System.out.println("mid : " + mid + " lt : " + lt + " rt : " + rt);
            if (decision(mid, arr) >= c - 1) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        // 실행 시간 측정
        // 측정 코드 시작
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(T.solution(n, c, arr));
        sc.close();
        // 측정 코드 끝
        // long afterTime = System.currentTimeMillis();
        // long diffTime = afterTime-beforeTime;
        // System.out.println("실행시간(ms) " + diffTime);
    }
}