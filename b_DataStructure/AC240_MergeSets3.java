package b_DataStructure;

import java.util.Scanner;

/**
 * AcWing 240. 食物链(太复杂，看下就行)
 */
public class AC240_MergeSets3 {

    private final static int N = 50010;
    // p[x]表示x的父节点,根节点的父节点是自己
    private static int[] p = new int[N];
    //每个节点与根节点的距离
    private static int[] d = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 1; i <= n; i++) p[i] = i;

        //假话
        int res = 0;
        while(m-- != 0){
            int t = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(x > n || y > n){
                res++;
                continue;
            }else{
                int px = find(x);
                int py = find(y);
                if(t == 1){
                    //不是同类
                    if(px == py && (d[x]-d[y]) % 3 != 0) res++;
                    //不在一个集合里
                    else if(px != py){
                        p[px] = py;
                        //d[px]是px到py的距离，因为x和y是同类，所以(d[x]+d[px]) % 3 = d[y] % 3
                        d[px] = d[y] - d[x];
                    }
                }else{
                    //x不吃y
                    if (px == py && (d[x]-d[y]-1) % 3 != 0) res ++;
                    else if(px != py){
                        p[px] = py;
                        //x吃y:(d[x]+d[px]-1) % 3 = d[y] % 3
                        d[px] = d[y] - d[x] + 1;
                    }
                }
            }
        }

        System.out.println(res);
    }

    //返回x的根节点 + 路径压缩（使每个节点到父节点的距离变成到根节点的距离)
    private static int find(int x){
        //x不是根
        if(p[x] != x){
            int t = find(p[x]);
            d[x] += d[p[x]];
            p[x] = t;
        }
        return p[x];
    }
}
