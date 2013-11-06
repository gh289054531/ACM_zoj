package PAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PAT1071超时 {

	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String data = r.readLine();
		r.close();
		HashMap<String, Integer> times = new HashMap<String, Integer>();
		int max = Integer.MIN_VALUE;
		String maxWord = null;
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
		Matcher matcher = pattern.matcher(data);
		while (matcher.find()) {
			String word = matcher.group().toLowerCase();
			Integer value = times.get(word);
			Integer temp;
			if (value == null) {
				temp = 1;
			} else {
				temp = value +1;
			}
			times.put(word, temp);
			if (temp > max) {
				maxWord = word;
				max = temp;
			} else if (temp == max) {
				maxWord = word.compareTo(maxWord) > 0 ? maxWord : word;
			}
		}
		System.out.println(maxWord + " " + max);
	}
}
