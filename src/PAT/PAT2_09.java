package PAT;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PAT2_09 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		//Scanner sc = new Scanner(new File("test.txt"));
		int n = sc.nextInt();
		int[] boxs = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			int curitem = sc.nextInt();
			for (int j = 0; j < n; j++) {
				if (100 - boxs[j] >= curitem) {
					if (j > max) {
						max = j;
					}
					boxs[j] += curitem;
					System.out.println(curitem + " " + (j + 1));
					break;
				}
			}
		}
		System.out.println(max + 1);
	}

}
