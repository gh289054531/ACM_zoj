package PAT;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class PAT3_06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String infix = sc.next();
		ArrayList<String> realInfix = new ArrayList<String>();
		sc.close();
		Stack<String> stack = new Stack<String>();
		String symbol = "";
		for (int i = 0; i < infix.length();) {
			char c = infix.charAt(i);
			if (Character.isDigit(c) == true) {
				int offset = 1;
				while (i + offset < infix.length()) {
					char temp = infix.charAt(i + offset);
					if (temp != '+' && temp != '-' && temp != '*' && temp != '/' && temp != '(' && temp != ')') {
						offset++;
					} else {
						break;
					}
				}
				realInfix.add(symbol + infix.substring(i, i + offset));
				symbol = "";
				i += offset;
			} else {
				if (c == '+' || c == '-') {
					if (realInfix.size() == 0) {
						if (c == '-') {
							symbol = String.valueOf(c);
						}
						i++;
						continue;
					}
					String pre = realInfix.get(realInfix.size() - 1);
					if (pre.equals("(")) {
						if (c == '-') {
							symbol = String.valueOf(c);
						}
						i++;
						continue;
					}
				}
				realInfix.add(String.valueOf(c));
				i++;

			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < realInfix.size(); i++) {
			String cur = realInfix.get(i);
			if (cur.length() > 1 || Character.isDigit(cur.charAt(0))) {
				sb.append(cur + " ");
				continue;
			}
			if (cur.equals("+") || cur.equals("-")) {
				while (true) {
					if (stack.isEmpty() == true) {
						stack.push(cur);
						break;
					}
					String peek = stack.peek();
					if (peek.equals("+") || peek.equals("-") || peek.equals("*") || peek.equals("/")) {
						sb.append(stack.pop() + " ");
					} else {
						stack.push(cur);
						break;
					}
				}
			} else if (cur.equals("*") || cur.equals("/")) {
				while (true) {
					if (stack.isEmpty() == true) {
						stack.push(cur);
						break;
					}
					String peek = stack.peek();
					if (peek.equals("*") || peek.equals("/")) {
						sb.append(stack.pop() + " ");
					} else {
						stack.push(cur);
						break;
					}
				}
			} else if (cur.equals("(")) {
				stack.push(cur);
			} else if (cur.equals(")")) {
				while (true) {
					String pop = stack.pop();
					if (pop.equals("(")) {
						break;
					} else {
						sb.append(pop + " ");
					}
				}
			}
		}
		while (stack.isEmpty() == false) {
			sb.append(stack.pop() + " ");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}
}
