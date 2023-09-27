import java.util.Arrays;
import java.util.Scanner;

class Main{
    public int solution(int n, int[][] arr) {
        int answer = 0;
        int[][] newArr = new int[n+1][n+1];
        for(int i = 0; i < n+2; i++){
            for(int j = 0; j < n+2; j++){
                if(i == 0 || i == n || j == 0 || j == n){
                    newArr[i][j] = 0;
                }
                else newArr[i][j] = arr[i-2][j-2];
            }
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                if(newArr[i][j] > newArr[i-1][j] && newArr[i][j] > newArr[i+1][j]
                    && newArr[i][j] > newArr[i][j-1] && newArr[i][j] > newArr[i][j+1]){
                    answer++;
                    System.out.println(i+","+j);
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        // 실행  시간 측정
        // long beforeTime = System.currentTimeMillis();
        // 측정 코드 시작
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        System.out.println(T.solution(n, arr));
        sc.close();
        // 측정 코드 끝
        // long afterTime = System.currentTimeMillis();
        // long diffTime = afterTime-beforeTime;
        // System.out.println("실행시간(ms) " + diffTime);
    }
}