package a_BasicAlgorism;

import java.util.Scanner;

/**
 * AcWing 785.快速排序
 */
public class AC785_QuickSort {

    private static int[] q;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        q = new int[n];

        for (int i = 0; i < n; i++) q[i] = sc.nextInt();

        quickSort(q,0,n-1);

        for (int i : q) System.out.print(i + " ");

        //for (int i = 0; i < n; i++) System.out.println(q[i]);

    }

    private static void quickSort(int[] q,int l, int r){
        if(l >= r) return;

        int x = q[l + r >> 1];
        //int x = q[l + r + 1 >> 1];
        int i = l - 1, j = r + 1;

        while(i < j){
            while(q[++i] < x);
            while(q[--j] > x);
            if(i < j){
                int t = q[i];
                q[i] = q[j];
                q[j] = t;
            }
        }

        quickSort(q,l,j);
        quickSort(q,j+1,r); //不可以用x = q[l + r + 1 >> 1] or q[r]

        //  quickSort(q,l,i-1);
        //  quickSort(q,i,r); //不可以用x = q[l + r >> 1] or x = q[l]否则会死循环，例如：{1,2}
    }
}
