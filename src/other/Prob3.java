/*
 * 假设一个数组长度为N，里面存放的是1-N之间的整数，求出每个整数的出现次数
 */
public class Prob3 {
	public static void calOccurTimes(int[] input, int N) {
		for (int i = 0; i < N; i++) {
			if (input[i] < 0) {
				continue;
			}
			int temp = input[i];
			input[i] = 0;
			if ((temp - 1) == i) {
				input[i] = -1;
				continue;
			}
			while (true) {
				if (input[temp - 1] > 0) {
					int temp_inner = input[temp - 1];
					input[temp - 1] = -1;
					temp = temp_inner;
				} else {
					input[temp - 1] = input[temp - 1] - 1;
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] input = new int[] { 1, 1, 1, 1, 8, 9, 2, 6, 8, 7 };
		int N = 10;
		Prob3.calOccurTimes(input, N);
		for (int i = 0; i < input.length; i++) {
			if (input[i] < 0) {
				System.out.println(i + 1 + "出现" + Math.abs(input[i]) + "次");
			}
		}
	}

}
