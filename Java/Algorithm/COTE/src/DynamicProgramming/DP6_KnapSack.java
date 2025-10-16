package DynamicProgramming;
/*
문제
명보네 동네 가게의 현금 출납기에는 k 가지 동전이 각각 n1, n2, … , nk개 씩 들어있다.
가게 주인은 명보에게 T원의 지폐를 동전으로 바꿔 주려고 한다.
이때, 동전 교환 방법은 여러 가지가 있을 수 있다.
예를 들어, 10원 짜리, 5원 짜리, 1원 짜리 동전이 각각 2개, 3개, 5개씩 있을 때, 20원 짜리 지폐를 다음과 같은 4가지 방법으로 교환할 수 있다.

20 = 10×2
20 = 10×1 + 5×2
20 = 10×1 + 5×1 + 1×5
20 = 5×3 + 1×5

입력으로 지폐의 금액 T, 동전의 가지 수 k, 각 동전 하나의 금액 pi와 개수 ni가 주어질 때 (i=1, 2,…, k)
지폐를 동전으로 교환하는 방법의 가지 수를 계산하는 프로그램을 작성하시오.
방법의 수는 2^31-1을 초과 하지 않는 것으로 가정한다.

입력
첫째 줄에는 지폐의 금액 T(0＜T ≤ 10,000),
둘째 줄에는 동전의 가지 수 k(0＜k ≤ 100),
셋째 줄부터 마지막 줄까지는 각 줄에 동전의 금액 pi(0＜pi ≤ T)와 개수 ni(0＜ni ≤ 1,000)가 주어진다.
pi와 ni사이에는 빈칸이 하나씩 있다.

출력
첫째 줄에 동전 교환 방법의 가지 수를 출력한다.
방법이 없을 때는 0을 출력한다.

예제 입력 1
20
3
5 3
10 2
1 5

예제 출력 1
4
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Coin implements Comparable<Coin> {
	int price;
	int cnt;

	Coin(int price, int cnt) {
		this.price = price;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Coin o) {
		return this.price - o.price; // 동전 가격별 오름차순 정렬
	}
}

public class DP6_KnapSack {
	// dy[i] 각 i라는 금액을 만들 수 있는 가지수
	static int[] dy;

	public static int solution(List<Coin> coins) {
		dy[0] = 0; // index 1 기반으로 0 미사용

		for (Coin coin : coins) {
			for (int i = dy.length - 1; i >= 1; i--) {
				for (int c = 1; c <= coin.cnt; c++) {
					if (i - c * coin.price > 0) {
						dy[i] += dy[i - c * coin.price];
						// i원을 만드는 모든 방법 + price 원 * c 개
						// ex) 15원인 경우 15 - 5 * 1 -> 10원을 만드는 모든 방법 + 5원 1개
					}
					else if (i - c * coin.price == 0) {
						dy[i] += 1;  // 0원을 만드는 방법을 직접 1로 처리
					}
				}
			}
		}
		return dy[dy.length-1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Coin> coins = new ArrayList<>();

		// 금액
		int amount = sc.nextInt();
		dy = new int[amount + 1];

		// 동전 개수
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int price = sc.nextInt();
			int cnt = sc.nextInt();
			coins.add(new Coin(price, cnt));
		}
		Collections.sort(coins); // 오름차순 정렬
		System.out.println(solution(coins));
		sc.close();
	}
}

