package a_BasicAlgorism.sort;

import java.util.Scanner;

/**
 * AcWing 787. 归并排序
 */
public class merge_sort {
    
    private static int[] q;
    private static int[] tmp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        q = new int[n];
        tmp = new int[n];
        for (int i = 0; i < n; i++)  q[i] = sc.nextInt();

        mergeSort(0,n-1);

        for (int i : q) System.out.print(i + " ");

    }

    private static void mergeSort(int l, int r) {
        if(l >= r) return;

        int mid = l + r >> 1;

        //递归排序左边和右边
        mergeSort(l, mid);
        mergeSort(mid + 1, r);

        int k = 0, i = l, j = mid + 1;

        //将两个排好序的数组合二为一
        while(i <= mid && j <= r){
            if(q[i] <= q[j])
                tmp[k++] = q[i++];
            else
                tmp[k++] = q[j++];
        }
        while(i <= mid) tmp[k++] = q[i++];
        while(j <= r) tmp[k++] = q[j++];

        for(i = l,j = 0;i <= r;i++,j++) q[i] = tmp[j];
    }
}
