package PAT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PAT1002 {

	public static void main(String[] args) throws FileNotFoundException {
		String[] convert = new String[] { "ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu" };
//		Scanner sc = new Scanner(new File("test.txt"));
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		int sum = 0;
		for (int i = 0; i < x.length(); i++) {
			char cur = x.charAt(i);
			sum += cur - '0';
		}
		String result = String.valueOf(sum);
		for (int i = 0; i < result.length(); i++) {
			System.out.print(convert[result.charAt(i) - '0']);
			if (i != result.length() - 1) {
				System.out.print(" ");
			}
		}
		System.out.println();
		sc.close();
	}
}
