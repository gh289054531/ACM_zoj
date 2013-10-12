package PAT;

import java.util.Scanner;

public class PAT1006 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int baiwei = n / 100;
		int shiwei = n % 100 / 10;
		int gewei = n % 10;
		StringBuilder sb = new StringBuilder();
		while (baiwei-- > 0) {
			sb.append("B");
		}
		while (shiwei-- > 0) {
			sb.append("S");
		}
		for (int i = 0; i < gewei; i++) {
			sb.append(i + 1);
		}
		System.out.println(sb.toString());
		sc.close();
	}

}
