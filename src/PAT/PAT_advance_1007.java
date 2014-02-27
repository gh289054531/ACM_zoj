import java.util.Scanner;
/**
 * 有一个case没过
 * @author zhangpeng
 *
 */
public class PAT_advance_1007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		sc.close();
		int max = -1;
		int sum = 0;
		int begin = 0, end = 0;
		int maxbegin = 0;
		for (int i = 0; i < n; i++) {
			if (sum + input[i] < 0) {
				sum = 0;
				begin = i + 1;
			} else if (sum + input[i] > 0) {
				sum += input[i];
				if (sum > max) {
					maxbegin = begin;
					max = sum;
					end = i;
				}
			} else {
				sum = 0;
			}
		}
		if (max == -1) {
			System.out.println("0 " + input[0] + " " + input[n - 1]);
		} else {
			System.out.println(max + " " + input[maxbegin] + " " + input[end]);
		}
	}
}
