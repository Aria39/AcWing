package c_Search_GraphTheory;

import java.util.*;

/**
 * 843. n-皇后问题
 */
public class AC843_DFS2 {

    private static int n;
    private static char[][] g;
    //boolean数组，存储哪些数被用过了
    private static boolean[] col, dg, udg;
    //private static boolean[] row;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        g = new char[n][n];
        col = new boolean[n];
        //row = new boolean[n];
        dg = new boolean[2*n];
        udg = new boolean[2*n];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                g[i][j] = '.';

        //dfs(0,0,0);
        dfs(0);
    }

//    private static void dfs(int x, int y, int s) {
//        if(y == n){
//            y = 0;
//            x++;
//        }
//        if (x == n) {
//            if (s == n) {
//                //皇后放满，形成一个方案
//                for (int i = 0; i < n; i++) {
//                    for (int j = 0; j < n; j++) System.out.print(g[i][j]);
//                    System.out.println();
//                }
//                System.out.println();
//            }
//            return;
//        }
//
//        //不放皇后
//        dfs(x, y + 1, s);
//
//        //放皇后
//             if (!row[x] && !col[y] && !dg[x+y] && !udg[x-y+n]) {
//            g[x][y] = 'Q';
//            row[x] = col[y] = dg[x+y] = udg[x-y+n] = true;
//            dfs(x, y+1, s+1);
//            row[x] = col[y] = dg[x+y] = udg[x-y+n] = false;
//            g[x][y] = '.';
//        }
//    }


    private static void dfs(int row) {
        if(row == n){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++) System.out.print(g[i][j]);
                System.out.println();
            }

            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++)
            if(!col[i] && !dg[row+i] && !udg[row-i+n]){
                g[row][i] = 'Q';
                col[i] = dg[row+i] = udg[row-i+n] = true;
                dfs(row+1);
                //回溯
                col[i] = dg[row+i] = udg[row-i+n] = false;
                g[row][i] = '.';
            }
    }
}
