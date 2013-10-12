package PAT;

import java.util.Scanner;

public class PAT1008 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		m=m%n;
		int[] nums=new int[n];
		for(int i=0;i<n;i++){
			nums[i]=sc.nextInt();
		}
		for(int i=n-m;i<n;i++){
			System.out.print(nums[i]+" ");
		}
		for(int i=0;i<n-m;i++){
			System.out.print(nums[i]);
			if(i!=n-m-1){
				System.out.print(" ");
			}
		}
	}

}
