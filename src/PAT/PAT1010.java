package PAT;

import java.util.Scanner;

public class PAT1010 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (sc.hasNext()) {
			int xishu = sc.nextInt();
			int zhishu = sc.nextInt();
			xishu *= zhishu;
			if (xishu == 0) {
				continue;
			} else {
				if (flag == true) {
					flag = false;
				} else {
					System.out.print(" ");
				}
				zhishu -= 1;
				System.out.print(xishu + " " + zhishu);
			}
		}
		if(flag==true){
			System.out.print("0 0");
		}
		System.out.println();
	}

}
