package Doit.DataStructure_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P17298 { // stack에 value가 아닌 index 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        //input
        int n = Integer.parseInt(stk.nextToken());
        int[] A = new int[n];
        int[] res = new int[n];
        stk = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++){
            A[i] = Integer.parseInt(stk.nextToken());
        }

        //process
        Stack<Integer> s = new Stack<>();
        s.push(0); // 스택 초기값 추가
        for (int i=1; i<n; i++){
            while(!s.empty() && A[s.peek()]<A[i]){
                res[s.pop()] = A[i];
            }
            s.push(i);
        }

        while(!s.empty()){
            res[s.pop()] = -1;
        }

        for (int i=0; i<n; i++){
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb);
    }
}
