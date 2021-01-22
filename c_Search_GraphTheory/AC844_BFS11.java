package c_Search_GraphTheory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * AcWing 844 走迷宫
 */
public class AC844_BFS11 {
    static int n, m;
    //d存储从起点到各点的距离
    static int[][] map, d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        d = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            for (int[] dir : dirs) {
                int x = p.x + dir[0];
                int y = p.y + dir[1];

                if(x >= 0 && y >= 0 && x < n && y < m && map[x][y] == 0 && d[x][y] == 0){
                    q.offer(new Pair(x,y));
                    d[x][y] = d[p.x][p.y] + 1;
                }
            }
        }

        return d[n-1][m-1];
    }

    static class Pair{
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
