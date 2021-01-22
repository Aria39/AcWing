package c_Search_GraphTheory;

import java.io.*;
import java.util.*;

/**
 * AcWing 845. 八数码
 */
public class AC845_BFS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("\\s+"); //匹配多个空格
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 9; i++) sb.append(s[i]);
        String start = sb.toString();
        String end = "12345678x";

        System.out.println(bfs(start,end));

    }

    private static int bfs(String start, String end) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Map<String,Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        map.put(start,0);
        q.offer(start);

        while(!q.isEmpty()){
            String s = q.poll();
            if(s.equals(end)) return map.get(s);

            int k = s.indexOf('x');
            int x = k / 3;
            int y = k % 3;

            for (int[] dir : dirs) {
                int a = x + dir[0];
                int b = y + dir[1];
                if(a >= 0 && a < 3 && b >= 0 && b < 3){
                    String str = swap(s, k, a*3+b);
                    if(!map.containsKey(str)){
                        map.put(str,map.get(s)+1);
                        q.offer(str);
                    }
                }
            }
        }

        return -1;
    }

    private static String swap(String s, int k, int i) {
        char c1 = s.charAt(i);
        char c2 = s.charAt(k);
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.setCharAt(k,c1);
        sb.setCharAt(i,c2);

        return sb.toString();
    }


}
