package test;

public class FindWanNum {
	public static void main(String[] args) {
		int n = 10000;
		System.out.println(n + "֮�ڵ������У�");
		findWanShu(n);
	}

	public static void findWanShu(int n) {
		// �����Ϊ���б��
		int count = 0;

		for (int i = 1; i <= n; i++) {
			int s = 0;
			for (int j = 1; j < i / 2 + 1; j++) {
				if (i % j == 0) {
					s += j;
				}
			}
			if (s == i) {
				System.out.print(i + " ");
				count++;
				if (count % 6 == 0) {
					System.out.println();
				}
			}

		}
	}
}
