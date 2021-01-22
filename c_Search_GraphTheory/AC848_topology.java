package c_Search_GraphTheory;

import java.util.*;

/**
 * AcWing 848. 有向图的拓扑序列
 */
public class AC848_topology {
    
    private static Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
    private static int[] in;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        in = new int[n+1];

        for (int i = 0; i < m ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(!graph.containsKey(a)) graph.put(a, new ArrayList<>());
            graph.get(a).add(b);
            in[b]++;
        }
        String res = topSort();

        System.out.println(res == null ? "-1": res);
    }

    private static String topSort(){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) if(in[i] == 0) queue.offer(i);

        while (!queue.isEmpty()){
            int x = queue.poll();
            res.add(x);
            ArrayList<Integer> edges = graph.get(x);
            if (edges == null) continue;
            for (Integer p : edges) {
                in[p]--;
                if (in[p] == 0) queue.offer(p);
            }
        }

        if (res.size() != n) return null;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.size(); i++) sb.append(res.get(i)).append(' ');

        return sb.toString().substring(0, sb.toString().length() - 1);
    }
}

