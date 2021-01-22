package d_DP;

import java.util.Scanner;

/**
 * AcWing02 01背包问题
 */
public class AC2_01{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 一个长度为N的数组，第i个元素表示第i个物品的体积；
        int[] v = new int[n + 1] ;
        // 一个长度为N的数组，第i个元素表示第i个物品的价值；
        int[] w = new int[n + 1] ;

        for (int i = 1; i <= n ; i++){
            // 接下来有 N 行，每行有两个整数:v[i],w[i]，用空格隔开，分别表示第i件物品的体积和价值
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        int[] dp = new int[m + 1];
        for(int i = 1; i <= n; i++){
            //01背包从大到小循环
            for(int j = m; j >= v[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }

        System.out.println(dp[m]);
    }
}
