import java.util.Scanner;

public class PAT_advance_1005 {
	public static String[] convert = new String[] { "zero", "one", "two",
			"three", "four", "five", "six", "seven", "eight", "nine" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String n = sc.nextLine();
			int sum = 0;
			for (int i = 0; i < n.length(); i++) {
				sum += Integer.parseInt(n.charAt(i) + "");
			}
			String temp = String.valueOf(sum);
			for (int i = 0; i < temp.length() - 1; i++) {
				System.out.print(convert[temp.charAt(i) - '0'] + " ");
			}
			System.out.println(convert[temp.charAt(temp.length() - 1) - '0']);
		}
		sc.close();
	}

}
