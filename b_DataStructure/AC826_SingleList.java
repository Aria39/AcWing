package b_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * AcWing 826. 单链表
 */
public class AC826_SingleList {

    private static int N = 100010;

    // 表示头结点的下标
    private static int head;
    // 表示结点i的值
    private static int[] e = new int[N];
    // 表示结点i的next指针是多少
    private static int[] ne = new int[N];
    private static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        head = -1;
        idx = 0;

        while(m-- > 0){
            String[] s = br.readLine().split(" ");
            if(s[0].equals("H")){
                int val = Integer.parseInt(s[1]);
                addToHead(val);
            }else if(s[0].equals("I")){
                int k = Integer.parseInt(s[1]);
                int val = Integer.parseInt(s[2]);
                add(k-1,val);
            }else if(s[0].equals("D")){
                int k = Integer.parseInt(s[1]);
                if(k == 0) head = ne[head];
                else remove(k-1);
            }
        }

        for(int i = head; i != -1; i = ne[i]) System.out.print(e[i] + " ");
    }

    private static void addToHead(int val) {
        e[idx] = val;
        ne[idx] = head;
        head = idx;
        idx++;
    }

    private static void add(int k, int val) {
        e[idx] = val;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx++;
    }

    private static void remove(int k) {
        ne[k] = ne[ne[k]];
    }
}
