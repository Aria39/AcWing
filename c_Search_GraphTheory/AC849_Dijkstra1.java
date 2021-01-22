package c_Search_GraphTheory;

import java.util.*;

/**
 * AcWing 849. Dijkstra求最短路 I
 * 朴素Dijkstra
 * 稠密图：邻接矩阵 稀疏图：邻接表
 * 此题 1 ≤ n ≤ 500, 1 ≤ m ≤105, 是稠密图
 * 最大值这里用0x3f3f3f3f，如果用Integer.MAX_VALUE_VALUE，数组要用long类型，用int会溢出
 */
public class AC849_Dijkstra1 {
    private static int n;
    //邻接矩阵，graph[2][3] = 4 : 表示节点2到节点3的距离为4
    private static int[][] graph;
    //存储给个节点到1号节点的距离
    private static int[] dis;
    //存储已经确定最小距离的点
    private static Set<Integer> checked = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        graph = new int[n+1][n+1];
        dis = new int[n+1];
        for (int[] row : graph) Arrays.fill(row, 0x3f3f3f3f);

        while(m-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = Math.min(graph[a][b], c);
        }

        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        Arrays.fill(dis, 0x3f3f3f3f);
        dis[1] = 0;

        for(int i = 0; i < n; i++){
            //1.找到所有没确定最小距离的点中，最小的那一个
            int t = -1;
            for(int j = 1; j <= n; j++)
                if(!checked.contains(j) && (t == -1 || dis[j] < dis[t])) t = j;

            //1.5 已经找到n
            if(t == n) break;

            //2.确定了t的最小距离，加入set
            checked.add(t);

            //3.用t更新1到其他点的最小距离
            for(int j = 1; j <= n; j++) dis[j] = Math.min(dis[j], dis[t] + graph[t][j]);
        }

        if(dis[n] >= 0x3f3f3f3f) return -1;
        else return dis[n];
    }
}
