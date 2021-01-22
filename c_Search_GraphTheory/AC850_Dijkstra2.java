package c_Search_GraphTheory;

import java.util.*;

/**
 * AcWing 849. Dijkstra求最短路 II
 * 堆优化Dijkstra
 * 稠密图：邻接矩阵 稀疏图：邻接表
 * 此题 1 ≤ n, m ≤ 1.5×105 是稀疏图
 */

public class AC850_Dijkstra2 {

    private static int n;
    //邻接表
    private static Map<Integer, List<Node>> adj;
    //存储给个节点到1号节点的距离
    private static int[] dist;
    //存储已经确定最小距离的点
    private static Set<Integer> st = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        adj = new HashMap<>();
        dist = new int[n+1];

        while (m-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            if(!adj.containsKey(a)) adj.put(a, new ArrayList<>());
            adj.get(a).add(new Node(b, c));
        }

        dijkstra();

        if (dist[n] == 0x3f3f3f3f) System.out.println(-1);
        else System.out.println(dist[n]);
    }

    private static void dijkstra() {
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;

        //小顶堆,保证小的先出队
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b)-> a[1] - b[1]);
        //节点1入队，距离是0
        heap.offer(new int[] {1, 0});

        while (!heap.isEmpty()) {
            //出队的点距离是最小的
            int[] t = heap.poll();
            int ver = t[0], distance = t[1];

            if (st.contains(ver)) continue;
            st.add(ver);

            // 更新和最小节点相连的点
            List<Node> list = adj.get(ver);
            if(list == null) continue;
            for(Node node : list){
                int idx = node.idx;
                if(dist[idx] > distance + node.d){
                    dist[idx] = distance + node.d;
                    heap.offer(new int[] {idx, dist[idx]});
                }
            }
        }
    }

    static class Node{
        public int idx;
        public int d;

        public Node(int idx, int d) {
            this.idx = idx;
            this.d = d;
        }
    }
}



