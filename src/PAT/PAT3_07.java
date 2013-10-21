package PAT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PAT3_07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(input));
		int index = list.size() - 1;
		boolean flag = false;
		while (true) {
			String cur = list.get(index);
			try {
				if (cur.length() > 1 && cur.startsWith("+")) {
					list.set(index, cur.substring(1));
					if (index == 0) {
						System.out.printf("%.1f", Double.parseDouble(list.get(0)));
						flag = true;
					}
				} else {
					Double.parseDouble(cur);
				}
			} catch (Exception e) {
				double result = 0;
				if (cur.equals("+")) {
					result = Double.parseDouble(list.get(index + 1)) + Double.parseDouble(list.get(index + 2));
				}
				if (cur.equals("-")) {
					result = Double.parseDouble(list.get(index + 1)) - Double.parseDouble(list.get(index + 2));
				}
				if (cur.equals("*")) {
					result = Double.parseDouble(list.get(index + 1)) * Double.parseDouble(list.get(index + 2));
				}
				if (cur.equals("/")) {
					if (Math.abs(Double.parseDouble(list.get(index + 2))) < 0.000001) {
						System.out.println("ERROR");
						flag = true;
					} else {
						result = Double.parseDouble(list.get(index + 1)) / Double.parseDouble(list.get(index + 2));
					}
				}
				list.set(index, String.valueOf(result));
				list.remove(index + 1);
				list.remove(index + 1);
				if (index == 0 && flag==false) {
					System.out.printf("%.1f", Double.parseDouble(list.get(0)));
					flag = true;
				}
			} finally {
				if (flag == true) {
					return;
				} else {
					index--;
				}
			}
		}
	}
}
