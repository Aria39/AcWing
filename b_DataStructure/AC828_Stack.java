package b_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * AcWing 828. 模拟栈
 */
public class AC828_Stack {

    private final static int N = 100010;
    private static int[] stk = new int[N];
    private static int k = 0;

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
    }

    private static void query() {
        System.out.println(stk[k]);
    }

    private static void empty() {
        if(k == 0) System.out.println("YES");
        else System.out.println("NO");
    }

    private static void pop() {
        k--;
    }

    private static void push(int x) {
        stk[++k] = x;
    }
}
