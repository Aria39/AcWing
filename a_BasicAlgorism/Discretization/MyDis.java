package a_BasicAlgorism.Discretization;

import java.util.*;

/**
 * AcWing 802. 区间和
 */

public class MyDis {

    final static int N = 300010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //n次操作
        int n = sc.nextInt();
        //m次询问
        int m = sc.nextInt();
        //在离散值的位置存储增量c，从1开始记录
        int[] a = new int[N];
        //前缀和，从1开始记录
        int[] sum = new int[N];
        //将所有的使用到的数存在alls中，比如x，l，r
        List<Integer> alls = new ArrayList<>();
        //存n次操作
        List<Pairs> add = new ArrayList<>();
        //存m次询问
        List<Pairs> query = new ArrayList<>();

        while(n-- != 0){
            int x = sc.nextInt();
            int c = sc.nextInt();
            alls.add(x);
            add.add(new Pairs(x,c));
        }

        while(m-- != 0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            alls.add(l);
            alls.add(r);
            query.add(new Pairs(l,r));
        }

        //对alls排序和去重
        Collections.sort(alls);
        int unique = unique(alls);
        //将去重后的List保存下来，subList方法前闭后开
        alls = alls.subList(0,unique);

        //构造前缀和
        for (Pairs p : add) {
            //通过二分法找到x的离散值,加1
            int index = find(p.first,alls);
            a[index] += p.second;
        }
        for(int i = 1; i <= alls.size(); i++) sum[i] = sum[i-1] + a[i];

        //查询
        for (Pairs p : query) {
            int l = find(p.first,alls);
            int r = find(p.second,alls);
            System.out.println(sum[r] - sum[l-1]);
        }
    }

    //去重
    static int unique(List<Integer> list){
        int j = 0;
        for(int i = 0; i < list.size(); i++){
            if(i==0 || list.get(i) != list.get(i-1)){
                list.set(j,list.get(i));
                j++;
            }
        }
        return j;
    }

    //二分查找
    static int find(int x, List<Integer> list){
        int l = 0,r = list.size() - 1;
        while(l < r){
            int m = l + r >> 1;
            if(list.get(m) >= x) r = m;
            else l = m + 1;
        }
        //alls是从0开始记录，但sum[]是从1开始，所以a[]也从1开始记录，返回的离散值索引要加1
        return l+1;
    }
}

class Pairs{
    int first;
    int second;

    public Pairs(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
