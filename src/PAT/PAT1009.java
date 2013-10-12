package PAT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PAT1009 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<String> al = new ArrayList<String>();
		while (sc.hasNext()) {
			String cur = sc.next();
			al.add(cur);
		}
		Collections.reverse(al);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < al.size(); i++) {
			sb.append(al.get(i));
			if (i != (al.size() - 1)) {
				sb.append(" ");
			}
		}
		System.out.println(sb.toString());
	}

}
