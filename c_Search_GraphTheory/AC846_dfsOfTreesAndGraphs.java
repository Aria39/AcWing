package c_Search_GraphTheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * AcWing 846. 树的重心
 */
public class AC846_dfsOfTreesAndGraphs {

    private static int n;
    private static int ans;
    private static Map<Integer,ArrayList<Integer>> tree = new HashMap<>();
    private static boolean[] st;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = n;
        st = new boolean[n+1];
        for(int i = 0; i < n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            //a -> b
            if(!tree.containsKey(a)) tree.put(a,new ArrayList<>());
            tree.get(a).add(b);
            //b -> a
            if(!tree.containsKey(b)) tree.put(b,new ArrayList<>());
            tree.get(b).add(a);
        }

        dfs(1);

        System.out.println(ans);
    }

    private static int dfs(int u) {
        //该点被搜过，标记
        st[u] = true;
        //以u为根的树的大小
        int sum = 1;
        //除去u后，每一个连通块中最大的那个
        int res = 0;

        ArrayList<Integer> list = tree.get(u);
        if(list != null)
            for (Integer i : list) {
                if(!st[i]){
                    int s = dfs(i);
                    sum += s;
                    //u下面最大的联通块
                    res = Math.max(res, s);
                }
            }
        //n-sum:u上面的连通块大小
        res = Math.max(res, n-sum);
        ans = Math.min(ans, res);

        return sum;
    }
}