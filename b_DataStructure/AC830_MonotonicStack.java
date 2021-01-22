package b_DataStructure;

import java.util.Scanner;

/**
 * AcWing 830. 单调栈
 */
public class AC830_MonotonicStack {

    private static int N = 100010;
    private static int[] r = new int[N];
    //栈里面的数是单调增加的
    private static int[] stk = new int[N];
    private static int tt = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //暴力方法
//        for(int i = 0; i < n; i++) a[i] = sc.nextInt();
//        for(int i = 0; i < n; i++)
//            for(int j = i-1; j >= 0; j--)
//                if(a[i] <= a[j])  r[i] = -1;
//                else{
//                    r[i] = a[j];
//                    break;
//                }
//        r[0] = -1;

        //时间复杂度O(n)
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            //如果栈顶的数大于目标值，出栈
            while(tt!=0 && stk[tt]>=x) tt--;
            //找到第一个小于目标值的数，存入结果数组
            if(tt != 0) System.out.print(stk[tt] + " ");
            else System.out.print(-1 + " ");

            //目标值入栈
            stk[++tt] = x;
        }

    }
}
