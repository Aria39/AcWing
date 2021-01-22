package b_DataStructure;

import java.util.Scanner;

/**
 * AcWing 835. Trie字符串统计
 */
public class AC835_Trie {

    final static int N = 100010;
    //Trie树中每个节点的所有子节点
    private static int[][] son = new int[N][26];
    //以当前这个点结尾的单词的个数
    private static int[] cnt = new int[N];
    //当前节点的下标（每插入一个节点，会分配一个下标），下标0：既是根节点又是空节点
    private static int idx = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while(n-- != 0){
            String s1 = sc.next();
            String s2 = sc.next();
            if(s1.equals("I")) insert(s2.toCharArray());
            else if(s1.equals("Q")) System.out.println(query(s2.toCharArray()));
        }
    }

    private static void insert(char[] s) {
        //根节点0
        int p = 0;
        //从前往后遍历单词
        for (char c : s) {
            //字母的索引0~25
            int u = c - 'a';
            //不存在，创建
            if(son[p][u] == 0) son[p][u] = ++idx;
            //往下走
            p = son[p][u];
        }
        //结尾节点
        cnt[p]++;
    }

    private static int query(char[] s) {
        int p = 0;
        for (char c : s) {
            int u = c - 'a';
            if(son[p][u] == 0) return 0 ;
            p = son[p][u];
        }
        return cnt[p];
    }
}
