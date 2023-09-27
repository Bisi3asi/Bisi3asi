import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public ArrayList<Integer> solution(int a, int[] aArr, int b, int[] bArr) {
        int p1 = 0, p2 = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(aArr);
        Arrays.sort(bArr);
        while(p1 < a && p2 < b){
            if (aArr[p1] == bArr[p2]){
                answer.add(aArr[p1]);
                p1++;
            }
            else if (aArr[p1] < bArr[p2]) p1++;
            else p2++;
        }
        return answer;
    }

    public static void main(String[] args) {
        // 실행  시간 측정
        // long beforeTime = System.currentTimeMillis();
        // 측정 코드 시작
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int[] aArr = new int[a];
        for (int i = 0; i < a; i++) aArr[i] = sc.nextInt();

        int b = sc.nextInt();
        int[] bArr = new int[b];
        for (int i = 0; i < b; i++) bArr[i] = sc.nextInt();

        for (int i: T.solution(a, aArr, b, bArr)) System.out.print(i + " ");
        sc.close();
        // 측정 코드 끝
        // long afterTime = System.currentTimeMillis();
        // long diffTime = afterTime-beforeTime;
        // System.out.println("실행시간(ms) " + diffTime);
    }
}