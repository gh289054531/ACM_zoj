/**
 * ���⣬�����ֶ����㣺
 * P=1�� D
 * P=2�� 0 D
 * P=3: D-1 1 0
 * P=4�� D-3 0 2 1
 * P=5: D-3 0 1 0 2
 * P=6: D-4 0 1 2 1 0
 * P=7: D-4 0 1 2 0 0 1
 * 
 * ����˼·��
 * ���뱣֤��ó���������ͬ�⣬��ô�������
 *     ��PΪż��ʱ���������Լ��⻹��ҪP/2����֧����������P-1ʱ��Ҳ������һ��ʱ��һ����(P-1-1)/2��0�����ǿ��Ը���Щ��1��שʯ����ô���ǿ϶���ͬ�⣻�ٸ�ĳ���˶�1��שʯ����Ҳ��ͬ�⣻������ȫ������שʯ��
 *     ��PΪ����ʱ��ͬ�Ϸ�����
 * ��һ����Ҫע�⣺��PΪż��ʱ�����ֻ�ܸ�P/2-1����0��שʯ�����Ե�һ����Ϊ�˱�֤�Լ��������һ�����P/2-1����0��שʯ����PΪ����ʱͬ�������
 * ����P=3���Ǹ�������Ҫע���¡�
 */
package PAT;

import java.util.Scanner;

public class PAT2_10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int D = sc.nextInt();
		int P = sc.nextInt();
		sc.close();
		if (P == 3) {
			System.out.println(D - 1);
		} else {
			System.out.println(D - (3 + (P - 4) / 2));
		}
	}

}
