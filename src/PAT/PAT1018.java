import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * ²¿·Ö³¬Ê±
 * @author zhangpeng
 *
 */
public class PAT1018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		int count = sc.nextInt();
		int jiaWin = 0, pingju = 0, jiaC = 0, jiaJ = 0, jiaB = 0, yiC = 0, yiJ = 0, yiB = 0;
		for (int i = 0; i < count; i++) {
			char jia = sc.next().charAt(0);
			char yi = sc.next().charAt(0);
			if (jia == 'J' && yi == 'J') {
				pingju++;
			} else if (jia == 'J' && yi == 'C') {
				yiC++;
			} else if (jia == 'J' && yi == 'B') {
				jiaWin++;
				jiaJ++;
			} else if (jia == 'C' && yi == 'J') {
				jiaWin++;
				jiaC++;
			} else if (jia == 'C' && yi == 'C') {
				pingju++;
			} else if (jia == 'C' && yi == 'B') {
				yiB++;
			} else if (jia == 'B' && yi == 'J') {
				yiJ++;
			} else if (jia == 'B' && yi == 'C') {
				jiaWin++;
				jiaB++;
			} else if (jia == 'B' && yi == 'B') {
				pingju++;
			}
		}
		sc.close();
		System.out.println(jiaWin + " " + pingju + " "
				+ (count - jiaWin - pingju));
		System.out.println((count - jiaWin - pingju) + " " + pingju + " "
				+ jiaWin);
		int jiaMax = jiaJ;
		if (jiaB > jiaMax) {
			jiaMax = jiaB;
		}
		if (jiaC > jiaMax) {
			jiaMax = jiaC;
		}
		if (jiaB == jiaMax) {
			System.out.print("B ");
		} else if (jiaC == jiaMax) {
			System.out.print("C ");
		} else {
			System.out.print("J ");
		}
		int yiMax = yiJ;
		if (yiB > yiMax) {
			yiMax = yiB;
		}
		if (yiC > yiMax) {
			yiMax = yiC;
		}
		if (yiB == yiMax) {
			System.out.println("B");
		} else if (yiC == yiMax) {
			System.out.println("C");
		} else {
			System.out.println("J");
		}
	}
}
