
import java.util.Scanner;

class InsertionSort {
    public int[] solution(int n, int[] arr) { // 배열을 오름차순으로 정렬한다.
        for (int i = 1; i < n; i++){
            int tmp = arr[i], j;
            for (j = i-1; j >= 0; j--){
                if (arr[j] > tmp) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        // 실행  시간 측정
        // 측정 코드 시작
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for (int i : T.solution(n, arr)) System.out.print(i + " ");
        sc.close();
        // 측정 코드 끝
        // long afterTime = System.currentTimeMillis();
        // long diffTime = afterTime-beforeTime;
        // System.out.println("실행시간(ms) " + diffTime);
    }
}