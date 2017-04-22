package Scanner;

import java.util.Scanner;

public class Pascal {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		int []a= null;
		System.out.println(1);
		for(int i = 2;i<=n;i++){
			int []s=new int[i];
			s[0]=s[i-1]=1;
			System.out.print("1 ");
			for(int j=1;j<=i-2;j++){
				s[j]=a[j-1]+a[j];
				System.out.print(s[j]+" ");
			}
			System.out.println("1");
			a = s;
		}
	}

}
