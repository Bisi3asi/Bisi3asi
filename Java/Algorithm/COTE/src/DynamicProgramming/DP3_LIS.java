package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Brick implements Comparable<Brick>{
	int area;
	int height;
	int weight;

	Brick(int area, int height, int weight) {
		this.area = area;
		this.height = height;
		this.weight = weight;
	}

	@Override
	public int compareTo(Brick o) {
		return o.area - this.area;
	}
}

public class DP3_LIS {
	static int[] dy; // dy에는 해당 블럭에 최대한 쌓을 수 있는 높이를 정의함
	public static int solution(List<Brick> arr) {
		dy = new int[arr.size()];
		Collections.sort(arr);

		// calculation logic
		for(int i = 0; i < dy.length; i++) {
			dy[i] = arr.get(i).height;
			for (int j = 0; j < i; j++) { // 역순으로 탐색하며 이전에 쌓았던 블록 호환여부를 확인
				if (arr.get(j).area > arr.get(i).area && arr.get(j).weight > arr.get(i).weight)
					dy[i] = Math.max(dy[i], dy[j] + arr.get(i).height);
			}
		}
		return Arrays.stream(dy).max().getAsInt();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Brick> arr = new ArrayList<>();

		for(int i = 0; i < n; i++) {
			int area = sc.nextInt();
			int height = sc.nextInt();
			int weight = sc.nextInt();
			arr.add(new Brick(area, height, weight));
		}
		System.out.println(DP3_LIS.solution(arr));
		sc.close();
	}
}
