import java.util.Scanner;

public class PAT_advance_1027 {
	public static String Convert(int color) {
		String temp = Integer.toString(color, 13);
		if (temp.length() == 1) {
			temp = "0" + temp;
		}
		return temp.toUpperCase();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int g = sc.nextInt();
		int b = sc.nextInt();
		System.out.println("#" + Convert(r) + Convert(g) + Convert(b));
		sc.close();
	}
}
