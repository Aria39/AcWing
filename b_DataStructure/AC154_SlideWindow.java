package b_DataStructure;

import java.io.*;

/**
 * AcWing 154. 滑动窗口
 */
public class AC154_SlideWindow {

    private final static int N = 1000010;
    private static int[] a = new int[N];
    private static int[] q = new int[N];

    //建议用数据流，system.out.print会AC不过
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        //找最小值
        int hh = 0, tt = -1;
        for(int i = 0; i < n; i++){
            //如果队头滑出窗口，则弹出队头
            if(hh <= tt && q[hh] < i-k+1) hh++;
            //窗口中最小值永远在队头
            while(hh <= tt && a[q[tt]] >= a[i]) tt--;
            //将本轮下标填入队尾
            q[++tt] = i;
            //如果满足窗口大小，将队头（最小）输出
            if(i >= k-1) bw.write(a[q[hh]] + " ");
        }
        bw.write("\n");

        //找最大值
        hh = 0;
        tt = -1;
        for(int i = 0; i < n; i++){
            if(hh <= tt && q[hh] < i-k+1) hh++;
            while(hh <= tt && a[q[tt]] <= a[i]) tt--;
            q[++tt] = i;

            if(i >= k-1) bw.write(a[q[hh]] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
