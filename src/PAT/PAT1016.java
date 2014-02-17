

import java.math.BigInteger;
import java.util.Scanner;

public class PAT1016 {
	public static int count(String A, char DA) {
		int count = 0;
		for (int i = 0; i < A.length(); i++) {
			if (DA == A.charAt(i)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		char DA = (char) (sc.nextInt() + '0');
		String B = sc.next();
		char DB = (char) (sc.nextInt() + '0');
		sc.close();
		int countA = count(A, DA);
		int countB = count(B, DB);
		StringBuilder PA = new StringBuilder();
		while (countA-- > 0) {
			PA.append(DA);
		}
		StringBuilder PB = new StringBuilder();
		while (countB-- > 0) {
			PB.append(DB);
		}
		if (PA.length() == 0) {
			PA.append(0);
		}
		if (PB.length() == 0) {
			PB.append(0);
		}
		BigInteger Atemp = new BigInteger(PA.toString());
		BigInteger Btemp = new BigInteger(PB.toString());
		System.out.println(Atemp.add(Btemp).toString());
	}

}
