package b_DataStructure;

import java.io.*;

/**
 * AcWing 840. 模拟散列表
 * 拉链法
 */
public class AC840_HashTable1 {

    private final static int N = 100010;
    private static int[] h = new int[N];
    private static int[] e;
    private static int[] ne;
    private static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) h[i] = -1;

        e = new int[n];
        ne = new int[n];

        while(n-- != 0){
            String[] s = br.readLine().split(" ");
            if(s[0].equals("I")) insert(Integer.parseInt(s[1]));
            else{
                int x = Integer.parseInt(s[1]);
                if(query(x) == true) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }

    private static void insert(int x) {
        int k = (x % N + N) % N;
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx++;
    }

    private static boolean query(int x) {
        int k = (x % N + N) % N;
        for(int i = h[k]; i != -1; i = ne[i])
            if(e[i] == x) return true;
        return false;
    }
}
