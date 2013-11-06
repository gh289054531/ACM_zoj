package other;

import java.util.Arrays;

/*
 * 对于数字1-N,有多个排列
 * 例如对于1 2 3 ，有排列：123 132 213 231 312 321
 * 假如给定某个排列，求它的下一个排列，如果当前给定排列是最大的排列了，那么返回空
 */
public class Prob4 {
	public static int[] nextSeq(int[] input) {
		if (input.length < 2) {
			return null;
		}
		for (int i = input.length - 2; i > -1; i--) {
			int cur = input[i];
			int[] subArray = Arrays.copyOfRange(input, i, input.length);
			Arrays.sort(subArray);
			int index = Arrays.binarySearch(subArray, cur);
			int offset = 1;
			while ((index + offset) < subArray.length && subArray[index + offset] <= cur) {
				offset++;
			}
			if ((index + offset) < subArray.length) {
				int temp = subArray[index + offset];
				for (int j = index + offset; j > 0; j--) {
					subArray[j] = subArray[j - 1];
				}
				subArray[0] = temp;
				System.arraycopy(subArray, 0, input, i, subArray.length);
				return Arrays.copyOf(input, input.length);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] test = new int[] { 2, 1, 3, 5, 4 };
		System.out.println(Arrays.toString(Prob4.nextSeq(test)));
	}
}
