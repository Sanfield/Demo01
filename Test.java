package com.math.demo;
import java.util.*;
import java.math.*;
import java.util.regex.*;


public class Test {

    final static int MOD = 1000000007;
    final static int INF = 0x3f3f3f3f;
    final static int NUM = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k,l;
        int ans;
        while(sc.hasNext()) {
            k=sc.nextInt();l=sc.nextInt();
            ans=0;
            int[][] nums = new int[l][k];
            for(int i=0;i<l;i++)for(int j=0;j<k;j++)nums[i][j]=0;
            for(int j=0;j<k;j++)
                nums[0][j]=1;
            for(int i=1;i<l;i++)
                for(int j=0;j<k;j++)
                    for(int x=0;x<k;x++) {
                        if(x!=j-1 && x!=j+1) {
                            nums[i][j]+=nums[i-1][x];
                            nums[i][j]%=MOD;
                        }
                    }
            for(int j=1;j<k;j++) {
                ans+=nums[l-1][j];
                ans%=MOD;
            }
            System.out.println(ans);
        }

    }
}
