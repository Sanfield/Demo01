package Scanner;

import java.util.Scanner;

public class MaxMin {
	public static void main(String[] args) {
		int a,max=0,min=0,sum=0;
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i=1;i<=n;i++){
			a= input.nextInt();
			sum +=a;
			if(i==1){
				max=min=a;
			}
			if(a>max){
				max=a;
			}
			if(a<min){
				min=a;
			}
		}
		System.out.println(max);
		System.out.println(min);
		System.out.println(sum);
	}

}
