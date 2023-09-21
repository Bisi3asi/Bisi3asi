import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main{
    public String solution(int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i-1])
                list.add(arr[i]);
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            answer.append(list.get(i));
            if (i != list.size() - 1) answer.append(" ");
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        // 실행시간 측정
        // long beforeTime = System.currentTimeMillis();
        // 측정 코드 시작
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println((T.solution(n, arr)));
        // 측정 코드 끝
        // long afterTime = System.currentTimeMillis();
        // long diffTime = afterTime-beforeTime;
        // System.out.println("실행시간(ms) " + diffTime);
    }
}

