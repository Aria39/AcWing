package a_BasicAlgorism.Difference;

import java.util.Scanner;

/**
 * AcWing 797. 差分
 * 差分不用在意如何构造
 */
public class AC797 {
    final static int N = 100010;
    static int[] a = new int[N];
    static int[] b = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) a[i] = sc.nextInt();

        //构造差分
        for (int i = 1; i <= n; i++) insert(i,i,a[i]);

        while(m-- != 0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();
            insert(l,r,c);
        }

        //构造前缀和
        for(int i = 1; i <= n; i++) b[i] += b[i-1];

        for (int i = 1; i <= n; i++) System.out.print(b[i] + " ");
    }

    private static void insert(int l, int r, int c){
        b[l] += c;
        b[r + 1] -= c;
    }
}
