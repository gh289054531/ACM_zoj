package PAT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PAT1001 {
	public static int calTimes(int n) {
		int times = 0;
		while (n != 1) {
			times++;
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = (3 * n + 1) / 2;
			}
		}
		return times;
	}

	public static void main(String[] args) throws IOException {
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new FileReader(new File("test.txt")));
		String line = null;
		while ((line = in.readLine()) != null) {
			int n = Integer.parseInt(line);
			System.out.println(PAT1001.calTimes(n));
		}

	}
}
