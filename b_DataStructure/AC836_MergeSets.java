package b_DataStructure;

import java.io.*;

/**
 * AcWing 836. 合并集合
 */
public class AC836_MergeSets {
    //以树的形式来表示集合，树根的编号就是整个集合的编号。
    // p[x]表示x的父节点,根节点的父节点是自己
    private static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        p = new int[n+1];

        for(int i = 1; i <= n; i++) p[i] = i;

        while(m-- != 0){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[1]);
            int b = Integer.parseInt(str[2]);
            //找到a的祖宗节点，并给祖宗找了个爹
            if(str[0].equals("M")) p[find(a)] = find(b);
            else{
                if(find(a) == find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    //返回x的根节点 + 路径压缩（路径上所有节点的父节点都变成根节点）
    private static int find(int x) {
        if(x != p[x]) p[x] = find(p[x]);
        return p[x];
    }
}
