package c_Search_GraphTheory;

import java.util.*;

/**
 * AcWing 842. 排列数字
 */
public class AC842_DFS1 {

    private static int n;
    private static List<Integer> list = new ArrayList<>();
    private static List<List<Integer>> res = new ArrayList<>();
    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dfs(0);

        for (List<Integer> list : res) {
            for(int i = 0; i < n; i++) System.out.print(list.get(i) + " ");
            System.out.println();
        }
    }

    private static void dfs(int u) {
        if(u == n){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 1; i <= n; i++){
            if(set.contains(i)) continue;
            list.add(u, i);
            set.add(i);
            dfs(u+1);
            set.remove(i);
        }
    }
}
