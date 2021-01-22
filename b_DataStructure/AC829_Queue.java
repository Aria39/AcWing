package b_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * AcWing 829. 模拟队列
 */
public class AC829_Queue {

    private final static int N = 100010;
    private static int[] que = new int[N];
    //头
    private static int h = 0;
    //尾
    private static int t = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        while(m-- > 0){
            String[] str = br.readLine().split(" ");
            if(str[0].equals("push"))  push(Integer.parseInt(str[1]));
            else if(str[0].equals("pop")) pop();
            else if(str[0].equals("empty")) empty();
            else if(str[0].equals("query"))  query();
        }
        br.close();
    }

    private static void query() {
        System.out.println(que[h]);
    }

    private static void empty() {
        if(h == t) System.out.println("YES");
        else System.out.println("NO");
    }

    private static void pop() {
        h++;
    }

    private static void push(int x) {
        que[t++] = x;
    }
}
