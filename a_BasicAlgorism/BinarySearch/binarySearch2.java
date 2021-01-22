package a_BasicAlgorism.BinarySearch;

import java.util.Scanner;

/**
 * AcWing 790.数的三次方根
 * 浮点数二分
 */
public class binarySearch2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double l = -10000,r = 10000;
        while(r - l > 1e-8){
            double m = (l + r) / 2;
            if(m * m * m >= x) r = m;
            else l = m;
        }

        //小数点后六位
        System.out.println(String.format("%.6f", l));
    }
}
