#include <stdio.h>

int main(){
	freopen("test.txt","r",stdin);
	int list1[100000];
	int list2[100000];
	int list3[200000];
	int x=-1;
	long N;
	scanf("%d",&N);
	long i=0,j=0;
	long index3=0;
	for(i=0;i<N;i++){	
		scanf("%d",&list1[i]);
	}
	for(i=0;i<N;i++){
		scanf("%d",&list2[i]);
	}
	for (i=0,j=0; i <N && j < N;) {
		int num1 = list1[i];
		int num2 = list2[j];
		if (num1 > num2) {
			list3[index3++]=num2;
			j++;
		}else if (num1 < num2) {
			list3[index3++]=num1;
			i++;
		} else {
			list3[index3++]=num1;
			list3[index3++]=num2;
			i++;
			j++;	
		}
		if(index3>=N){
			printf("%d\n",list3[N-1]);
			return 0;
		}
	}
}
