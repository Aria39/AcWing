package b_DataStructure;

import java.io.*;

/**
 * AcWing 841. 字符串哈希
 */
public class AC841_HashTable2 {

    //经验值
    private final static int P = 131;
    private static long[] p;
    private static long[] h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        String s = br.readLine();

        p = new long[n + 10];
        h = new long[n + 10];
        p[0] = 1;

        //求字符串前缀和哈希值
        for(int i = 1; i <= n; i++){
            p[i] = p[i-1] * P;
            h[i] = h[i-1] * P + s.charAt(i-1);
        }

        while(m-- != 0){
            String[] s2 = br.readLine().split(" ");
            int l1 = Integer.parseInt(s2[0]);
            int r1 = Integer.parseInt(s2[1]);
            int l2 = Integer.parseInt(s2[2]);
            int r2 = Integer.parseInt(s2[3]);

            if(find(l1,r1) == find(l2,r2)) System.out.println("Yes");
            else System.out.println("No");
        }

        br.close();
    }

    //公式,l到r的哈希值
    private static long find(int l, int r) {
        return h[r] - h[l-1] * p[r-l+1];
    }
}
