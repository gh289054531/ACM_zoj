package PAT;

import java.util.ArrayList;
import java.util.Scanner;

public class PAT2_07 {
	static int maxPrimeUpper = 65536;

	public static boolean IsPrime(int num) {
		if (num == 2) {
			return true;
		}
		if (num % 2 == 0) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		if (N == 1) {
			System.out.println("1=1");
			return;
		}
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < maxPrimeUpper; i++) {
			if (IsPrime(i) == true) {
				primes.add(i);
			}
		}
		System.out.print(N + "=");
		while (N != 1) {
			for (int i = 0; i < primes.size(); i++) {
				int zhishu = 0;
				int curPrime = primes.get(i);
				while (N % curPrime == 0) {
					zhishu++;
					N = N / curPrime;
				}
				if (N != 1) {
					if (zhishu > 1) {
						System.out.print(curPrime + "^" + zhishu + "*");
					} else if (zhishu == 1) {
						System.out.print(curPrime + "*");
					}
				} else {
					if (zhishu > 1) {
						System.out.println(curPrime + "^" + zhishu);
					} else if (zhishu == 1) {
						System.out.println(curPrime);
					}
					return;
				}
			}
		}
	}
}
