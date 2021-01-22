package a_BasicAlgorism.sort;

import java.util.Scanner;

/**
 * AcWing 788. 逆序对的数量
 */
public class merge_sort2 {

    final static int N = 100010;
    static int[] q = new int[N];
    static int[] tmp = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextInt();
        }
        System.out.println(mergeSort(0,n-1));
    }

    private static long mergeSort(int l, int r) {
        if(l >= r) return 0;
        int m = l + r >> 1;

        long res = mergeSort(l,m) + mergeSort(m+1,r);

        int k = 0,i = l,j = m + 1;
        while(i <= m && j <= r){
            if(q[i] <= q[j]) tmp[k++] = q[i++];
            else{
                tmp[k++] = q[j++];
                res += m - i + 1;
            }
        }
        while(i <= m) tmp[k++] = q[i++];
        while(j <= r) tmp[k++] = q[j++];

        for(i = l,j = 0; i <= r; i++,j++)
            q[i] = tmp[j];

        return res;
    }
}
