package a_BasicAlgorism.PrefixSum;

import java.util.Scanner;

/**
 * AcWing 795. 前缀和
 */
public class prefixSum {

    final static int N = 100010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[N];
        int[] sum = new int[N];

        int n = sc.nextInt();
        int m = sc.nextInt();
        //下标从1开始
        for (int i = 1; i <= n; i++) a[i] = sc.nextInt();
        //构造前缀和
        for (int i = 1; i <= n; i++) sum[i] = sum[i-1] + a[i];

        System.out.println("-----------------------");
        while(m-- != 0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(sum[r] - sum[l-1]);
        }
    }
}
