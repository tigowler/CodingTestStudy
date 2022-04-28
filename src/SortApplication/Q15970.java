package SortApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q15970 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static ArrayList<Integer>[] a;


    static void input(){
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        a = new ArrayList[N+1];
        for (int color = 1; color<=N; color++){
            a[color] = new ArrayList<>();
        }
        for (int i = 1; i<=N; i++){
            int coord, color;
            coord = in.nextInt();
            color = in.nextInt();
            a[color].add(coord);
        }
    }

    static int toLeft(int color, int idx){
       if (idx==0) return Integer.MAX_VALUE;
       return a[color].get(idx) - a[color].get(idx-1);
    }

    static int toRight(int color, int idx){
        if (idx==a[color].size()-1) return Integer.MAX_VALUE;
        return a[color].get(idx+1) - a[color].get(idx);
    }

    static void pro(){
        for (int color = 1; color<=N; color++){
            Collections.sort(a[color]);
        }
        int ans = 0;
        for (int color = 1; color<=N; color++){
            for (int i=0; i<a[color].size(); i++){
                int left = toLeft(color, i);
                int right = toLeft(color, i);

                ans+=Math.min(left, right);
            }
        }

        sb.append(ans).append('\n');
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
    }
}
