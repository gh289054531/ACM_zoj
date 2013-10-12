//java超时，用C通过
package PAT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PAT1011 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
		int T = Integer.parseInt(reader.readLine());
		for (int i = 0; i < T; i++) {
			String[] line = reader.readLine().split(" ");
			long A = Long.parseLong(line[0]);
			long B = Long.parseLong(line[1]);
			long C = Long.parseLong(line[2]);
			if ((A + B) > C) {
				System.out.println("Case #" + (i + 1) + ": true");
			} else {
				System.out.println("Case #" + (i + 1) + ": false");
			}
		}
		reader.close();
	}
}

/*
#include <stdio.h>
int main(){
	freopen("test.txt", "r", stdin); 
	int T ;
	scanf("%d",&T);
	int i=0;
	for (; i < T; i++) {
		long long A,B,C;
		scanf("%lld %lld %lld",&A,&B,&C);
		if ((A + B) > C) {
			printf("Case #");
			printf("%d",i+1);
			printf(": true\n");
		} else {
			printf("Case #");
			printf("%d",i+1);
			printf(": false\n");
		}
	}
	return 0;
}
*/