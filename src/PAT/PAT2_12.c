#include <stdio.h>

int list1[2000000];//在全局变量区域分配内存 
int list2[2000000];
int main(){
	freopen("test.txt","r",stdin);
	int x=-1;
	long index1=0;
	long index2=0;
	while (scanf("%d",&x)) {
		if(x!=-1){
			list1[index1++]=x;
		}else{
			break;
		}
	}
	while (scanf("%d",&x)) {
		if(x!=-1){
			list2[index2++]=x;
		}else{
			break;
		}
	}
	if (index1 == 0 && index2 == 0) {
		printf("NULL\n");
	} else if (index1 == 0) {
		printf("NULL\n");
	} else if (index2 == 0) {
		printf("NULL\n");
	} else {
		int flag=0;
		long i = 0, j = 0;
		for (; i <index1&& j < index2;) {
			int num1 = list1[i];
			int num2 = list2[j];
			if (num1 > num2) {
				j++;
			} else if (num1 < num2) {
				i++;
			} else {
				flag=1;
				printf("%d",num1);
				i++;
				j++;			
				if (index1 != i && index2 != j) {
					printf(" ");
				}else{
					printf("\n");
				}
			}
		}
		if(flag==0){
			printf("NULL\n");
		}
	}

	return 0;
}

