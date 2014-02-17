import java.math.BigInteger;
import java.util.Scanner;

public class PAT1017 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger A = sc.nextBigInteger();
		BigInteger B = sc.nextBigInteger();
		sc.close();
		BigInteger Q = A.divide(B);
		BigInteger R = A.mod(B);
		System.out.println(Q.toString() + " " + R.toString());
	}
}
