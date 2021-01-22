package a_BasicAlgorism.DoublePoint;

import java.util.Scanner;

/**
 * AcWing 799. 最长连续不重复子序列
 */
public class doublePoint1 {

    final static int N = 100010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = 0;
        int a[] = new int[N];
        int s[] = new int[N];
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) a[i] = sc.nextInt();

        for(int i = 0,j = 0; i < n; i++){
            s[a[i]]++;
            while(s[a[i]] > 1){
                s[a[j]] --;
                j++;
            }
            res = Math.max(res, i-j+1);
        }

        System.out.println(res);
    }
}
