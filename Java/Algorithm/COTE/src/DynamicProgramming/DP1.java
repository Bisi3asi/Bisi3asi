package DynamicProgramming;

import java.util.*;

class DP1 {
	static int[] dy;
	public static int solution(int n) {
		dy[1] = 1; // 확실한 부분은 메모이제이션을 사용한다. 분할 정복과 동일함
		dy[2] = 2;
		for(int i = 3; i <= n + 1; i++) {
			dy[i] = dy[i-2] + dy[i-1];
		}
		return dy[n + 1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dy = new int[n + 2];
		System.out.println(DP1.solution(n));
		sc.close();
	}
}
