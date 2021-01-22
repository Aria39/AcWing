//package a_BasicAlgorism.Discretization;
//
//import java.io.*;
//import java.lang.Integer;
//import java.util.*;
//
///**
// * AcWing 802. 区间和
// */
//
////键值对相当于c++的pair<int, int>
//class Node {
//    public int first;
//    public int second;
//
//    public Node(int first, int second) {
//        this.first = first;
//        this.second = second;
//    }
//}
//
//public class dis {
//    final static int N = 300010;
//    //离散数组，存储前缀和
//    static int[] sum = new int[N];
//    //存储坐标和长度
//    //key：离散化的值
//    static TreeMap<Integer, Integer> map = new TreeMap<>();
//    //用于查询 相当于c++的vector<pair<int,int>>
//    static ArrayList<Node> query = new ArrayList<>();
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] params = br.readLine().split(" ");
//        int n = Integer.valueOf(params[0]);
//        int m = Integer.valueOf(params[1]);
//
//        for (int i = 0; i < n; ++i) {
//            String[] xc = br.readLine().split(" ");
//            int x = Integer.valueOf(xc[0]);
//            int c = Integer.valueOf(xc[1]);
//            map.put(x, map.getOrDefault(x, 0) + c);
//        }
//
//        for (int i = 0; i < m; ++i) {
//            String[] lr = br.readLine().split(" ");
//            int l = Integer.valueOf(lr[0]);
//            int r = Integer.valueOf(lr[1]);
//            map.put(l, map.getOrDefault(l, 0));
//            map.put(r, map.getOrDefault(r, 0));
//            query.add(new Node(l, r));
//        }
//
//        br.close();
//
//        //构造前缀和
//        int k = 1;
//        for (int num : map.values()) {
//            sum[k] = sum[k - 1] + num;
//            k++;
//        }
//
//        //java.util.TreeMap.keySet(),该方法以升序返回一个具有TreeMap键的set
//        Object[] obj = map.keySet().toArray();
//        Integer[] index = Arrays.copyOfRange(obj, 0, obj.length, Integer[].class);
//
//        for (Node node : query) {
//            int l = find(index, node.first);
//            int r = find(index, node.second);
//            int res = sum[r] - sum[l-1];
//            System.out.printf("%d\n", res);
//        }
//    }
//
//    //二分查找
//    static int find(Integer[] index, int x) {
//        int l = 0, r = index.length - 1;
//        while (l < r) {
//            int mid = l + r >> 1;
//            if (index[mid] >= x) r = mid;
//            else l = mid + 1;
//        }
//        //index是从0开始，但sum是从1开始，所以返回值要加1
//        return l+1;
//    }
//}