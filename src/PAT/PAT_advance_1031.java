import java.util.Scanner;

public class PAT_advance_1031 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		int n1 = (s.length() + 2) / 3;
		int n2 = s.length() - n1 - n1+2;
		char[][] result = new char[n1][n2];
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				result[i][j] = ' ';
			}
		}
		int index = 0;
		for (int i = 0; i < n1; i++) {
			result[i][0] = s.charAt(index++);
		}
		for (int j = 1; j < n2 - 1; j++) {
			result[n1 - 1][j] = s.charAt(index++);
		}
		for (int i = n1 - 1; i >= 0; i--) {
			result[i][n2 - 1] = s.charAt(index++);
		}
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
}
