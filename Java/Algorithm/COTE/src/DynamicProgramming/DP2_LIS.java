package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

class DP2_LIS {
	static int[] dy;
	public static int solution(int[] arr) {
		dy = new int[arr.length];
		dy[0] = 1;
		for(int i = 1; i < arr.length; i++) {
			int max = 0;
			for (int j= i-1; j>=0; j--) {
				if(arr[j] < arr[i] && dy[j] > max) max = dy[j];
			}
			dy[i] = max + 1;
		}
		return Arrays.stream(dy).max().getAsInt();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(DP2_LIS.solution(arr));
		sc.close();
	}
}
