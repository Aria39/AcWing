package a_BasicAlgorism.Merge;

import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

/**
 * AcWing 803. 区间合并
 */
public class Merge2{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++){
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        int r = 0x80000000;
        int res = 0;
        for (int i = 0; i < n; i++){
            if (r < arr[i][0]) res++;
            r = Math.max(r, arr[i][1]);
        }
        System.out.println(res);
    }
}

