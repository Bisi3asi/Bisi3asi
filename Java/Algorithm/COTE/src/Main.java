import java.util.Scanner;

class Main {
    public int solution(int n, int m, int[] arr) {
        for (int i = 1; i < n; i++) {
            int temp = arr[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) arr[j + 1] = arr[j];
                else break;
            }
            arr[j + 1] = temp;
        }
        // binary search
        int answer = 0, lt = 0, rt = n-1;
        while(lt <= rt){
            int mid = (lt + rt) / 2;
            if (arr[mid] == m) {
                answer = mid+1;
                break;
            }
            else if (arr[mid] > m) rt = mid-1;
            else lt = mid+1;
        }
        return answer;
    }

    public static void main(String[] args) {
        // 실행 시간 측정
        // 측정 코드 시작
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(T.solution(n, m, arr));
        sc.close();
        // 측정 코드 끝
        // long afterTime = System.currentTimeMillis();
        // long diffTime = afterTime-beforeTime;
        // System.out.println("실행시간(ms) " + diffTime);
    }
}