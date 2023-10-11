import java.util.HashSet;
import java.util.Scanner;

class Main {
    public String solution(int n, int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) set.add(i);

        if (set.size() != arr.length) return "D";
        return "U";
    }

    public static void main(String[] args) {
        // 실행  시간 측정
        // 측정 코드 시작
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.print(T.solution(n, arr));
        sc.close();
        // 측정 코드 끝
        // long afterTime = System.currentTimeMillis();
        // long diffTime = afterTime-beforeTime;
        // System.out.println("실행시간(ms) " + diffTime);
    }
}