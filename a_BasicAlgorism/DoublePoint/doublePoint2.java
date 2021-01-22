package a_BasicAlgorism.DoublePoint;

import java.io.*;

/**
 * AcWing 800. 数组元素的目标和
 */
public class doublePoint2 {

    private final static int N = 100010;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int x = Integer.parseInt(s[2]);

        int[] a = new int[N];
        int[] b = new int[N];
        String[] a_str = br.readLine().split(" ");
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(a_str[i]);
        String[] b_str = br.readLine().split(" ");
        for(int i = 0; i < m; i++) b[i] = Integer.parseInt(b_str[i]);


//        String a_str = br.readLine();
//        for(int i = 0; i < n; i++) a[i] = a_str.charAt(i);
//        String b_str = br.readLine();
//        for(int i = 0; i < n; i++) b[i] = b_str.charAt(i);

        for(int i = 0 , j = m-1; i < n; i++){
            while(j >= 0 && a[i] + b[j] > x) j--;
            if(a[i] + b[j] == x){
                bw.write(i + " " + j);
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
