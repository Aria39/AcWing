package a_BasicAlgorism.BitCalculation;

import java.util.Scanner;

/**
 * AcWing 801. 二进制中1的个数
 */
public class bitCal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- != 0){
            int x = sc.nextInt();
            int res = 0;
            while(x != 0){
                x -= lowbit(x);
                res++;
            }
            System.out.print(res + " ");
        }
    }

    //一个整数的负数是补码，与补码按位与可以求得最低位的1
    private static int lowbit(int x){
        return x & -x;
    }
}
