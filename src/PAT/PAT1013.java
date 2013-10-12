package PAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PAT1013 {

	public static boolean Isprime(int i) {
		if (i == 2) {
			return true;
		}
		if (i % 2 == 0) {
			return false;
		}
		for (int j = 2; j <= Math.sqrt(i); j++) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
	//	long start = System.currentTimeMillis();
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
		String[] x = reader.readLine().split(" ");
		reader.close();
		int m = Integer.parseInt(x[0]);
		int n = Integer.parseInt(x[1]);
		int i = 2;
		int primeTimes = 0;
		int printTimes = 0;
		StringBuilder sb = new StringBuilder(10000);
		while (true) {
			if (Isprime(i) == true) {
				primeTimes++;
				if (primeTimes >= m && primeTimes <= n) {
					sb.append(i);
					// System.out.print(i);
					printTimes++;
					if (primeTimes != n && printTimes != 10) {
						sb.append(" ");
						// System.out.print(" ");
					}

					if (printTimes == 10) {
						sb.append("\n");
						// System.out.println();
						printTimes = 0;
					}
				}
				if (primeTimes > n) {
					if (printTimes != 0) {
						sb.append("\n");
						// System.out.println();
					}
					break;
				}
			}
			i++;
			if (i % 2 == 0) {
				i++;
			}
		}
		System.out.println(sb.toString());
//		long end = System.currentTimeMillis();
	//	System.out.println(start - end);
	}

}
