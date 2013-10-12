package PAT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class PAT1005 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("test.txt"));
		// Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		Set<Integer> repeat = new HashSet<Integer>();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			int cur = sc.nextInt();
			nums[i] = cur;
			while (cur != 1) {
				if (cur % 2 == 0) {
					cur = cur / 2;
					repeat.add(cur);
				} else {
					cur = (3 * cur + 1) / 2;
					repeat.add(cur);
				}
			}
		}
		LinkedList<Integer> result = new LinkedList<Integer>();
		for (int j = 0; j < n; j++) {
			if (repeat.contains(nums[j]) == false) {
				result.add(nums[j]);
			}
		}
		Collections.sort(result);
		int index = result.size() - 1;
		while (index > -1) {
			System.out.print(result.get(index--));
			if (index != -1) {
				System.out.print(" ");
			}
		}
		sc.close();
	}

}
