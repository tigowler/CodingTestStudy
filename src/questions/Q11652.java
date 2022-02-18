package questions;

import java.util.Arrays;
import java.util.Scanner;

public class Q11652 {
    //@Param Current Count: 지금 보고 있는 숫자가 등장한 횟수
    //@Param Mode Count: 지금까지의 최빈값의 등장 횟수
    //@Param Mode: 지금까지의 최빈값
    static StringBuilder sb = new StringBuilder();
    static int N;
    static long[] a;


    static void input(){
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        a = new long[N+1];
        for (int i=1; i<=N; i++){
            a[i] = in.nextLong();
        }
    }

    static void pro(){
        Arrays.sort(a, 1, N+1);

        long mode = a[1];
        int modeCount = 1, curCount = 1;

        for (int i=2; i<=N; i++){
            if (a[i-1]==a[i]){
                curCount ++;
            }
            else {
                curCount = 1;
            }

            if (curCount>modeCount){
                modeCount = curCount;
                mode = a[i];
            }
        }

        sb.append(mode).append('\n');
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
    }
}
