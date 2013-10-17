/**
 * 此题，先做手动推算：
 * P=1： D
 * P=2： 0 D
 * P=3: D-1 1 0
 * P=4： D-3 0 2 1
 * P=5: D-3 0 1 0 2
 * P=6: D-4 0 1 2 1 0
 * P=7: D-4 0 1 2 0 0 1
 * 
 * 推算思路：
 * 必须保证获得超过半数人同意，那么分情况：
 *     当P为偶数时，除开他自己外还需要P/2个人支持它。而在P-1时（也就是上一步时）一共有(P-1-1)/2个0，我们可以给这些人1个砖石，那么他们肯定会同意；再给某个人多1个砖石，他也会同意；其余人全部不给砖石。
 *     当P为奇数时，同上分析。
 * 有一点需要注意：当P为偶数时，最多只能给P/2-1个人0个砖石。所以第一个人为了保证自己利益最大一定会给P/2-1个人0个砖石！当P为奇数时同理分析。
 * 另外P=3算是个例外需要注意下。
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
