package b_DataStructure;

import java.io.*;

/**
 * AcWing 839. 模拟堆
 */
public class AC839_heap2 {

    //用数组表示完全二叉树
    private static int[] h;
    //节点下标
    private static int size = 0;
    //节点插入的次序
    private static int m = 0;
    //存放第k个插入点的下标 ph[m] = size
    private static int[] ph;
    //存放堆中点的插入次序 hp[size] = m
    private static int[] hp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        h = new int[n];
        ph = new int[n];
        hp = new int[n];

        while(n-- != 0){
            String[] s = br.readLine().split(" ");
            if(s[0].equals("I")){
                int x = Integer.parseInt(s[1]);
                h[++size] = x;
                ph[++m] = size;
                hp[size] = m;
                up(size);
            }else if(s[0].equals("PM")) {
                System.out.println(h[1]);
            }else if(s[0].equals("DM")){
                heapSwap(1,size);
                size--;
                down(1);
            }else if(s[0].equals("D")){
                int k = Integer.parseInt(s[1]);
                //这里一定要用u=ph[k]保存第k个插入点的下标,因为在此处heapSwap操作后ph[k]的值已经发生变化
                int u = ph[k];
                heapSwap(u,size);
                size--;
                down(u);
                up(u);
            }else{
                int k = Integer.parseInt(s[1]);
                int x = Integer.parseInt(s[2]);
                h[ph[k]] = x;
                down(ph[k]);
                up(ph[k]);
            }
        }
        br.close();
    }

    //三步交换的顺序可以互换
    private static void heapSwap(int u, int v){

        swap(ph,hp[u],hp[v]);

        swap(hp,u,v);

        swap(h,u,v);
    }

    private static void swap(int[] a, int u, int v) {
        int tmp = a[u];
        a[u] = a[v];
        a[v] = tmp;
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
            heapSwap(u,t);
            //递归
            down(t);
        }
    }

    private static void up(int u){
        //父节点存在且父节点比自己大
        if(u/2 > 0 && h[u]<h[u/2]){
            //交换
            heapSwap(u,u/2);

            up(u/2);
        }
    }
}
