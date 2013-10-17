import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class PAT3_04 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		//Scanner sc = new Scanner(new FileInputStream("test.txt"));
		int m = sc.nextInt();
		int[] xishu1 = new int[m];
		int[] zhishu1 = new int[m];
		for (int i = 0; i < m; i++) {
			xishu1[i] = sc.nextInt();
			zhishu1[i] = sc.nextInt();
		}
		int n = sc.nextInt();
		int[] xishu2 = new int[n];
		int[] zhishu2 = new int[n];
		for (int i = 0; i < n; i++) {
			xishu2[i] = sc.nextInt();
			zhishu2[i] = sc.nextInt();
		}
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int xishu = xishu1[i] * xishu2[j];
				int zhishu = zhishu1[i] + zhishu2[j];
				if (map.containsKey(zhishu) == false) {
					map.put(zhishu, xishu);
				} else {
					map.put(zhishu, map.get(zhishu) + xishu);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Integer key : map.descendingKeySet()) {
			if (map.get(key) != 0) {
				sb.append(map.get(key) + " " + key + " ");
			}
		}
		if (sb.length() != 0) {
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());
		}else{
			System.out.println("0 0");
		}


		int[] xishu3 = new int[m + n];
		int[] zhishu3 = new int[m + n];
		int len = 0;
		int i = 0, j = 0;
		for (; i < m && j < n;) {
			if (zhishu1[i] == zhishu2[j]) {
				zhishu3[len] = zhishu1[i];
				xishu3[len] = xishu1[i] + xishu2[j];
				i++;
				j++;
			} else if (zhishu1[i] > zhishu2[j]) {
				zhishu3[len] = zhishu1[i];
				xishu3[len] = xishu1[i];
				i++;
			} else {
				zhishu3[len] = zhishu2[j];
				xishu3[len] = xishu2[j];
				j++;
			}
			len++;
		}
		StringBuilder sb1 = new StringBuilder();
		for (int k = 0; k < len; k++) {
			if (xishu3[k] != 0) {
				sb1.append(xishu3[k] + " " + zhishu3[k] + " ");
			}
		}
		if (i == m && j != n) {
			for (int k = j; k < n; k++) {
				if (xishu2[k] != 0) {
					sb1.append(xishu2[k] + " " + zhishu2[k] + " ");
				}
			}
		}
		if (i != m && j == n) {
			for (int k = i; k < m; k++) {
				if (xishu1[k] != 0) {
					sb1.append(xishu1[k] + " " + zhishu1[k] + " ");
				}
			}
		}
		if (sb1.length() != 0) {
			sb1.deleteCharAt(sb1.length() - 1);
			System.out.println(sb1.toString());
		}else{
			System.out.println("0 0");
		}

	}
}
