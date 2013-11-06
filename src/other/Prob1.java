package other;

import java.util.LinkedList;

/*��һ���ַ�������ġ��������ظ��ַ����Ӵ������� abcda ���𰸿����� abcd ���� bcda */
public class Prob1 {
	public static String cal(String input) {
		int maxleft = 0;
		int maxright = 0;
		LinkedList<Character> queue = new LinkedList<Character>();
		for (int i = 0; i < input.length(); i++) {
			Character cur = input.charAt(i);
			if (!queue.contains(cur)) {
				queue.add(cur);
			} else {
				int curlength = queue.size();
				if (curlength > (maxright - maxleft + 1)) {
					maxright = i;
				}
				for (Character c : queue) {
					if (!c.equals(cur)) {
						queue.poll();
						maxleft++;
					} else {
						maxleft++;
						break;
					}
				}
			}
		}
		return input.substring(maxleft, maxright + 1);
	}

	public static void main(String[] args) {
		String test = "abcda";
		System.out.println(Prob1.cal(test));
		String test1 = "abcdefggadffgasr";
		System.out.println(Prob1.cal(test1));
	}
}
