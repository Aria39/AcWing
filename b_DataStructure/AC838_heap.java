package b_DataStructure;

import java.io.*;

/**
 * AcWing 838. 堆排序
 * 完全二叉树：除了最后一层节点，上面节点都是满的，最后一层是从左到右排列
 * 小根堆：每个点都小于等于左右儿子
 */
public class AC838_heap {

    final static int N = 100010;
    private static int[] h = new int[N];
    private static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        String[] s2 = br.readLine().split(" ");
        for(int i = 1; i <= n; i++) h[i] = Integer.parseInt(s2[i-1]);
        size = n;

        //把数组构造成堆
        for(int i = n/2; i != 0; i--) down(i);

        while(m-- != 0){
            //堆顶最小
            System.out.print(h[1] + " ");
            //去堆顶
            h[1] = h[size--];
            down(1);
        }
    }

    private static void down(int u) {
        //t表示三个点中最小点的节点编号
        int t = u;
        //和左儿子比较
        if(u*2 <= size && h[u*2] < h[t]) t = u*2;
        //和右儿子比较
        if(u*2+1 <= size && h[u*2+1] < h[t]) t = u*2+1;
        if(u != t){
            //交换
            int tmp = h[t];
            h[t] = h[u];
            h[u] = tmp;
            //递归
            down(t);
        }
    }

//    private static void up(int u){
//        //父节点存在且父节点比自己大
//        if(u/2 > 0 && h[u]<h[u/2]){
//            //交换
//            int tmp = h[u/2];
//            h[u/2] = h[u];
//            h[u] = tmp;
//
//            up(u/2);
//        }
//    }
}
