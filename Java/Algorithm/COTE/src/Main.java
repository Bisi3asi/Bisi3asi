import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public int solution(int n, int k) {
        int index = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);

        while(list.size() > 1){
            index = (index + k - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        // 실행  시간 측정
        // 측정 코드 시작
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(T.solution(n, k));
        sc.close();
        // 측정 코드 끝
        // long afterTime = System.currentTimeMillis();
        // long diffTime = afterTime-beforeTime;
        // System.out.println("실행시간(ms) " + diffTime);
    }
}