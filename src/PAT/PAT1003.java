package PAT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PAT1003 {
	public static void main(String[] args) throws FileNotFoundException {
		 Scanner cin = new Scanner(System.in);
		//Scanner cin = new Scanner(new File("test.txt"));
		int lineNum = Integer.parseInt(cin.nextLine());
		String s = null;
		while (lineNum > 0) {
			s = cin.nextLine();
			int len = s.length();
			if (checkOne(s) == true) {
				int posP = s.indexOf('P');
				int posT = s.lastIndexOf('T');
				if ((checkChar(s, 'A', 0, posP)
						&& checkChar(s, 'A', posP + 1, posT)
						&& checkChar(s, 'A', posT + 1, len)
						&& (posT - posP) > 1 
						&& ((posT - posP - 1) * posP == (len- posT - 1))) == true) {
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}
			lineNum--;
		}
	}

	public static boolean checkChar(String s, char c, int begin, int end) {
		for (int i = begin; i < end; i++) {
			if (c != s.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkOne(String s) {
		char cur;
		for (int i = 0; i < s.length(); i++) {
			cur = s.charAt(i);
			if (cur == 'P' || cur == 'A' || cur == 'T') {
			} else {
				System.out.println("NO");
				return false;
			}
		}
		return true;
	}

}