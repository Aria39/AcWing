package a_BasicAlgorism.sort;

import java.util.Scanner;

/**
 * AcWing 785.快速排序
 */
public class quick_sort{

    static final int N = 1000000;
    static int n;
//    static int[] q = new int[N];

    public static void main(String[] args){

        int[] q = new int[N];

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            q[i] = num;
        }

        new quick_sort().quickSort(q,0,n-1);

        for (int i = 0; i < n; i++) {
            System.out.println(q[i]);
        }
    }

    private void quickSort(int[] q,int l, int r){
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
