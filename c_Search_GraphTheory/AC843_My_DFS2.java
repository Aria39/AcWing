package c_Search_GraphTheory;

import java.util.*;

/**
 * 843. n-皇后问题
 */
public class AC843_My_DFS2 {

    private static List<List<String>> res = new ArrayList<>();
    private static int n;
    //冲突数组
    private static boolean[] col, d, ud;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        col = new boolean[n];
        d = new boolean[2*n];
        ud = new boolean[2*n];

        StringBuilder row_buf = new StringBuilder();
        for(int i = 0; i < n; i++) row_buf.append('.');

        //一种方案
        List<String> plan = new ArrayList<>();

        dfs(0,row_buf,plan);

        for (List<String> re : res) {
            for (String s : re) System.out.println(s);
            System.out.println();
        }
    }

    //row:当前层号
    //row_buf:层的原始值
    //plan:当前的方案
    private static void dfs(int row, StringBuilder row_buf, List<String> plan) {
        if(row == n){
            //已形成一种方案
            res.add(new ArrayList<>(plan));
            return;
        }
        //从每一列开始遍历
        for(int i = 0; i < n; i++){
            if(col[i] || d[row+i] || ud[row-i+n]) continue;
            row_buf.setCharAt(i,'Q');
            //当前行添加到方案中
            plan.add(row_buf.toString());
            row_buf.setCharAt(i,'.');
            //占用当前位置
            col[i] = d[row+i] = ud[row-i+n] = true;

            //递归到下一行
            dfs(row+1,row_buf,plan);

            //回溯
            col[i] = d[row+i] = ud[row-i+n] = false;
            plan.remove(plan.size()-1);
        }
    }
}
