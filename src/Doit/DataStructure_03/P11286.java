package Doit.DataStructure_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //input
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if (abs1==abs2) return o1>o2 ? 1: -1; // 절댓값 같으면 음수 우선 정렬
            else return abs1-abs2;
        });

        for (int i=0; i<N; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            if (a==0){
                if (q.isEmpty()) System.out.println(0);
                else System.out.println(q.poll());
            }
            else {
                q.add(a);
            }
        }

    }
}
