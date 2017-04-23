package com.math.demo;

import java.util.Scanner;

public class Tilie_Demo1 {
	  static int n;
	  static int result=0;
	public static void main(String[] args) {
		Scanner input  = new Scanner(System.in);
		n = input.nextInt();
		int len=0;
		getresult(len);
		System.out.println(result);

	}
	static void getresult(int len){
		if (len==n){
			result++;
			return;
		}
		if(len>n)
			return;
		if(len+1<=n)
			getresult(len+1);
		if(len+2<=n)
			getresult(len+2);
	}

}
