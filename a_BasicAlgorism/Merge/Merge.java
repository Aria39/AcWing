package a_BasicAlgorism.Merge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * AcWing 803. 区间合并
 */
public class Merge {

    private static List<Seg> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- != 0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            list.add(new Seg(l,r));
        }

        //以左区间的升序进行排序
        list.sort(new Comparator<Seg>() {
            @Override
            public int compare(Seg o1, Seg o2) {
                return o1.first - o2.first;
            }
        });

        int res = 0;
        int r = Integer.MIN_VALUE;
        for (Seg seg : list) {
            //新的区间
            if(r < seg.first) res++;
            r = Math.max(r,seg.second);
        }

        System.out.println(res);
    }

    static class Seg{
        int first;
        int second;

        public Seg(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
