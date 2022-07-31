package Doit.DataStructure_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " "); //읽은 문자열 공백으로 자르기
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(stk.nextToken()); // 수열의 개수 n
        int[] A  = new int[n];

        for (int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            A[i] = Integer.parseInt(stk.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        int num = 1; // 오름차순 자연수
        boolean result = true;
        for (int i=0; i<A.length; i++){
            int current = A[i]; // 현재 수열의 수
            if (current>=num){ // 현재 수열 값 >= 오름차순 자연수
                while(current>=num){ // 현재 수열 값과 오름차순 자연수의 값이 같아질 때까지 push
                    stack.push(num++);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
            }
            else { // 현재 수열 값 < 오름차순 자연수
                int high = stack.pop(); // 스택 가장 위의 수
               if (high > current){ // 스택 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열 출력 불가
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else {
                    sb.append("-").append("\n");
                }
            }
        }

        if (result) System.out.println(sb);
    }
}
