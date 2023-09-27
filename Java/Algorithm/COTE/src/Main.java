import java.util.Arrays;
import java.util.Scanner;

class Main {
    public int[] solution(int a, int[] aArr, int b, int[] bArr) {
        int[] temp = new int[a];
        int index = 0;
        for (int i : aArr){
            for (int j : bArr){
                if (i == j) {
                    temp[index] = i;
                    index++;
                    break;
                }
            }
        }
        int[] answer = new int[index+1];
        for (int i = 0; i < index; i++)
            answer[i] = temp[i];
        Arrays.sort(answer);
        return answer;
    }

//        Arrays.sort(aArr);
//        Arrays.sort(bArr);
//        ArrayList<Integer> list = new ArrayList<>();
//
//        int ib = 0; // index of b
//        for (int i : aArr){
//            if(ib < b) {
//                for (int j = ib; j < b; j++) {
//                    if (i == bArr[j]) {
//                        list.add(bArr[j]);
//                        ib = j + 1;
//                        break;
//                    }
//                }
//            }
//        }
//        int[] answer = new int[list.size()];
//        for (int i = 0; i < list.size(); i++)
//            answer[i] = list.get(i);
//
//        return answer;
//    }

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

        for (int i : T.solution(a, aArr, b, bArr)) System.out.print(i + " ");
        sc.close();
        // 측정 코드 끝
        // long afterTime = System.currentTimeMillis();
        // long diffTime = afterTime-beforeTime;
        // System.out.println("실행시간(ms) " + diffTime);
    }
}