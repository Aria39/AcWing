package c_Search_GraphTheory;

import java.util.*;

/**
 * AcWing 847. 图中点的层次
 */
public class AC847_bfsOfTreesAndGraphs {

    private static int n;
    private static Map<Integer,ArrayList<Integer>> tree = new HashMap<>();
    //存储根节点到各节点的长度 d[1]=0
    private static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        d = new int[n+1];
        for(int i = 0 ; i < n+1; i++) d[i] = -1;

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            //a -> b
            if(!tree.containsKey(a)) tree.put(a,new ArrayList<>());
            tree.get(a).add(b);
        }

        bfs();
        System.out.println(d[n]);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        //1是起点
        q.offer(1);
        d[1] = 0;

        while(!q.isEmpty()){
            //取出队头
            int t = q.poll();
            ArrayList<Integer> list = tree.get(t);
            if(list != null) {
                //遍历t节点的每一个相邻节点
                for (Integer i : list) {
                    //该节点没有被搜索过（第一次搜到的是最小值）
                    if (d[i] == -1) {
                        d[i] = d[t] + 1;
                        //进队尾
                        q.offer(i);
                    }
                }
            }
        }
    }
}