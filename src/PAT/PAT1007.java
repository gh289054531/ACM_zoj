package PAT;

import java.util.Scanner;

public class PAT1007 {
	public static boolean IsPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int times = 0;
		int pre = 2;
		int after = 2;
		for (int i = 3; i <= n; i++) {
			if (IsPrime(i)) {
				pre = after;
				after = i;
				if ((after - pre) == 2) {
					times++;
				}
			}
		}
		System.out.println(times);
	}

}
