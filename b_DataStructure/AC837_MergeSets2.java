package b_DataStructure;

import java.io.*;

/**
 * 837. 连通块中点的数量
 */
public class AC837_MergeSets2{

    final static int N = 100010;
    //以树的形式来表示集合，树根的编号就是整个集合的编号。
    // p[x]表示x的父节点,根节点的父节点是自己
    private static int[] p = new int[N];
    //size存储每个集合里节点的个数，只有根节点的size是有意义的
    private static int[] size = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for(int i = 1; i <= n; i++){
            p[i] = i;
            size[i] = 1;
        }

        while(m-- != 0){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[1]);

            if(str[0].equals("C")){
                int b = Integer.parseInt(str[2]);
                if(find(a) == find(b)) continue;
                //b的根节点插到a的根节点下面
                size[find(b)] += size[find(a)];
                p[find(a)] = find(b);
            }else if(str[0].equals("Q1")){
                int b = Integer.parseInt(str[2]);
                if(find(a) == find(b)) System.out.println("Yes");
                else System.out.println("No");
            }else System.out.println(size[find(a)]);
        }
    }

    //返回x的根节点 + 路径压缩（路径上所有节点的父节点都变成根节点）
    private static int find(int x) {
        if(x != p[x]) p[x] = find(p[x]);
        return p[x];
    }
}
