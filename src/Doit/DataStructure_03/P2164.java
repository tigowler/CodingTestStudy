package Doit.DataStructure_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk = new StringTokenizer(br.readLine());

        //input
        int n = Integer.parseInt(stk.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=n; i++){
            q.add(i);
        }

        //process
        int flag = 1;
        while(q.size()>1){
            if (flag==1){
                q.poll();
                flag++;
            }
            else if(flag==2){
                q.add(q.poll());
                flag--;
            }
        }

        System.out.println(q.poll());
    }
}
