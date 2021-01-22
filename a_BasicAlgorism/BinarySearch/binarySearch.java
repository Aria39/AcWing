package a_BasicAlgorism.BinarySearch;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * AcWing 789. 数的范围
 * 整数二分
 */
public class binarySearch {
    static final int N = 100010;
    static int n,m;

    public static void main(String[] args) {

        Set<String> hash  = new LinkedHashSet<>();

        int[] q = new int[N];

        Scanner sc = new Scanner(System.in);
        System.out.println("input length of array and number of search:");
        n = sc.nextInt();
        m = sc.nextInt();
        System.out.println("input array:");
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextInt();
        }
        while (m-- != 0) {
            System.out.println("input the number to search:");
            int x = sc.nextInt();
            //左边界
            int l = 0;
            int r = n - 1;
            while (l < r) {
                int m = l + r >> 1;
                if (q[m] >= x) r = m;
                else l = m + 1;
            }
            int left = l;
            if (q[l] != x)
                System.out.println(-1 + ":" + -1);
            else {
                //右边界
                r = n - 1;
                while (l < r) {
                    int m = l + r + 1 >> 1;
                    if (q[m] <= x) l = m;
                    else r = m - 1;
                }
                int right = l;

                System.out.println(left + ":" + right);
            }
        }
    }
}
