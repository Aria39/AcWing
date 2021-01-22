package c_Search_GraphTheory;

import java.util.*;

/**
 * AcWing 844 走迷宫
 */
public class AC844_BFS1 {
    static int n, m;
    //d存储从起点到各点的距离
    static int[][] map, d;
    //向量表示移动方向：右，左，下，上
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

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
        Queue<Pair> q = new LinkedList<>();
        //从（0,0）开始走
        q.offer(new Pair(0, 0));

        while (!q.isEmpty()) {
            //从队头取出
            Pair pair = q.poll();
            //枚举四个方向
            for (int[] dir : dirs) {
                //该方向下一个点的位置
                int x = pair.x + dir[0];
                int y = pair.y + dir[1];

                //该点在边界内 && 可以走 && 没走过(第一次搜到该点)
                if (x >= 0 && y >= 0 && x < n && y < m && map[x][y] == 0 && d[x][y] == 0) {
                    d[x][y] = d[pair.x][pair.y] + 1;
                    //添加到队尾
                    q.offer(new Pair(x, y));
                }
            }
        }

        return d[n - 1][m - 1];
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
