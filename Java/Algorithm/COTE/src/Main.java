import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

class Main {
    public int solution(int n, int k, int[] arr) {
        TreeSet<Integer> tset = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        Iterator<Integer> iter = tset.iterator();
        int answer = 0;
        if (tset.size() < k) return -1;
        else {
            for (int i = 0; i < k; i++) {
                answer = iter.next();
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        // 실행  시간 측정
        // 측정 코드 시작
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
        sc.close();
        // 측정 코드 끝
        // long afterTime = System.currentTimeMillis();
        // long diffTime = afterTime-beforeTime;
        // System.out.println("실행시간(ms) " + diffTime);
    }
}