package PAT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PAT1012 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
		String[] nums = reader.readLine().split(" ");
		int n = Integer.parseInt(nums[0]);
		int A1 = 0;
		int A2 = 0;
		boolean A2exist = false;
		boolean A2Flag = true;
		int A3 = 0;
		int A4times = 0;
		int A4 = 0;
		int A5 = 0;
		for (int i = 0; i < n; i++) {
			int cur = Integer.parseInt(nums[i + 1]);
			switch (cur % 5) {
			case 0:
				if (cur % 2 == 0) {
					A1 += cur;
				}
				break;
			case 1:
				A2exist = true;
				if (A2Flag) {
					A2 += cur;
					A2Flag = false;
				} else {
					A2 -= cur;
					A2Flag = true;
				}
				break;
			case 2:
				A3++;
				break;
			case 3:
				A4 += cur;
				A4times++;
				break;
			case 4:
				if (cur > A5) {
					A5 = cur;
				}
				break;
			}
		}
		if (A1 == 0) {
			System.out.print("N ");
		} else {
			System.out.print(A1 + " ");
		}
		if (A2exist == false) {
			System.out.print("N ");
		} else {
			System.out.print(A2 + " ");
		}
		if (A3 == 0) {
			System.out.print("N ");
		} else {
			System.out.print(A3 + " ");
		}
		if (A4 == 0) {
			System.out.print("N ");
		} else {
			System.out.printf("%.1f", (A4 + 0.0) / A4times);
			System.out.print(" ");
		}
		if (A5 == 0) {
			System.out.print("N ");
		} else {
			System.out.print(A5);
		}
		System.out.println();
	}
}
