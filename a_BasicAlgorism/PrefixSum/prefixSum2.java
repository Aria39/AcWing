package a_BasicAlgorism.PrefixSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * AcWing 796. 子矩阵的和
 */
public class prefixSum2 {
    final static int N = 1010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        int[][] a = new int[N][N];
        int[][] s = new int[N][N];
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                a[i][j] = sc.nextInt();

        System.out.println("Complete!");

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + a[i][j];

        while(q-- != 0){
            int x1,y1,x2,y2;
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            result.add(s[x2][y2] - s[x1-1][y2] - s[x2][y1-1] + s[x1-1][y1-1]);
        }
        for (Integer res : result) {
            System.out.println(res);
        }

    }
}
