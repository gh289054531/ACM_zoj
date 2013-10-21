package PAT;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Stack;

public class PAT3_08 {
	static int s1, s2;
	static Stack<Integer> in = new Stack<Integer>();
	static Stack<Integer> out = new Stack<Integer>();

	public static void InQueue(Integer num) {
		if (in.size() == s1 && out.size() > 0) {
			System.out.println("ERROR:Full");
		} else if (in.size() == s1 && out.size() == 0) {
			while (in.size() != 0) {
				out.push(in.pop());
			}
			in.push(num);
		} else {
			in.push(num);
		}
	}

	public static void DeQueue() {
		if (out.size() == 0 && in.size() == 0) {
			System.out.println("ERROR:Empty");
		} else if (out.size() == 0 && in.size() > 0) {
			while (in.size() != 0) {
				out.push(in.pop());
			}
			System.out.println(out.pop());
		} else {
			System.out.println(out.pop());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		s1 = sc.nextInt();
		s2 = sc.nextInt();
		if (s1 > s2) {
			int temp = s2;
			s2 = s1;
			s1 = temp;
		}
		while (true) {
			String cur = sc.next();
			if (cur.equals("A")) {
				Integer num = sc.nextInt();
				InQueue(num);
			} else if (cur.equals("D")) {
				DeQueue();
			} else if (cur.equals("T")) {
				break;
			}
		}
	}

}
