package b_DataStructure;

import java.util.Scanner;

/**
 * AcWing 143. 最大异或对
 */
public class AC143_Trie2 {

    private final static int N = 100010;
    private final static int M = 31*N;
    private static int[] a = new int[N];
    private static int[][] son = new int[M][2];
    private static int idx = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) a[i] = sc.nextInt();

        int res = 0;

        for(int i = 0; i < n; i++){
            insert(a[i]);
            int t = query(a[i]);
            res = Math.max(res,t);
        }

        System.out.println(res);
    }

    //将数的二进制表示插入到son数组中
    private static void insert(int x) {
        int p = 0;
        for(int i = 30; i >= 0; i--){
            //取出x第i位
            int u = x >> i & 1;
            if(son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
    }

    //返回最大异或
    private static int query(int x) {
        int p = 0, res = 0;
        for(int i = 30; i >= 0; i--){
            int u = x >> i & 1;

            if(son[p][u^1] != 0){
                p = son[p][u^1];
                //移位运算符优先级小，要加括号
                res = (res<<1) + 1;
            }else{
                p = son[p][u];
                res = (res<<1) + 0;
            }
        }
        return res;
    }
}
