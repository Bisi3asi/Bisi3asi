import java.util.ArrayList;

public class BitMask {
    // 공집합을 제외한 배열의 모든 부분집합을 리턴하는 메소드
    public static ArrayList<ArrayList<Integer>> generateSubsets(int[] arr) {
        int n = arr.length;
        ArrayList<ArrayList<Integer>> totalSubset = new ArrayList<>();

        for (int i = 1; i < (1 << n); i++) {
            // 내부 루프를 순회하며 원소의 부분집합을 collect하는 list
            ArrayList<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(arr[j]);
                }
            }
            totalSubset.add(subset);
        }
        return totalSubset;
    }

    public static void main(String[] args) {
        // bit 1 : 0001 , 2 : 0010
        // AND 연산, 둘다 1이라면 1, 아니면 0
        System.out.println(1 & 2); // 0001 & 0010 = 0000
        // out : 0

        // OR 연산, 둘다 0이라면 0, 아니면 1
        System.out.println(1 | 2); // 0001 | 0010 = 0011
        // out : 3

        // XOR 연산, 둘의 비트값이 다르면 1, 아니면 0
        System.out.println(5 ^ 2); // 0101 ^ 0010 = 0111
        // out : 7

        // NOT 연산 : 모든 비트를 반전시킨 값을 리턴 (2의 보수)
        // 5 = 0000 .. 0000 0101(총 32자리수)
        // 5 반전 시 1111 .. 1111 1010(가장 왼쪽 비트가 1이므로 음수, -6)
        System.out.println(~5);
        // out : -6

        // << 연산, 1을 2비트만큼 왼쪽으로 시프트
        System.out.println(3 << 3); // 0011 << 3 = 0011000
        // out : 24

        // >> 연산, 5를 2비트만큼 오른쪽으로 시프트
        System.out.println(5 >> 2); // 0101 >> 2 = 0001
        // out : 1

        int[] arr = {1, 2, 3};
        System.out.println(generateSubsets(arr));
    }
}
