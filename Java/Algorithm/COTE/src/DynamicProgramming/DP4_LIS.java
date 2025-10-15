package DynamicProgramming;
import java.util.*;

class BBrick implements Comparable<BBrick> {
	int area, height, weight;
	int originalIndex; // 입력 순서

	BBrick(int area, int height, int weight, int originalIndex) {
		this.area = area;
		this.height = height;
		this.weight = weight;
		this.originalIndex = originalIndex;
	}

	@Override
	public int compareTo(BBrick o) {
		return o.area - this.area; // 내림차순: 밑면 넓이 큰 것 먼저
	}
}

public class DP4_LIS {
	static int[] dy;      // 최대 높이 저장
	static int[] path;    // 경로 추적용

	public static List<Integer> solution(List<BBrick> arr) {
		int n = arr.size();
		dy = new int[n];
		path = new int[n];
		Arrays.fill(path, -1);

		Collections.sort(arr); // 내림차순 정렬

		int maxIndex = 0;

		for (int i = 0; i < n; i++) {
			dy[i] = arr.get(i).height;
			for (int j = 0; j < i; j++) {
				// i 위에 j 블록 올릴 수 있는지 확인 (ArrayList 접근)
				if (arr.get(j).area > arr.get(i).area && arr.get(j).weight > arr.get(i).weight) {
					if (dy[i] < dy[j] + arr.get(i).height) {
						dy[i] = dy[j] + arr.get(i).height;
						path[i] = j;
					}
				}
			}
			if (dy[i] > dy[maxIndex]) maxIndex = i;
		}

		// 경로 추적: 위 -> 아래
		List<Integer> result = new ArrayList<>();
		int idx = maxIndex;
		while (idx != -1) {
			result.add(arr.get(idx).originalIndex);
			idx = path[idx];
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<BBrick> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int area = sc.nextInt();
			int height = sc.nextInt();
			int weight = sc.nextInt();
			arr.add(new BBrick(area, height, weight, i + 1)); // 1-based 번호
		}

		List<Integer> tower = solution(arr);

		// 출력
		System.out.println(tower.size()); // 블록 수
		for (int num : tower) {           // 위 -> 아래 순서
			System.out.println(num);
		}

		sc.close();
	}
}
