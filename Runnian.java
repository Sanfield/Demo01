package Scanner;

import java.util.Scanner;

public class Runnian {
public static void main(String[] args) {
	int x = new Scanner(System.in).nextInt();
	if(((x%4==0) &&(x%100!=0))||(x%400==0)){
		System.out.println("yes");
	}else {
		System.out.println("no");
	}
}
}
