//JAVA部分超市，用C过
package PAT;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class PAT3_05 {


	public static void main(String[] args) {
		int[] nums=new int[100000];
		Scanner sc=new Scanner(new BufferedInputStream(System.in));
		int K=sc.nextInt();
		int len=0;
		while(true){
			int cur=sc.nextInt();
			if(cur>=0){
				nums[len++]=cur;
			}else{
				break;
			}
		}
		sc.close();
		if(K>len){
			System.out.println("NULL");
		}else{
			System.out.println(nums[len-K]);
		}
	}

}
/*
#include <stdio.h>
int nums[1000000];
int main() {
		int K;
		scanf("%d" ,&K);
		int len=0;
		int cur;
		while(1){
			scanf("%d",&cur);
			if(cur>=0){
				nums[len++]=cur;
			}else{
				break;
			}
		}
		if(K>len){
			printf("NULL");
		}else{
			printf("%d",nums[len-K]);
		}
		return 0;
}
*/
