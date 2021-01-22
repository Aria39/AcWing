package b_DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * AcWing 827. 双链表
 */
public class AC827_DoubleList {

    private static int N = 100010;

    //存value
    private static int[] e = new int[N];
    //向左next
    private static int[] l = new int[N];
    //向右next
    private static int[] r = new int[N];
    //每个数的索引值
    private static int idx;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        //0,1充当头结点和尾节点，0向右指向1,1向左指向0
        r[0] = 1;
        l[1] = 0;
        idx = 2;

        while(m-- > 0){
            //建议用数据流，用Scanner.nextLine()会读一次“空”
            String[] str = br.readLine().split(" ");

            if(str[0].equals("L")){
                int var = Integer.parseInt(str[1]);
                addToHead(var);
            }else if(str[0].equals("R")){
                int var = Integer.parseInt(str[1]);
                addToTail(var);
            }else if(str[0].equals("D")){
                int k = Integer.parseInt(str[1]);
                remove(k+1);
            }else if(str[0].equals("IL")){
                int k = Integer.parseInt(str[1]);
                int value = Integer.parseInt(str[2]);
                addRight(l[k+1],value);
                //addLeft(k+1,value);
            }else if(str[0].equals("IR")){
                int k = Integer.parseInt(str[1]);
                int value = Integer.parseInt(str[2]);
                addRight(k+1,value);
            }
        }

        for(int i = r[0]; i != 1; i = r[i]) System.out.print(e[i] + " ");
    }
    //在第k个点的右边插入一个点
    private static void addRight(int k, int x) {
        e[idx] = x;
        r[idx] = r[k];
        l[idx] = k;

        l[r[k]] = idx;
        r[k] = idx;

        idx++;
    }

//    private static void addLeft(int k, int x) {
//        e[idx] = x;
//
//
//        r[l[k]] = idx;
//        l[idx] = l[k];
//
//        r[idx] = k;
//        l[k] = idx;
//
//        idx++;
//    }

    private static void addToTail(int x) {
        e[idx] = x;

        r[l[1]] = idx;
        l[idx] = l[1];

        r[idx] = 1;
        l[1] = idx;

        idx++;
    }

    private static void addToHead(int x) {
        e[idx] = x;

        r[idx] = r[0];
        l[r[0]] = idx;

        r[0] = idx;
        l[idx] = 0;

        idx++;
    }

    //删除第k个点
    private static void remove(int k){
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }
}
