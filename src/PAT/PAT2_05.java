package PAT;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class PAT2_05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		int n = sc.nextInt();
		int[] nums = new int[n];
		double sum = 0.0;
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
			sum += nums[i];
		}
		sc.close();
		double avg = sum / n;
		double value = 0.0;
		for (int i = 0; i < n; i++) {
			double cur = nums[i] - avg;
			value += cur * cur;
		}
		System.out.printf("%.5f\n", Math.sqrt(value / n));
	}

}
