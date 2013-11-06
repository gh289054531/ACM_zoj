package other;

//求串的最长回文子串
public class Prob2 {

	public static  String longestSubPalindrome(String input) {
		int start = -1;
		int end = -1;
		for (int i = 0; i < input.length(); i++) {
			int disToCenter1 = calLength1(input, i);
			int disToCenter2 = calLength2(input, i);
			if ((disToCenter1 * 2 - 1) > (disToCenter2 * 2)) {
				if ((disToCenter1 * 2 - 1) > (end - start)) {
					start = i - disToCenter1 + 1;
					end = i + disToCenter1;
				}
			} else {
				if ((disToCenter2 * 2) > (end - start)) {
					start = i - disToCenter2 + 1;
					end = i + 1 + disToCenter2;
				}
			}
		}
		return input.substring(start, end);
	}

	public static int calLength1(String input, int center) {
		int disToCenter = 0;
		while (center - disToCenter > 0 && (center + disToCenter) < input.length()) {
			if (input.charAt(center - disToCenter) == input.charAt(center + disToCenter)) {
				disToCenter++;
			} else {
				break;
			}
		}
		return disToCenter;
	}

	public static int calLength2(String input, int center) {
		int disToCenter = 0;
		while (center - disToCenter > 0 && (center + 1 + disToCenter) < input.length()) {
			if (input.charAt(center - disToCenter) == input.charAt(center + 1 + disToCenter)) {
				disToCenter++;
			} else {
				break;
			}
		}
		return disToCenter;
	}

	public static void main(String[] args) {
		String test="ffabcbaabcdeedcbafsfds";
		System.out.println(Prob2.longestSubPalindrome(test));
	}
}
