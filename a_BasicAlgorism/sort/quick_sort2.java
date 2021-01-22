package a_BasicAlgorism.sort;

import java.util.Scanner;

/**
 * AcWing 786.第k个数
 */
public class quick_sort2 {

    private static int[] q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        q = new int[n];
        for (int i = 0; i < n; i++) q[i] = sc.nextInt();

        System.out.println(quickSort(0,n-1,k));
    }

    private static int quickSort(int l, int r,int k) {
        //永远保证第k个数是在l到r中的，所以当l=r时，l=r=k
        if(l >= r) return q[l];

        int m = q[l] + q[r] >> 1;
        int i = l - 1;
        int j = r + 1;

        while(i < j){
            while(q[++i] < m);
            while(q[--j] > m);
            if(i < j){
                int t = q[i];
                q[i] = q[j];
                q[j] = t;
            }
        }

        //左半边长度
        int sl = j - l + 1;
        if(k <= sl) return quickSort(l,j,k);
        else return quickSort(j+1,r,k-sl);
    }
}
