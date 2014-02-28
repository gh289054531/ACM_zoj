package PAT;

import java.util.Scanner;
import java.util.TreeMap;

public class PAT_advance_1009 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k1 = sc.nextInt();
		int[] exp1 = new int[k1];
		double[] coe1 = new double[k1];
		for (int i = 0; i < k1; i++) {
			exp1[i] = sc.nextInt();
			coe1[i] = sc.nextDouble();
		}
		int k2 = sc.nextInt();
		int[] exp2 = new int[k2];
		double[] coe2 = new double[k2];
		for (int i = 0; i < k2; i++) {
			exp2[i] = sc.nextInt();
			coe2[i] = sc.nextDouble();
		}
		sc.close();
		TreeMap<Integer, Double> result = new TreeMap<Integer, Double>();
		for (int i = 0; i < k1; i++) {
			for (int j = 0; j < k2; j++) {
				int exp = exp1[i] + exp2[j];
				double coe = coe1[i] * coe2[j];
				if (result.containsKey(exp) == false) {
					result.put(exp, coe);
				} else {
					result.put(exp, result.get(exp) + coe);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int num = 0;
		for (Integer key : result.descendingKeySet()) {
			double coe = result.get(key);
			if (coe != 0) {
				num++;
				sb.append(" " + key + " " + String.format("%.1f", coe));
			}
		}
		System.out.println(num + sb.toString());
	}
}
