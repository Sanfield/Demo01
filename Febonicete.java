package com.immite.demo;

public class Febonicete {
	public static void main(String[] args) {
		int a[]  =new int[101];
		for(int i=1;i<101;i++){
			a[i]=a[i-1]+i;
		}
		int ans=0;
		for(int i=1;i<101;i++){
			ans+=a[i];
		}
		System.out.println(ans);
		
	}

}
