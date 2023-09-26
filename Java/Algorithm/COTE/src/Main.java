import java.util.*;

class Main{
    public int[] solution(int n, int[] arr) {
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        ArrayList<Integer> sortList = new ArrayList<>();
        for(int i = 0; i < n; i++) sortList.add(arr[i]);

        int[] answer = new int[n];
        sortList.sort(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            if (i == 0) rankMap.put(sortList.get(i), 1);
            else if (sortList.get(i-1).equals(sortList.get(i))) continue;
            else rankMap.put(sortList.get(i), i+1);
        }
        for (int i = 0; i < n; i++){
            answer[i] = rankMap.get(arr[i]);
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
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for(int i : T.solution(n, arr)) System.out.print(i + " ");
        sc.close();
        // 측정 코드 끝
        // long afterTime = System.currentTimeMillis();
        // long diffTime = afterTime-beforeTime;
        // System.out.println("실행시간(ms) " + diffTime);
    }
}