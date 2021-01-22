package c_Search_GraphTheory;

import java.util.*;

/**
 * AcWing 853. 有边数限制的最短路
 */
public class AC853_BellmanFord {

    private static int n, m, k;
    private static Edge[] edges;
    private static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        edges = new Edge[m];
        dist = new int[n+1];

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            edges[i] = new Edge(a, b, w);
        }

        int t = bellmanford();

        if(t == -1) System.out.println("impossible");
        else System.out.println(t);
    }

    private static int bellmanford() {
        int[] backup;
        

        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;

        while(k-- > 0){
            backup = dist.clone();
            for(int i = 0; i < m; i++){
                int a = edges[i].a;
                int b = edges[i].b;
                int w = edges[i].w;
                dist[b] = Math.min(dist[b], backup[a] + w);
            }
        }

        if(dist[n] > 0x3f3f3f3f/2) return -1;
        return dist[n];
    }

    static class Edge{
        int a,b,w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
}

