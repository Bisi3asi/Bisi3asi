import java.util.Scanner;

class SelectionSort {
    public int[] solution(int n, int[] arr) { // 배열을 오름차순으로 정렬한다.
        for (int i = 0; i < n-1; i++){
            /* 1. 지정 : 요소의 위치를 지정할 인덱스를 지정 */
            int idx = i; // 인덱스는 loop에 맞춰 1씩 증가

            /* 2. 탐색 : 지정한 인덱스에 들어갈 요소를 탐색(가장 작은 수) */
            for (int j = i+1; j < n; j++){
                if (arr[j] < arr[idx]) // idx에 있는 현 요소보다 탐색한 요소가 작을 시
                    idx = j; // 해당 요소의 인덱스를 저장한다.
            } // for문 종료 시 : 가장 작은 요소의 인덱스가 idx에 저장된다.

            /* 3. 정렬 : 지정한 인덱스에 들어올 요소(가장 작은 수)와
            지정한 인덱스에 있는 현 요소를 교환 */
            int tmp = arr[i]; // 현 인덱스에 있는 요소는 들어올 요소(가장 작은수)와 위치를 교환
            arr[i] = arr[idx];
            arr[idx] = tmp;
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
        for (int i : T.solution(n, arr)) System.out.print(i+" ");
        sc.close();
        // 측정 코드 끝
        // long afterTime = System.currentTimeMillis();
        // long diffTime = afterTime-beforeTime;
        // System.out.println("실행시간(ms) " + diffTime);
    }
}