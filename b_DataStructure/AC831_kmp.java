package b_DataStructure;

import java.io.*;

/**
 * AcWing 831. KMP字符串
 */
public class AC831_kmp {

    private final static int N = 100010;
    //模板串
    private static char[] p = new char[N];
    //模式串
    private static char[] s = new char[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String p_str = br.readLine();
        for(int i = 1; i <= n; i++) p[i] = p_str.charAt(i-1);
        //int m = Integer.parseInt(br.readLine());
        int m = br.read();
        String s_str = br.readLine();
        for(int i = 1; i <= m; i++) s[i] = s_str.charAt(i-1);

        //模板串next
        int[] next = new int[n+1];

        //求next过程
        for(int i = 2, j = 0; i <= n; i++){
            while(j != 0 && p[i] != p[j+1]) j = next[j];
            if(p[i] == p[j+1]) j++;
            next[i] = j;
        }

        //kmp匹配过程
        for(int i = 1,j = 0; i <= m; i++){
            //模板串右移
            while(j != 0 && s[i] != p[j+1]) j = next[j];
            if(s[i] == p[j+1]) j++;
            //匹配成功
            if(j == n){
                bw.write(i-n + " ");
                j = next[j];
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
