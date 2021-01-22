package d_DP;

import java.util.Scanner;

/**
 * AcWing03 完全背包问题
 */
public class AC2_03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //物品数量
        int n = sc.nextInt();
        //背包容量
        int m = sc.nextInt();
        // 一个长度为N的数组，第i个元素表示第i个物品的体积；
        int[] volume = new int[n + 1] ;
        // 一个长度为N的数组，第i个元素表示第i个物品的价值；
        int[] value = new int[n + 1] ;

        for (int i = 1; i <= n ; i++){
            // 接下来有 N 行，每行有两个整数:v[i],w[i]，用空格隔开，分别表示第i件物品的体积和价值
            volume[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        int[] dp = new int[m + 1];
        for(int i = 1; i <= n; i++){
            //完全背包从小到大循环
            for(int j = volume[i]; j <= m; j++){
                dp[j] = Math.max(dp[j], dp[j - volume[i]] + value[i]);
            }
        }

        System.out.println(dp[m]);
    }

}
