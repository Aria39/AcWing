package b_DataStructure;

import java.util.Scanner;

public class AC143_Trie22 {
    private final static int N = 100010;
    private final static int M = N*32;
    private static int[] a = new int[N];
    private static int[][] son = new int[M][2];
    private static int idx = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n ; i++) a[i] = sc.nextInt();

        int res = 0;
//        //暴力
//        for(int i = 0; i < n; i++)
//            for(int j = 0; j <= i; j++){
//                int t = a[i] ^ a[j];
//                res = Math.max(res,t);
//            }

        for(int i = 0; i < n; i++){
            insert(a[i]);
            int t = query(a[i]);
            res = Math.max(res,t);
        }

        System.out.println(res);
    }

    private static int query(int x) {
        int p = 0, res = 0;
        for(int i = 30; i >= 0; i--){
            int u = x >> i & 1;
            if(son[p][u^1] != 0){
                p = son[p][u^1];
                res = (res<<1) + 1;
            }else{
                p = son[p][u];
                res = res<<1;
            }
        }

        return res;
    }

    private static void insert(int x) {
        //根节点
        int p = 0;
        for(int i = 30; i >= 0; i--){
            //提取第i位
            int u = x >> i & 1;
            if(son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
    }
}
